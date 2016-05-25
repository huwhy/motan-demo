package com.nachepin.web.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSON;

import cn.huwhy.wx.api.Signature;
import cn.huwhy.wx.api.unifiedorder.PreTradeApi;
import cn.huwhy.wx.api.unifiedorder.PreTradeResult;

@Controller
@RequestMapping("/trade")
public class TradeController {

    @RequestMapping("index")
    public String index(HttpServletRequest request) throws ParserConfigurationException, SAXException, IOException, IllegalAccessException {

        String appId = "wx093a7087c59fbc99";
        String key = "ddbc6c3a2be9cc7d545ccc01e13d5b0e";
        String mchId = "1265636101";
        String nonce = Signature.getRandomStr(32);
        String body = "测试";
        String outTradeNo = "trade100" + Signature.getRandomStr(10);
        int totalFee = 100;
        String customerIp = getIpAddr(request);
        String notifyUrl = "http://testpay.ecrm.so/trade/notify";
        String openId = "o5bZkv0Onl5FSxIo8aHXkvQ6KwWE";

        PreTradeResult result = PreTradeApi.preTrade(appId, key, mchId, nonce,
                body, outTradeNo, totalFee,  customerIp, notifyUrl, openId);
        Map<String, String> map = new HashMap<>();
        map.put("appId", appId);
        map.put("timeStamp", Long.toString(System.currentTimeMillis() / 1000));
        map.put("nonceStr", Signature.getRandomStr(32));
        map.put("package", "prepay_id=" + result.getPrepayId());
        map.put("signType", "MD5");
        map.put("paySign", Signature.getSign(map, key));

        request.setAttribute("payParams", JSON.toJSONString(map));

        return "/trade";
    }

    @RequestMapping("notify")
    public String notifyHtml() {
        return "/hello";
    }

    /**
     * 获取当前网络ip
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
