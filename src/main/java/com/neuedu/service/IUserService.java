package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;

import java.util.List;

public interface IUserService {

    /**
     * 管理员登录
     * */
    public UserInfo login(UserInfo userInfo)throws MyException;

    /**
     * 添加管理员
     * */
    public int addUserInfoAdmin(UserInfo userInfo)throws MyException;

    /**
     * 删除管理员
     * */
    public int deleteserInfoAdmin(int userInfoId)throws MyException;

    /**
     * 修改管理员
     * */
    public int updateUserInfoAdmin(UserInfo userInfo)throws MyException;

    /**
     * 查询管理员
     * */
    public List<UserInfo> findAllAdmin() throws MyException;

    /**
     * 根据类别id查询管理员信息
     * */
    public UserInfo findUserInfoById(int userInfoId);

}
