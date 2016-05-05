package com.nachepin.dao;

import com.nachepin.api.model.User;
import org.springframework.stereotype.Repository;

/**
 * @auther huwhy
 * @date 2016/4/26.
 */
@Repository
public class UserDao extends BaseDao<User, Integer> {

    public User getUser(Integer id) {
        return get(id);
    }
}
