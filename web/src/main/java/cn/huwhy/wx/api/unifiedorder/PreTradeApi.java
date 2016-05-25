package cn.huwhy.wx.api.unifiedorder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.google.common.base.Strings;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import cn.huwhy.wx.api.MD5;
import cn.huwhy.wx.api.Signature;
import cn.huwhy.wx.api.WxApiUtils;
import cn.huwhy.wx.api.XMLParser;

public class PreTradeApi {

    private static Logger log = Logger.getLogger(PreTradeApi.class);

    private static String API_URI_PRE_TRADE = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    /**
     * 生成预支付订单
     * @param appId 公众号ID  appid
     * @param key 商户Key
     * @param mchId 商户号 mch_id
     * @param nonce 随机字符串 nonce_str
     * @param body  商品描述 body
     * @param outTradeNo 应用订单号 out_trade_no
     * @param totalFee   应付金额 单位分 total_fee
     * @param customerIp 用户IP spbill_create_ip
     * @param notifyUrl  微信支付异步通知地址 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     * @return
     */
    public static PreTradeResult preTrade(String appId, String key, String mchId, String nonce, String body, String outTradeNo,
                                  int totalFee, String customerIp, String notifyUrl, String openId)
            throws IOException, ParserConfigurationException, SAXException, IllegalAccessException {

        Map<String, String> params = new LinkedHashMap<>();
        params.put("appid", appId);
        params.put("mch_id", mchId);
        params.put("nonce_str", nonce);
        params.put("body", body);
        params.put("out_trade_no", outTradeNo);
        params.put("total_fee", Integer.toString(totalFee));
        params.put("spbill_create_ip", customerIp);
        params.put("openid", openId);
        params.put("notify_url", notifyUrl);
        params.put("trade_type", "JSAPI");
        PreTradeParams tradeParams = new PreTradeParams();
        tradeParams.setAppid(appId);
        tradeParams.setBody(body);
        tradeParams.setMch_id(mchId);
        tradeParams.setNonce_str(nonce);
        tradeParams.setNotify_url(notifyUrl);
        tradeParams.setOut_trade_no(outTradeNo);
        tradeParams.setSpbill_create_ip(customerIp);
        tradeParams.setTotal_fee(totalFee);
        tradeParams.setTrade_type("JSAPI");
        String sign = sign(params, key);
        tradeParams.setSign(sign);
        tradeParams.setOpenid(openId);
        //        解决XStream对出现双下划线的bug
        XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        //        将要提交给API的数据对象转换成XML格式数据Post给API
        xStream.alias("xml", PreTradeParams.class);
        String postDataXML = xStream.toXML(tradeParams);
        String responseStr = WxApiUtils.postXml(API_URI_PRE_TRADE, postDataXML);
        if (Signature.checkIsSignValidFromResponseString(responseStr, key)) {
            Map<String, String> map = XMLParser.getMapFromXML(responseStr);
            PreTradeResult result = new PreTradeResult();
            result.setAppId(map.get("appid"));
            result.setMchId(map.get("mch_id"));
            result.setReturnCode(map.get("return_code"));
            result.setReturnMsg(map.get("return_msg"));
            result.setNonce(map.get("nonce_str"));
            result.setSign(map.get("sign"));
            result.setResultCode(map.get("result_code"));
            result.setPrepayId(map.get("prepay_id"));
            result.setTradeType(map.get("trade_type"));
            return result;
        } else {
            throw new RuntimeException("response sign is not valid");
        }
    }

    private static String sign(Map<String, String> params, String key) {
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        for (String k : keys) {
            String value = params.get(k);
            if (!Strings.isNullOrEmpty(value)) {
                sb.append(k).append("=").append(value).append("&");
            }
        }
        sb.append("key=").append(key);
        System.out.println(sb);
        return MD5.MD5Encode(sb.toString()).toUpperCase();
    }


    public static void main(String[] args) throws ParserConfigurationException, IllegalAccessException, SAXException, IOException {
        String appId = "wx093a7087c59fbc99";
        String key = "ddbc6c3a2be9cc7d545ccc01e13d5b0e";
        String mchId = "1265636101";
        String nonce = "4312431241234";
        String body = "测试";
        String outTradeNo = "trade100";
        int totalFee = 100;
        String customerIp = "192.168.111.104";
        String notifyUrl = "http://testpay.ecrm.so:8080/";
        String open = "o5bZkv0Onl5FSxIo8aHXkvQ6KwWE";
        Map<String, String> params = new LinkedHashMap<>();
        params.put("appid", appId);
        params.put("mch_id", mchId);
        params.put("nonce_str", nonce);
        params.put("body", body);
        params.put("out_trade_no", outTradeNo);
        params.put("total_fee", Integer.toString(totalFee));
        params.put("spbill_create_ip", customerIp);
        params.put("openid", open);
        params.put("notify_url", notifyUrl);
        params.put("trade_type", "JSAPI");
        PreTradeParams tradeParams = new PreTradeParams();
        tradeParams.setAppid(appId);
        tradeParams.setBody(body);
        tradeParams.setMch_id(mchId);
        tradeParams.setNonce_str(nonce);
        tradeParams.setNotify_url(notifyUrl);
        tradeParams.setOut_trade_no(outTradeNo);
        tradeParams.setSpbill_create_ip(customerIp);
        tradeParams.setTotal_fee(totalFee);
        tradeParams.setTrade_type("JSAPI");
        String sign = sign(params, key);
        tradeParams.setSign(sign);
        tradeParams.setOpenid(open);
//        解决XStream对出现双下划线的bug
        XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
//        将要提交给API的数据对象转换成XML格式数据Post给API
        xStream.alias("xml", PreTradeParams.class);
        String postDataXML = xStream.toXML(tradeParams);
        String result = WxApiUtils.postXml(API_URI_PRE_TRADE, postDataXML);
        System.out.println(result);
//        System.out.println(sign);
    }
}
