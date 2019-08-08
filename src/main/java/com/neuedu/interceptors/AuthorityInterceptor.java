package com.neuedu.interceptors;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthorityInterceptor implements HandlerInterceptor{

    @Autowired
    IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(request.getRequestURI().indexOf("/login")>0) {
            return true;
        }
        if(request.getSession().getAttribute(Const.CURRENT_USER)!=null) {
            return true;
        }

        Cookie[] cookies=request.getCookies();
        String username1=null;
        String password1=null;
        if(cookies!=null&&cookies.length>0){
            for(Cookie c:cookies){
                if(c.getName().equals("username")){
                    username1=c.getValue();
                }
                if(c.getName().equals("password")){
                    password1=c.getValue();
                }
            }
        }
        UserInfo userInfo=null;
        if(username1!=null&&password1!=null){//根据用户名和密码自动登录
            userInfo=new UserInfo(username1,password1);
        }
        UserInfo userInfo1=userService.login(userInfo);
        if(userInfo1!=null){
            return true;
        }
        try {
            response.sendRedirect("/user/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("preHandle");
        return false;//false为拦截，true为通过，不拦截
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.out.println("afterCompletion");
    }
}
