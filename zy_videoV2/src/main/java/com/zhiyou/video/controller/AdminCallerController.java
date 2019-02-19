package com.zhiyou.video.controller;

import com.zhiyou.video.mapper.CourseMapper;
import com.zhiyou.video.model.CallerModel;
import com.zhiyou.video.service.IFrontCallerService;
import com.zhiyou.video.util.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zhiyou.video.controller.AdminBaseController.DEFAULT_PAGE;
import static com.zhiyou.video.controller.AdminBaseController.DEFAULT_PAGE_SIZE;

/**
 * @author Administrator
 * 用户管理功能模块
 */
@Controller
@RequestMapping("/admin/caller")
public class AdminCallerController {

    @Autowired
    IFrontCallerService callerService;
    @Autowired
    CourseMapper userService;

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
        PageInfo<CallerModel> list = callerService.queryCallerPageList(map);
        //和上边的index.do用的是同一个页面，所以封装数据的名字也必须一样
        model.addAttribute("pageInfo", list);

//        List<CallerModel> results = callerService.queryCallerModels();
//        model.addAttribute("results", results);
        return "admin/caller/index";
    }

    /**
     * 添加页面
     *
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.GET)
    public String add(CallerModel model) {

//		get方法只负责跳转到填写信息的页面

        return "admin/caller/saveOrUpdate";
    }

    /**
     * 课程添加页面
     *
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public String save(CallerModel model) {
        //调用service的保存方法,service和mapper中的方法自己补充
        //model.setClassTime("6个月");
        int id=callerService.addCallerModel(model);
        System.out.println("新增model为：" + id);
        //保存后重定向到主讲人查询列表页面
        return "redirect:/admin/caller/index.do";
    }

    @RequestMapping("edit.do")
    public String edit(int id, Model model) {
        //根据id查询主讲人信息，然后跳转到编辑页面
        CallerModel caller = callerService.queryCallerById(id);
        System.out.println(caller);

        model.addAttribute("caller", caller);
        return "admin/caller/saveOrUpdate";
    }

    @RequestMapping(value = "edit.do", method = RequestMethod.POST)
    public String editPost(CallerModel speaker, Model model) {
        //得到更新后的主讲人信息

        //更新主讲人的updateTime字段

        //调用service的更新方法

        //打印是否更新成功

        //跳转回主讲人信息列表页面

        return "redirect:/admin/caller/index.do";
    }

    //修改和添加合并在一起
    @RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.POST)
    public String saveOrUpdate(CallerModel model) {

        System.out.println("saveOrUpdate得到的信息：" + model);

        //判断当前请求是添加信息或更新信息
        if (model.getId() > 0) {
            //更新请求
            //model.setClassTime("6个月");
            //调用更新方法
            boolean b = callerService.updateCallerById(model);
            System.out.println("---------------------------");
            System.out.println("更新主讲人信息是否成功：" + b);
        } else {
            //新增请求
            //model.setClassTime("6个月");
            //调用新增方法
            int id = callerService.addCallerModel(model);
            System.out.println("新增主讲人信息，id为" + id);
        }

        return "redirect:/admin/caller/index.do";
    }


    //删除方法
    @ResponseBody
    @RequestMapping("delete.do")
    public Map delete(int id) {
        //根据id删除
        boolean b = callerService.deleteById(id);
		//封装结果
		HashMap map = new HashMap();
		if(b){
			//删除成功
			map.put("success", true);
		}else{
			map.put("success", false);
			map.put("message", "删除视频信息失败，请重试");
		}

		return map;

        //return "redirect:/admin/caller/index.do";
    }


}
