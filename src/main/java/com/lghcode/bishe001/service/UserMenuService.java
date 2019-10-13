package com.lghcode.bishe001.service;

import com.lghcode.bishe001.pojo.UserMenu;

import java.util.List;

public interface UserMenuService {

    void save(UserMenu userMenu);

    List<UserMenu> findListByUserId(Integer userId);

    void delete(Integer Id);
}
