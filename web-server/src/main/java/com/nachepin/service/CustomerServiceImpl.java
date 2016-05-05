package com.nachepin.service;

import com.nachepin.api.model.Customer;
import com.nachepin.api.service.ICustomerService;
import com.nachepin.dao.CustomerDao;
import com.nachepin.dao.UserDao;
import org.apache.commons.codec.language.bm.Rule;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther huwhy
 * @date 2016/4/29.
 */
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer getCustomerByCode(String code) {
        return customerDao.getByCode(code);
    }

    @Override
    public Customer getCustomerByPhone(String phone) {
        return customerDao.getByPhone(phone);
    }
}
