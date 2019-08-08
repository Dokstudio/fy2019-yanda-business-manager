package com.neuedu.controller;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(UserInfo userInfo, HttpSession session, HttpServletResponse response) {

        UserInfo loginUserInfo=userService.login(userInfo);
        System.out.println(loginUserInfo);
        if(loginUserInfo!=null){
            session.setAttribute(Const.CURRENT_USER,loginUserInfo);
            Cookie username_cookie=new Cookie("username",userInfo.getUsername());
            Cookie password_cookie=new Cookie("password",userInfo.getPassword());
            username_cookie.setMaxAge(60*60*24*7);
            password_cookie.setMaxAge(60*60*24*7);
            response.addCookie(username_cookie);
            response.addCookie(password_cookie);
            return "redirect:home";
        }
        return "login";
    }

    @RequestMapping("home")
    public String home(){
        return "home";
    }

    //查看所有的管理员
    @RequestMapping("Admin/find")
    public  String findAll(HttpSession session){
        List<UserInfo> userInfoAdminList=userService.findAllAdmin();
        session.setAttribute("userInfoAdminList",userInfoAdminList);
        return "userinfoAdminlist";
    }

//    //增加一个管理员
//    @RequestMapping(value = "Admin/adminAdd/{id}", method = RequestMethod.GET)
//    public String insertAdmin(UserInfo userInfo){
//
//
//        return "adminAdd";
//    }
//    @RequestMapping(value = "Admin/adminAdd/{id}", method = RequestMethod.POST)
//    public String insertAdmin(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//
//        return "adminAdd";
//    }


    //修改一个管理员的信息
    @RequestMapping(value = "Admin/adminUpdate/{id}",method = RequestMethod.GET)
    public String updateAdmin(@PathVariable("id")Integer userId,
                              HttpServletRequest request){
        UserInfo userInfo=userService.findUserInfoById(userId);

        request.setAttribute("userInfo",userInfo);
        return "adminUpdate";
    }
    @RequestMapping(value = "Admin/adminUpdate/{id}",method = RequestMethod.POST)
    public String updateAdmin(UserInfo userInfo ,HttpServletRequest request,
                              HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int count=userService.updateUserInfoAdmin(userInfo);
        if(count>0){
            //修改成功
            return "redirect:/user/Admin/find";
        }
        return "adminUpdate";
    }
}