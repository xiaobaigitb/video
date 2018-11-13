package com.zhiyou.video.interceptor;

import com.zhiyou.video.annotation.Permission;
import com.zhiyou.video.model.UserModel;
import com.zhiyou.video.service.IFrontUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PermissionInterceptor implements HandlerInterceptor {
    /**
     * Object handler"表示访问这个权限的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Autowired
    IFrontUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断有没有登录
        UserModel user = (UserModel) request.getSession().getAttribute("_front_user");
        if (user==null){
            System.out.println("用户未登录，返回登录页面");
            response.sendRedirect(request.getContextPath()+"/index.do");
        }

        HandlerMethod method = (HandlerMethod) handler;
        //isAnnotationPresent"判断此方法有没有注解
        boolean present = method.getMethod().isAnnotationPresent(Permission.class);
        //如果方法上没有注解-放行
        if (!present){
            return true;
        }else {
            if (user.getRoles()==null){
                user.setRoles(userService.selectRolesById(user.getId()));
            }
            //通过id获取用户的权限
            List<String> roleList = user.getRoles();
            //如果有注解获取方法上的注解的注解内的属性值
            String[] roles = method.getMethod().getAnnotation(Permission.class).role();
            //通过方法获得两个方法的交集
            Collection<String> intersection = CollectionUtils.intersection(roleList, Arrays.asList(roles));
            //判断是否有交集
            if (intersection.size()>0){
                return true;
            }else {
                return false;
            }

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
