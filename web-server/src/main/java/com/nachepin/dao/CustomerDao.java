package com.nachepin.dao;

import com.nachepin.api.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther huwhy
 * @date 2016/4/29.
 */
@Repository
public class CustomerDao extends BaseDao<Customer, Integer> {

    public Customer getByCode(String code) {
        List<Customer> list = (List<Customer>) getHibernateTemplate().find("select o from Customer o where o.code=?", code);
        return list.isEmpty() ? null : list.get(0);
    }

    public Customer getByPhone(String phone) {
        List<Customer> list =  jdbcTemplate.query("select * from customer where phone = ?", rowMapper, phone);
        return list.isEmpty() ? null : list.get(0);
    }

    public Customer getByUsername(String username) {
        List<Customer> list =  jdbcTemplate.query("select * from customer where username = ?", rowMapper, username);
        return list.isEmpty() ? null : list.get(0);
    }
}
