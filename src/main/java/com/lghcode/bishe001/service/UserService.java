package com.lghcode.bishe001.service;

import com.lghcode.bishe001.pojo.User;
import com.lghcode.bishe001.util.PagedResult;

public interface UserService {
    /**
     * 用户新增
     * @param user
     */
    void save(User user);

    PagedResult getUserList(String userNo,String realName,Integer userType,Integer pageNum,Integer pageSize);

    void update(User user);

    User getUser(Integer id);

    void delete(Integer id);

    void setLoginPermissions(Integer id,Integer isLogin);

    boolean checkUserIsExit(String userNo,Integer id);
    boolean checkUserIsExit(String userNo);

    User checkUserLogin(String userNo,String password);
}
