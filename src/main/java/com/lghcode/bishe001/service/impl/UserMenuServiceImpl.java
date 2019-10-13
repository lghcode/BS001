package com.lghcode.bishe001.service.impl;

import com.lghcode.bishe001.mapper.UserMenuMapper;
import com.lghcode.bishe001.pojo.UserMenu;
import com.lghcode.bishe001.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lghcode@qq.com
 * @date 2019/9/21 23:19
 */
@Service
public class UserMenuServiceImpl implements UserMenuService {

    @Autowired
    private UserMenuMapper userMenuMapper;

    @Override
    public void save(UserMenu userMenu) {
        userMenuMapper.insert(userMenu);
    }

    @Override
    public List<UserMenu> findListByUserId(Integer userId) {
        Example example = new Example(UserMenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        return userMenuMapper.selectByExample(example);
    }

    @Override
    public void delete(Integer Id) {
        userMenuMapper.deleteByPrimaryKey(Id);
    }
}
