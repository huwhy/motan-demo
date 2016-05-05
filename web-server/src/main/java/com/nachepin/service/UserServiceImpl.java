package com.nachepin.service;

import com.nachepin.api.model.User;
import com.nachepin.api.service.IUserService;
import com.nachepin.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther huwhy
 * @date 2016/4/26.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(int id) {
        return userDao.get(id);
    }

    @Override
    public User getUserByCode(String username) {
        return null;
    }

    @Override
    public User getUserByPhone(String phone) {
        return null;
    }
}
