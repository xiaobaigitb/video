package com.zhiyou.video.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zhiyou.video.bean.RegistResult;
import com.zhiyou.video.model.CallerModel;
import com.zhiyou.video.model.VipModel;
import com.zhiyou.video.service.IFrontCallerService;
import com.zhiyou.video.service.VipService;
import com.zhiyou.video.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.video.bean.LoginResult;
import com.zhiyou.video.bean.OperateResult;
import com.zhiyou.video.model.UserModel;
import com.zhiyou.video.query.RegistUserInfo;
import com.zhiyou.video.query.UpdatePwdInfo;
import com.zhiyou.video.service.IFrontUserService;

/**
 * Descr: 前台用户的管理功能，包括登录、注册、用户资料更新等
 * <p>
 * 以下的功能先省略了数据校验部分
 */
@Controller
@RequestMapping("/front/user")
public class FrontUserController extends FrontBaseController {

    @Autowired
    IFrontUserService userService;

    @Autowired
    private VipService vipService;

    /**
     * 提交登录信息
     *
     * @return ResponseBody:会将当前方法返回的数据直接放入到response的body中，不经过视图解析器
     */
    @ResponseBody
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public Object login(String email, String password, HttpSession session) {
        //先登录
        //登录失败返回页面，登录成功将用户信息放到session中
        LoginResult result = userService.loginUser(email, password);
        //用来封装登录结果信息，最终是转换为json返回到页面
        HashMap map = new HashMap();

        if (!result.isSuccess()) {
            //登录失败
            map.put("false", false);
            map.put("message", result.getMessage());
        } else {
            //登录成功
            loginSession(session, result.getUser());
            map.put("success", true);
        }
        //登录成功，重定向到首页，页面的header部分会显示当前登录用户的信息
        return map;
    }

    @RequestMapping("logout.do")
    public String logout(HttpSession session) {

        logoutSession(session);

        return "redirect:/index.do";
    }

    /**
     * 提交信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "regist.do", method = RequestMethod.POST)
    public Object regist(RegistUserInfo userInfo, HttpServletRequest request) {
        //注册功能，得到注册信息，然后调用service的注册方法，得到注册结果
        RegistResult result = userService.registUser(userInfo);
        //用来封装登录结果信息，最终是转换为json返回到页面
        HashMap map = new HashMap();
        if (!result.isSuccess()) {
            map.put("false", false);
            map.put("message", result.getMessage());
            return map;
        }
        //注册成功，直接就登录了
        loginSession(request.getSession(), result.getUser());
        map.put("success", true);
        //登录成功，重定向到首页，页面的header部分会显示当前登录用户的信息
        return map;
    }

    @RequestMapping("/vipIndex.do")
    public String index() {

        return "front/01-vip/vip";
    }

    /**
     * 提交信息
     *
     * @return
     */
    //@ResponseBody
    @RequestMapping(value = "vip.do", method = RequestMethod.POST)
    public String openIip(VipModel vipModel, HttpServletRequest request) {

        vipService.addVipUser(vipModel);
        //将用户的状态设置为0
        String email = vipModel.getEmail();
        userService.updateUserStatusByEmail(email);


        request.getSession().setAttribute("vipUser", vipModel);
        ResponseVo aaa = new ResponseVo(200, "开通成功", vipModel);
        System.out.println(aaa.toString());
        //return aaa;
        return "redirect:/index.do";
    }


    /**
     * 跳转到个人中心，显示个人基本资料信息
     *
     * @return
     */
    @RequestMapping(value = "index.do", method = RequestMethod.GET)
    public String profile(HttpSession session, Model model) {
        //根据当前用户查询基本信息，然后返回个人中心页面
        UserModel user = getCurrentUser(session);
        model.addAttribute("user", user);
        return "front/user/index";
    }

    /**
     * 跳转到更新个人基本资料页面
     *
     * @return
     */
    @RequestMapping(value = "profile.do", method = RequestMethod.GET)
    public String updateProfileGet(HttpSession session, Model model) {
        //从数据库重新查询，不使用session中的信息
        UserModel user = getCurrentUser(session);
        //根据id获取当前用户的最新信息
        UserModel cuser = userService.queryUserById(user.getId());

        model.addAttribute("user", cuser);

        return "front/user/profile";
    }

    /**
     * 提交并更新个人基本资料
     *
     * @return
     */
    @RequestMapping(value = "profile.do", method = RequestMethod.POST)
    public String updateProfilePost(UserModel user, HttpSession session) {
        System.out.println(">>>更新个人信息：" + user);
        String birthdayStr = user.getBirthdayStr();
        if (birthdayStr != null && birthdayStr.length() > 0) {
            //将2017/07/20格式的字符串反解析为Date类型数据，参考 java.text.SimpleDateFormat
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = format.parse(birthdayStr);
                user.setBirthday(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //更新时间
        user.setUpdateTime(new Date());

        //从session中将当前用户的id拿出来，赋给更新信息的model类
        UserModel cuser = getCurrentUser(session);
        user.setId(cuser.getId());
        //更新用户信息
        userService.updateUserInfo(user);

        //如果session中存储的有可更新的字段信息，更新session中的用户信息
        user = userService.queryUserById(cuser.getId());
        //调用一次登录后的方法
        loginSession(session, user);

        return "redirect:/front/user/index.do";
    }

    /**
     * 跳转到更新个人密码页面
     *
     * @return
     */
    @RequestMapping(value = "password.do", method = RequestMethod.GET)
    public String updatePwdGet(HttpSession session, Model model) {
        //根据当前用户查询基本信息，然后返回个人中心页面
        UserModel user = getCurrentUser(session);

        model.addAttribute("user", user);

        return "front/user/password";
    }

    /**
     * 提交并更新个人密码
     *
     * @return
     */
    @RequestMapping(value = "password.do", method = RequestMethod.POST)
    public String updatePwdPost(UpdatePwdInfo info, Model model, HttpSession session) {
        UserModel user = getCurrentUser(session);

        //判断旧密是否正确，不正确禁止更新
        //此处未做数据校验
        OperateResult result = userService.updateUserPassword(user.getId(), info);
        //判断是否更改成功，根据结果给出不同的提示信息
        //应该是ajax操作的，这里先做表单的，学了ajax后更改
        if (result.isSuccess()) {
            model.addAttribute("message", "密码更新成功");
        } else {
            model.addAttribute("message", "密码更新失败：" + result.getMessage());
        }
        return "front/user/password";
    }

    /**
     * 跳转到更新个人头像地址
     *
     * @return
     */
    @RequestMapping(value = "avatar.do", method = RequestMethod.GET)
    public String updateHeadGet(HttpSession session, Model model) {
        //从session中获取当前用户的信息
        //从数据库重新查询，不使用session中的信息
        UserModel user = getCurrentUser(session);
        //根据id获取当前用户的最新信息
        UserModel cuser = userService.queryUserById(user.getId());

        model.addAttribute("user", cuser);

        return "front/user/avatar";
    }


    /**
     * 提交并更新个人头像
     *
     * @return
     */
    @RequestMapping(value = "avatar.do", method = RequestMethod.POST)
    public String updateHeadPost(@RequestParam("image_file") MultipartFile image, HttpServletRequest request) {
        System.out.println(image.getContentType());
        System.out.println(image.getName());
        System.out.println(image.getOriginalFilename());
        System.out.println(image.getSize());

        //指定保存文件的目录和文件名
        //保存的目录  D:\soft\idea\zy_videoV2\zy_videoV2\src\main\webapp
        String pdir = request.getServletContext().getRealPath("/");//tomcat运行环境目录，当前项目的根目录
        System.out.println(pdir);
        //文件的类型
        String subfix = image.getOriginalFilename().substring(image.getOriginalFilename().indexOf("."));
        //文件的名字
        String name = System.currentTimeMillis() + "_head" + subfix;
        //保存文件
        String dest = pdir + name;
        File file = new File(dest);
        System.out.println(file.toString());
        //保存文件
        try {
            image.transferTo(new File(dest));
            //保存成功后，需要更新用户的头像
            UserModel user = getCurrentUser(request.getSession());
            //更新头像信息
            userService.updateUserHead(user.getId(), name);
            //如果session中存储的有可更新的字段信息，更新session中的用户信息
            user = userService.queryUserById(user.getId());
            //调用一次登录后的方法
            loginSession(request.getSession(), user);

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/front/user/index.do";
    }
}
