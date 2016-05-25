package cn.huwhy.wx.api.accesstoken;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import cn.huwhy.wx.api.WxApiUtils;

public class AccessTokenApi {

    private static final String GET_APP_TAKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    private static final String GET_USER_TAKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

    private static final String REFRESH_USER_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

    public static AccessToken getUserAccessToken(String appId, String appSecret, String code) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", appId);
        params.put("secret", appSecret);
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        String result = WxApiUtils.get(GET_USER_TAKEN_URL, params);
        return JSONObject.parseObject(result, AccessToken.class);
    }

    public static AccessToken refreshUserAccessToken(String appId, String appSecret, String refreshToken) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", appId);
        params.put("secret", appSecret);
        params.put("grant_type", "refresh_token");
        params.put("refresh_token", refreshToken);
        String result = WxApiUtils.get(REFRESH_USER_TOKEN_URL, params);
        return JSONObject.parseObject(result, AccessToken.class);
    }

    public static AccessToken getAppAccessToken(String appId, String appSecret) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", appId);
        params.put("secret", appSecret);
        params.put("grant_type", "client_credential");
        String result = WxApiUtils.get(GET_APP_TAKEN_URL, params);
        return JSONObject.parseObject(result, AccessToken.class);
    }
}