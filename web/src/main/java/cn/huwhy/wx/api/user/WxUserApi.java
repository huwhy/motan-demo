package cn.huwhy.wx.api.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.huwhy.wx.api.WxApiUtils;
import cn.huwhy.wx.api.accesstoken.AccessToken;
import cn.huwhy.wx.api.accesstoken.AccessTokenApi;

public class WxUserApi {
    private static String API_URI_USER = "https://api.weixin.qq.com/cgi-bin/user/info";
    private static String API_URI_USER2 = "https://api.weixin.qq.com/sns/userinfo";

    private static String API_URI_USER_LIST = "https://api.weixin.qq.com/cgi-bin/user/get";

    public static WxUser getUserInfo(String accessToken, String openId) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("openid", openId);
        params.put("lang", "zh_CN");

        String json = WxApiUtils.get(API_URI_USER, params);
        return JSON.parseObject(json, WxUser.class);
    }

    public static WxUser getUserInfo2(String accessToken, String openId) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("openid", openId);
        params.put("lang", "zh_CN");
        String result = WxApiUtils.get(API_URI_USER2, params);
        return JSONObject.parseObject(result, WxUser.class);
    }

    public static UserList getUserList(String accessToken, String nextOpenId) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("next_openid", nextOpenId);
        params.put("lang", "zh_CN");

        String json = WxApiUtils.get(API_URI_USER_LIST, params);
        return JSON.parseObject(json, UserList.class);
    }

    public static void main(String[] args) throws IOException {
        String wx093a7087c59fbc99 = "wx093a7087c59fbc99";
        String appSecret = "6efec66744d88fb4ab1d0f59f44093b2";
        String myOpenId = "'o5bZkv0Onl5FSxIo8aHXkvQ6KwWE'";
        AccessToken at = AccessTokenApi.getAppAccessToken(wx093a7087c59fbc99, appSecret);

        UserList list = getUserList(at.getAccess_token(), "");
        at = AccessTokenApi.getAppAccessToken(wx093a7087c59fbc99, appSecret);
        for (String openId : list.getData().getOpenid()) {
            System.out.println(openId);
            WxUser u = getUserInfo(at.getAccess_token(), openId);
            System.out.println(u);
            if (u.getNickname().equals("hdjwhy"))
                break;
        }
    }

}
