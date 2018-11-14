package com.zhiyou.video.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.zhiyou.video.bean.RegistResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.video.bean.LoginResult;
import com.zhiyou.video.bean.OperateResult;
import com.zhiyou.video.mapper.FrontUserMapper;
import com.zhiyou.video.model.UserModel;
import com.zhiyou.video.query.RegistUserInfo;
import com.zhiyou.video.query.UpdatePwdInfo;
import com.zhiyou.video.service.IFrontUserService;
import com.zhiyou.video.util.MD5Utils;

/**
 * Descr: 前台用户管理功能service
 */
@Service
public class FrontUserServiceImpl implements IFrontUserService {

    @Autowired
    FrontUserMapper mapper;

    @Override
    public RegistResult registUser(RegistUserInfo userInfo) {
        RegistResult result = new RegistResult();
        //注册用户的时候一定要检查注册的邮箱是否有效，是否被注册了
        //两次输入密码是否一致应该在页面和控制器校验，这里不做检查
        UserModel user = mapper.queryUserByEmail(userInfo.getEmail());
        if (user == null) {
            //可以注册
            user = new UserModel();
            user.setEmail(userInfo.getEmail());
            user.setPassword(MD5Utils.getMd5Simple(userInfo.getPassword()));
            user.setInsertTime(new Date());
            user.setUpdateTime(new Date());
            int i = mapper.insertUserModel(user);
            if (i > 0) {
                //数据添加成功，才算注册成功，然后把当前的用户信息也返回给控制器使用
                result.setSuccess(true);
                result.setUser(user);
            } else {
                //数据添加失败，注册失败，给出提示信息
                result.setSuccess(false);
                result.setMessage("注册用户失败，请重试");
            }
        } else {
            //邮箱已注册
            result.setSuccess(false);
            result.setMessage("邮箱已被注册，请更换邮箱");
        }
        return result;
    }

    @Override
    public LoginResult loginUser(String email, String pwd) {
        LoginResult result = new LoginResult();
        //根据用户登录的邮箱查询用户信息，然后再比较密码是否正确，这样在登录失败的情况下，失败的原因可以提示的更明确
        UserModel user = mapper.queryUserByEmail(email);
        if (user == null) {
            //登录失败，邮箱不存在
            result.setSuccess(false);
            result.setMessage("登录失败，邮箱账户不存在");
        } else {
            //账户存在，比较密码是否正确
            if (user.getPassword().equals(MD5Utils.getMd5Simple(pwd))) {
                //密码相等，登录成功
                result.setSuccess(true);
                result.setMessage("登录成功");
                result.setUser(user);
            } else {
                //密码不等，密码错误
                result.setSuccess(false);
                result.setMessage("密码错误，请重试");
            }
        }

        return result;
    }

    @Override
    public UserModel queryUserByEmail(String email) {
        return mapper.queryUserByEmail(email);
    }

    @Override
    public boolean updateUserPwd(int id, String pwd) {
        HashMap map = new HashMap();
        map.put("id", id);
        map.put("pwd", pwd);
        int i = mapper.updateUserPwd(map);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void cleanCaptcha(String email) {
        HashMap map = new HashMap();
        map.put("email", email);
        map.put("captcha", null);
        mapper.updateCaptcha(map);
    }

    @Override
    public void updateUserCaptcha(String email, String captcha) {
        HashMap map = new HashMap();
        map.put("email", email);
        map.put("captcha", captcha);
        mapper.updateCaptcha(map);
    }

    @Override
    public UserModel queryUserById(int id) {
        return mapper.queryUserById(id);
    }

    @Override
    public boolean updateUserInfo(UserModel model) {
        int i = mapper.updateUserInfo(model);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserHead(int id, String head) {
        HashMap map = new HashMap();
        map.put("id", id);
        map.put("head", head);
        int i = mapper.updateUserHead(map);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public OperateResult updateUserPassword(int id, UpdatePwdInfo info) {
        UserModel model = queryUserById(id);
        OperateResult result = new OperateResult();
        if (model.getPassword().equals(MD5Utils.getMd5Simple(info.getOldPassword()))) {
            HashMap map = new HashMap();
            map.put("id", id);
            map.put("pwd", MD5Utils.getMd5Simple(info.getNewPassword()));
            mapper.updateUserPwd(map);
            result.setSuccess(true);
            result.setMessage("更新成功");
        } else {
            result.setSuccess(false);
            result.setMessage("旧密码输入错误");
        }
        return result;
    }

    @Override
    public List<String> selectRolesById(int id) {
        return mapper.selectRolesById(id);
    }

    @Override
    public List<UserModel> selectUserList() {
        return mapper.selectUserList();
    }

    @Override
    public void updateUserStatus(int userId) {
        mapper.updateUserStatus(userId);
    }

}
