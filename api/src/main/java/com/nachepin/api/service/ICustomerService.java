package com.nachepin.api.service;

import com.nachepin.api.model.Customer;

/**
 * @auther huwhy
 * @date 2016/4/29.
 */
public interface ICustomerService {

    Customer getCustomerByCode(String code);

    Customer getCustomerByPhone(String phone);
}
