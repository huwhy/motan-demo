package cn.huwhy.wx.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class WxApiUtils {


    public static String get(String url, Map<String, String> params) throws IOException {

        StringBuilder sb = new StringBuilder(url);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (sb.indexOf("?") != -1) {
                    sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                } else {
                    sb.append("?").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
        }
        HttpGet get = new HttpGet(sb.toString());

        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(get);
        return getResponseStr(response);

    }

    public static String postXml(String url, String postDataXML) throws IOException {
        HttpPost post = new HttpPost(url);
        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
        post.setEntity(postEntity);
        post.addHeader("Content-Type", "text/xml");
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(post);
        return getResponseStr(response);

    }

    private static String getResponseStr(HttpResponse response) throws IOException {

        if (response.getStatusLine().getStatusCode() == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = reader.readLine();
            StringBuilder buff = new StringBuilder();
            while (line != null) {
                buff.append(line);
                line = reader.readLine();
            }
            return buff.toString();
        } else {
            return "";
        }

    }

}
