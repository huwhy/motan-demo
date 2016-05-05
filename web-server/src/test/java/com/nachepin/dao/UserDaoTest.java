package com.nachepin.dao;

import com.alibaba.fastjson.JSON;
import com.nachepin.api.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther huwhy
 * @date 2016/4/26.
 */
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testGet() {
        User user = userDao.get(1);
        System.out.println(JSON.toJSONString(user));
    }

}
