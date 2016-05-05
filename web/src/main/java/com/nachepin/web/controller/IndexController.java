
package com.nachepin.web.controller;

import com.nachepin.api.model.Customer;
import com.nachepin.api.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/")
    @ResponseBody
    public String home(String username) {
        Customer customer = customerService.getCustomerByCode(username);
        if (customer == null) {
            customer = customerService.getCustomerByPhone(username);
        }

        if (customer != null) {
            return "hello";
        } else {
            return "nologin";
        }
    }


}
