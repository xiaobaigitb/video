package com.zhiyou.video.service.impl;

import com.zhiyou.video.bean.CallerResult;
import com.zhiyou.video.bean.RegistResult;
import com.zhiyou.video.mapper.FrontCallerMapper;
import com.zhiyou.video.model.CallerModel;
import com.zhiyou.video.model.UserModel;
import com.zhiyou.video.service.IFrontCallerService;
import com.zhiyou.video.util.MD5Utils;
import com.zhiyou.video.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mr.lu
 * @Title: FrontCallerServiceImpl
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/12:19:01
 */
@Service
public class FrontCallerServiceImpl implements IFrontCallerService {
    @Autowired
    FrontCallerMapper callerMapper;

    @Override
    public CallerResult saveCaller(CallerModel userInfo) {
        CallerResult result = new CallerResult();
        //注册用户的时候一定要检查注册的邮箱是否有效，是否被注册了
        //两次输入密码是否一致应该在页面和控制器校验，这里不做检查
        CallerModel caller = callerMapper.queryCallerByTel(userInfo.getTel());
        if (caller == null) {
            //可以注册
            caller = new CallerModel();
            caller.setTel(userInfo.getTel());
            caller.setVisitorName(userInfo.getVisitorName());
            caller.setAge(userInfo.getAge());
            caller.setSex(userInfo.getSex());
            caller.setIntent(userInfo.getIntent());
            int i = callerMapper.saveCaller(userInfo);
            if (i > 0) {
                //数据添加成功，才算注册成功，然后把当前的用户信息也返回给控制器使用
                result.setSuccess(true);
                result.setCaller(caller);
            } else {
                //数据添加失败，注册失败，给出提示信息
                result.setSuccess(false);
                result.setMessage("用户预约失败，请重试");
            }
        } else {
            //邮箱已注册
            result.setSuccess(false);
            result.setMessage("邮箱已被注册，请更换邮箱");
//        }
        }
        return result;
    }

    @Override
    public List<CallerModel> queryCallerModels() {
        return callerMapper.queryCallerModels();
    }

    @Override
    public boolean deleteById(int id) {
        return callerMapper.deleteById(id);
    }

    @Override
    public CallerModel queryCallerById(int id) {
        return callerMapper.queryCallerById(id);
    }

    @Override
    public boolean updateCallerById(CallerModel model) {
        return callerMapper.updateCallerById(model);
    }

    @Override
    public int addCallerModel(CallerModel model) {
        int i=callerMapper.addCallerModel(model);
        return model.getId();
    }

    @Override
    public PageInfo<CallerModel> queryCallerPageList(HashMap map) {
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        int allNum = 0;//总数量
        int pageNums = 0;//总页数

        allNum = callerMapper.queryCallerListCount(map);
        if(allNum%pageSize==0){
            pageNums = allNum/pageSize;
        }else{
            pageNums = allNum/pageSize+1;
        }

        int start = (pageNum-1)*pageSize;//查询sql数据的起始位置

        //查询数据
        map.put("start", start);
        List<CallerModel> result = callerMapper.queryCallerPageList(map);

        //封装
        PageInfo<CallerModel> pageinfo = new PageInfo<CallerModel>();
        pageinfo.setAllNum(allNum);
        pageinfo.setPageNum(pageNum);
        pageinfo.setPageNums(pageNums);
        pageinfo.setPageSize(pageSize);
        pageinfo.setResults(result);

        return pageinfo;

//        return callerMapper.queryCallerPageList(map);
    }
}
