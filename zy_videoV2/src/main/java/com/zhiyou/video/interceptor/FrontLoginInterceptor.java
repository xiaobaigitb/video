package com.zhiyou.video.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Descr: 实现前台登录校验的拦截器
 *
 */
public class FrontLoginInterceptor implements HandlerInterceptor {

	/**
	 * 调用控制器方法之前执行
	 * 
	 * 一般用户校验用户是否登录
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("front interceptor:"+request.getRequestURL());
		
		//获取session，从session中读取用户登录后set好的信息
		//如果获取不到信息，说明用户未登录，如果读取到了，说明用户已经登录可以继续操作
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("_front_user");
		//判断
		if(obj==null){
			System.out.println("用户未登录，返回登录页面");
			//返回登录页面的时候，最好是重定向回去，而不是直接返回login.jsp，
			// 否则会导致浏览器的URL和页面显示的内容不匹配
			response.sendRedirect(request.getContextPath()+"/index.do");
		}else{
			System.out.println("用户已登录："+obj);
			return true;
		}
		
		return false;
	}

	/**
	 * 调用控制器方法之后，渲染视图页面之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 渲染完视图，将要返回给用户最终结果的时候执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
