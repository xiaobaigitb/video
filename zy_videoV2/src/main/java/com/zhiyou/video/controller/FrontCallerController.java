package com.zhiyou.video.controller;

import com.zhiyou.video.model.CallerModel;
import com.zhiyou.video.service.IFrontCallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mr.lu
 * @Title: FrontCallerController
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/12:19:33
 */
@Controller
@RequestMapping("/front")
public class FrontCallerController {

    @Autowired
    IFrontCallerService callerService;
    /**
     * 用于保存报名人员的信息，提交之后跳转到登录页面
     * @param caller
     * @return
     */
    @RequestMapping("/caller.do")
    public String saveCaller(CallerModel caller){
        callerService.saveCaller(caller);
        System.out.println(caller);
        return "redirect:/front/user/index.do";
    }
}
