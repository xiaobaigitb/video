package com.zhiyou.video.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou.video.model.SpeakerModel;
import com.zhiyou.video.service.ISpeakerService;
import com.zhiyou.video.util.PageInfo;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Administrator
 * 主讲人管理功能模块
 */
@Controller
@RequestMapping("/admin/speaker")
public class SpeakerController extends AdminBaseController {

    @Autowired
    ISpeakerService speakerService;

    /**
     * 主讲人列表查询页面,没有使用查询条件，暂时不用
     * @return
     */
/*	@RequestMapping("index.do")
	public String index(Model model){

		System.out.println(">>>>>>>SpeakerController index");

		List<SpeakerModel> list = speakerService.querySpeakers();

		System.out.println(list);

		model.addAttribute("results", list);

		return "admin/speaker/index";
	}*/

    /**
     * 根据条件查询主讲人信息
     * 添加分页
     */
    @RequestMapping("/index.do")
    public String query(String queryName, String queryJob, @RequestParam(required = false) Integer pageNum, Model model) {
        System.out.println("pppp----: "+pageNum);
        //根据主讲人名称和主讲人职位查询信息
        HashMap map = new HashMap();
        map.put("queryName", queryName);
        map.put("queryJob", queryJob);
        if (pageNum == null || pageNum < 0) pageNum = DEFAULT_PAGE;
        map.put("pageNum", pageNum);
        map.put("pageSize", DEFAULT_PAGE_SIZE);
        //添加分页相关操作

        PageInfo<SpeakerModel> list = speakerService.querySpeakerPageList(map);
        System.out.println("list---: "+list);
        //和上边的index.do用的是同一个页面，所以封装数据的名字也必须一样
        model.addAttribute("pageInfo", list);

        model.addAttribute("queryName", queryName);
        model.addAttribute("queryJob", queryJob);
        return "admin/speaker/index";
    }


    /**
     * 添加页面
     *
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.GET)
    public String add(SpeakerModel model) {

//		get方法只负责跳转到填写信息的页面

        return "admin/speaker/saveOrUpdate";
    }

    /**
     * 提交添加的信息
     *
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public String save(SpeakerModel model) {

        //model的其它字段通过页面添加并提交到后台

        model.setInsertTime(new Date());
        model.setUpdateTime(new Date());
        System.out.println(model);

        //调用service的保存方法,service和mapper中的方法自己补充
        int id = speakerService.addSpeakerModel(model);
        System.out.println("新增model id为：" + id);
        //保存后重定向到主讲人查询列表页面
        return "redirect:/admin/speaker/index.do";
    }

    //修改方法，参考添加方法来做

    /**
     * 跳转到修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "edit.do", method = RequestMethod.GET)
    public String edit(int id, Model model) {
        //根据id查询主讲人信息，然后跳转到编辑页面
        SpeakerModel speaker = speakerService.querySpeakerById(id);
        System.out.println(speaker);

        model.addAttribute("speaker", speaker);
        return "admin/speaker/saveOrUpdate";
    }

    @RequestMapping(value = "edit.do", method = RequestMethod.POST)
    public String editPost(SpeakerModel speaker, Model model) {
        //得到更新后的主讲人信息

        //更新主讲人的updateTime字段

        //调用service的更新方法

        //打印是否更新成功

        //跳转回主讲人信息列表页面

        return "redirect:/admin/speaker/index.do";
    }


    //修改和添加合并在一起
    @RequestMapping(value = "saveOrUpdate.do", method = RequestMethod.POST)
    public String saveOrUpdate(SpeakerModel model) {

        System.out.println("saveOrUpdate得到的信息：" + model);

        //判断当前请求是添加信息或更新信息
        if (model.getId() > 0) {
            //更新请求
            model.setUpdateTime(new Date());
            //调用更新方法
            boolean b = speakerService.updateSpeakerById(model);
            System.out.println("更新主讲人信息是否成功：" + b);
        } else {
            //新增请求
            model.setInsertTime(new Date());
            model.setUpdateTime(new Date());
            //调用新增方法
            int id = speakerService.addSpeakerModel(model);
            System.out.println("新增主讲人信息，id为" + id);
        }

        return "redirect:/admin/speaker/index.do";
    }


    //删除方法
    @ResponseBody
    @RequestMapping("delete.do")
    public Map delete(int id) {
        //根据id删除
        boolean b = speakerService.deleteById(id);
        //封装结果
        HashMap map = new HashMap();
        if (b) {
            //删除成功
            map.put("success", true);
        } else {
            map.put("success", false);
            map.put("message", "删除视频信息失败，请重试");
        }
        return map;
        //return "redirect:/admin/speaker/index.do";
    }
}
