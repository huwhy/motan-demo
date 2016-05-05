package com.nachepin.dao;

import com.alibaba.fastjson.JSON;
import com.nachepin.api.model.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther huwhy
 * @date 2016/4/29.
 */
public class CustomerDaoTest extends BaseTest{

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testGetByCode() {
        Customer customer = customerDao.getByCode("KH00011");
        System.out.println(JSON.toJSONString(customer));
        Customer customer2 = customerDao.getByPhone(customer.getPhone());
        System.out.println(JSON.toJSONString(customer2));
    }
}
