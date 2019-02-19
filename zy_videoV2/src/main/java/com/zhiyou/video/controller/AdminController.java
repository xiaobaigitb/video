package com.zhiyou.video.controller;

import java.util.HashMap;
import java.util.List;


import com.zhiyou.video.model.*;
import com.zhiyou.video.service.*;
import com.zhiyou.video.util.MD5Utils;
import com.zhiyou.video.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.zhiyou.video.controller.AdminBaseController.DEFAULT_PAGE;
import static com.zhiyou.video.controller.AdminBaseController.DEFAULT_PAGE_SIZE;

/**
 * @author Administrator
 * 用户管理功能模块
 */
@Controller
@RequestMapping("/admin/user")
public class AdminController {

    @Autowired
    IFrontUserService userService;
    @Autowired
    ISubjectService subjectService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRoleService userRoleService;


    /**
     * 用户列表页面
     *
     * @return
     */
    @RequestMapping("index.do")
    public String index(@RequestParam(required = false) Integer pageNum, Model model) {
        //根据主讲人名称和主讲人职位查询信息
        HashMap map = new HashMap();
        if (pageNum == null || pageNum < 0) pageNum = DEFAULT_PAGE;
        map.put("pageNum", pageNum);
        map.put("pageSize", DEFAULT_PAGE_SIZE);
        //添加分页相关操作
        PageInfo<UserModel> list = userService.queryUserPageList(map);
        //和上边的index.do用的是同一个页面，所以封装数据的名字也必须一样
        model.addAttribute("pageInfo", list);

//        List<UserModel> results = userService.queryUserModels();
//        model.addAttribute("results", results);
        return "admin/user/index";
    }

    /**
     * 课程添加页面
     *
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.GET)
    public String addGet(Model model) {
        querys(model);

        return "admin/user/saveOrUpdate";
    }

    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public String addPost(UserModel model) {

        //获取用户id以及用户权限id和用户课程id
        int userId = model.getId();
        int roleId = model.getRoleId();
        int subjectId = model.getSubjectId();
        System.out.println("model.getId()>0---" + userId + "_---" + roleId + "------" + subjectId);
        //将权限保存到权限用户表
        //userRoleService.addUserRoleModelByUserId(userId,roleId);
        //todo updateUserInfo 方法有误，还要多表修改添加事物。
        boolean b = userService.updateUserById(model);
        System.out.println("更新视频信息是否成功：" + b);

        return "redirect:/admin/user/index.do";

//		if(result.hasErrors()){
//			mo.addAttribute("message", result.getAllErrors());
//			querys(mo);
//			return "admin/user/saveOrUpdate";
//		}
//
//		return saveOrUpdate(model,mo);
    }

    @RequestMapping("edit.do")
    public String edit(int id, Model model) {

        //根据id查询主讲人信息，然后跳转到编辑页面
        UserModel user = userService.queryUserById(id);
        System.out.println(user);
        querys(model);
        model.addAttribute("user", user);
        return "admin/user/saveOrUpdate";
    }

    @RequestMapping(value = "edit.do", method = RequestMethod.POST)
    public String editPost(UserModel model, Model mo) {
        return "redirect:/admin/user/index.do";
    }

    //修改和添加合并在一起
    @RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.POST)
    public String saveOrUpdate(UserModel model) {
        System.out.println("saveOrUpdate得到的信息：" + model);
        //将前台
        String sexView = model.getSexView();
        System.out.println("sexView " + sexView);
        if (sexView.equals("男")) {
            model.setSex(1);
        } else if (sexView.equals("女")) {
            model.setSex(2);
        }
        //将前台密码转换成MD5值保存
        String loginPwd = model.getPassword();
        String pwd = MD5Utils.getMd5Simple(loginPwd);
        model.setPassword(pwd);
        //querys(mo);
        //判断当前请求是添加信息或更新信息
        if (model.getId() > 0) {
            //更新请求
            //获取用户id以及用户权限id和用户课程id
            int userId = model.getId();
            int roleId = model.getRoleId();
            int subjectId = model.getSubjectId();
            System.out.println("model.getId()>0---" + userId + "_---" + roleId + "------" + subjectId);
            //todo 将权限保存到权限用户表

            userRoleService.updateUserRoleModelByUserId(userId, roleId);
            //todo updateUserInfo 方法有误，还要多表修改添加事物。
            boolean b = userService.updateUserById(model);
            System.out.println("更新视频信息是否成功：" + b);
        } else {
            //新增请求
            //获取用户id以及用户权限id和用户课程id
            int userId = model.getId();
            int roleId = model.getRoleId();
            int subjectId = model.getSubjectId();
            System.out.println("model.getId()<0---" + userId + "-----" + roleId + "------" + subjectId);
            //todo 将权限保存到权限用户表,根据用户id修改权限id
            userRoleService.addUserRoleModelByUserId(userId, roleId);
            //调用新增方法
            int id = userService.addUserModel(model);
            System.out.println("新增视频信息，id为" + id);
        }
        return "redirect:/admin/user/index.do";
    }

    //删除方法
    @RequestMapping("delete.do")
    public String delete(int id) {
        //根据id删除
        boolean b = userService.deleteById(id);
//		//封装结果
//		HashMap map = new HashMap();
//		if(b){
//			//删除成功
//			map.put("success", true);
//		}else{
//			map.put("success", false);
//			map.put("message", "删除视频信息失败，请重试");
//		}
//
//		return map;

        return "redirect:/admin/user/index.do";
    }

    private void querys(Model model) {
        //查询条件
        List<SubjectModel> subjectModels = subjectService.querySubjects();
        List<RoleModel> roles = roleService.queryRoles();
        model.addAttribute("subjects", subjectModels);
        model.addAttribute("roles", roles);
        System.out.println("roles: " + roles.toString());
    }

}
