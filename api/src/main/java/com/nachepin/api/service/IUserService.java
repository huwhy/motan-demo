package com.nachepin.api.service;

import com.nachepin.api.model.User;

/**
 * @auther huwhy
 * @date 2016/4/26.
 */
public interface IUserService {

    User getUser(int id);

    User getUserByCode(String username);

    User getUserByPhone(String phone);
}
