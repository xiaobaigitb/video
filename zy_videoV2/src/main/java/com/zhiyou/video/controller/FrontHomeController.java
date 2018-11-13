package com.zhiyou.video.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.video.model.UserModel;
import com.zhiyou.video.query.ResetPwdInfo;
import com.zhiyou.video.service.IFrontUserService;
import com.zhiyou.video.util.MD5Utils;
import com.zhiyou.video.util.RandomCode;
import com.zhiyou.video.util.SendEmailUtil;
import com.zhiyou.video.util.ValidateCode;

/**
 * Descr: 负责前台首页的跳转
 *
 */
@Controller
public class FrontHomeController extends FrontBaseController{

	@Autowired
	IFrontUserService userService;
	
	/**
	 * 首页跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index.do")
	public String index(){
		
		return "front/index";
	}
	
	/**
	 * 跳到找回密码页面，包括发邮件获取验证码、重置密码
	 * 
	 * @return
	 */
	@RequestMapping(value="forgetpwd.do",method=RequestMethod.GET)
	public String findPassword(){
		
		return "front/user/forget_pwd";
	}
	
	/**
	 * 请求发送邮件，目前来说只有找回密码有发送邮件功能，如果多个功能都有，就要考虑复用性和url名字可识性
	 * 改为ajax方式 2017-07-25
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="sendemail.do",method=RequestMethod.POST)
	public Map sendEmail(String email){
		HashMap map = new HashMap();
		//根据给定的邮箱发送邮件
		UserModel user = userService.queryUserByEmail(email);
		if(user==null){
			//用户为空，说明填写的邮箱就不对
			map.put("false", false);
			map.put("message","邮箱账号不存在");
			return map;
		}
		//先生成验证码，先发送邮件，发送成功后保存验证码
		String captcha = RandomCode.getRandomCode(CAPTCHA_LENGTH);
		//先发送验证码，发送成功了再保存到数据库
		boolean b = SendEmailUtil.sendPasswordCaptchaEmail(email,captcha);
		if(b){
			//发送成功，保存
			map.put("success", true);
			map.put("message", "验证码已发送到您的邮箱，请注意查收");
			userService.updateUserCaptcha(email,captcha);
		}else{
			//发送失败，提醒
			map.put("false", false);
			map.put("message","验证码发送失败，请检查邮箱账号");
		}
		
		return map;
	}
	
	/**
	 * 提交邮箱和收到的验证码信息
	 * 
	 * @return
	 */
	@RequestMapping(value="forgetpwd.do",method=RequestMethod.POST)
	public String findPasswordPost(String email,String captcha,Model model){
		//校验验证码和邮箱信息是否有效
		UserModel user = userService.queryUserByEmail(email);
		if(user==null){
			//用户为空，说明填写的邮箱就不对
			model.addAttribute("message","邮箱账号不存在");
		}else{
			if(captcha!=null&&!captcha.equals("")&&captcha.equals(user.getCaptcha())){
				//验证成功了，返回重置密码的页面
				model.addAttribute("email", email);
				model.addAttribute("captcha", captcha);
				
				return "front/user/reset_pwd";
			}else{
				//验证码不对或验证码不存在
				model.addAttribute("message","验证码不正确或不存在");
			}
		}
		
		return "front/user/forget_pwd";
	}
	
	/**
	 * 提交重置密码请求，包括新密码、邮箱接收的验证码等
	 * 
	 * @return
	 */
	@RequestMapping(value="resetpwd.do",method=RequestMethod.POST)
	public String resetPassword(ResetPwdInfo info,Model model){
		//重置密码
		//先检查提交的邮箱和验证码信息是否有效，和上一步的验证一样，然后再去更新此邮箱的用户密码
		//这里都省略了数据校验
		//校验验证码和邮箱信息是否有效
		UserModel user = userService.queryUserByEmail(info.getEmail());
		if(user==null){
			//用户为空，说明填写的邮箱就不对
			model.addAttribute("message","邮箱账号不存在");
		}else{
			String captcha = info.getCaptcha();
			if(captcha!=null&&!captcha.equals("")&&captcha.equals(user.getCaptcha())){
				//验证成功了，返回重置密码的页面
				//验证成功了，更新密码，然后跳转到首页，重新让用户登录
				userService.updateUserPwd(user.getId(),MD5Utils.getMd5Simple(info.getPassword()));
				//删除验证码
				userService.cleanCaptcha(user.getEmail());
				model.addAttribute("message", "密码更新成功了，请重新登录");
				return "front/message";
				//跳到首页了，其实应该用ajax，返回个更新成功的消息的
//				return "redirect:/index.do";
			}else{
				//验证码不对或验证码不存在
				model.addAttribute("message","验证码不正确或不存在");
			}
		}
		
		return "front/user/forget_pwd";
	}
	
	@RequestMapping("/validateimg.do")
	public void validateImg(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("image/jpeg");  
		response.setHeader("Pragma", "no-cache");  
		response.setHeader("Cache-Control", "no-cache");  
		response.setDateHeader("Expires", 0);  
		ValidateCode vCode = new ValidateCode(100,30,4,100);  
		HttpSession session = request.getSession();  
		session.removeAttribute("validateCode");  
		try {
			vCode.write(response.getOutputStream());
			session.setAttribute("validateCode", vCode.getCode());  
			vCode.write(response.getOutputStream());  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
}
