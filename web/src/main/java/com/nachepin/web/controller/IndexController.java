
package com.nachepin.web.controller;

import com.nachepin.api.dto.Json;
import com.nachepin.api.dto.PageList;
import com.nachepin.api.dto.PageParam;
import com.nachepin.api.model.Customer;
import com.nachepin.api.model.enums.CustomerState;
import com.nachepin.api.model.enums.GoodsType;
import com.nachepin.api.service.ICustomerService;
import com.nachepin.api.service.IGoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/")
    public String home(String username, Model model) {

        PageList goods = goodsService.findGoods(GoodsType.carTrim, null, new PageParam(100, 1));
        model.addAttribute("carTrim", goods);
        model.addAttribute("v", "1.0");
        Customer customer = customerService.getCustomerByCode(username);
        if (customer == null) {
            customer = customerService.getCustomerByPhone(username);
        }

        return "web/index";
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
