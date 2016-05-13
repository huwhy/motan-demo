
package com.nachepin.web.controller;

import com.nachepin.api.dto.Json;
import com.nachepin.api.model.Customer;
import com.nachepin.api.model.enums.CustomerState;
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

    @RequestMapping("/login")
    @ResponseBody
    public Json login(String code, String password) {
        Customer c = customerService.getCustomerByCode(code);
        if (c == null) {
            c = customerService.getCustomerByPhone(code);
        }
        if (c == null) {
            c = customerService.getCustomerByUsername(code);
        }

        if (c == null) {
            return Json.error("用户名或手机号有误!");
        }
        if (c.getState().equals(CustomerState.stop)) {
            return Json.error("帐号已停用");
        }
        return Json.success2(c);
    }

}
