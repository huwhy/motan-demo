package cn.huwhy.wx.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

public class Signature {

    private static Logger log = Logger.getLogger(Signature.class);

    // /    /**
    //     * 签名算法
    //     *
    //     * @param o 要参与签名的数据对象
    //     * @return 签名
    //     * @throws IllegalAccessException
    //     */
    //    public static String getSign(Object o, String key) throws IllegalAccessException {
    //        ArrayList<String> list = new ArrayList<>();
    //        Class cls = o.getClass();
    //        Field[] fields = cls.getDeclaredFields();
    //        for (Field f : fields) {
    //            f.setAccessible(true);
    //            if (f.get(o) != null && f.get(o) != "") {
    //                list.add(f.getName() + "=" + f.get(o) + "&");
    //            }
    //        }
    //        int size = list.size();
    //        String[] arrayToSort = list.toArray(new String[size]);
    //        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
    //        StringBuilder sb = new StringBuilder();
    //        for (int i = 0; i < size; i++) {
    //            sb.append(arrayToSort[i]);
    //        }
    //        String result = sb.toString();
    //        result += "key=" + key;
    //        log.debug("Sign Before MD5:" + result);
    //        result = MD5.MD5Encode(result).toUpperCase();
    //        log.debug("Sign Result:" + result);
    //        return result;
    //    }

    public static String getSign(Map<String, String> map, String key) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (value != null && value != "") {
                list.add(entry.getKey() + "=" + value + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + key;
        log.debug("Sign Before MD5:" + result);
        result = MD5.MD5Encode(result).toUpperCase();
        log.debug("Sign Result:" + result);
        return result;
    }

    /**
     * 检验API返回的数据里面的签名是否合法，避免数据在传输的过程中被第三方篡改
     *
     * @param responseString API返回的XML数据字符串
     * @return API签名是否合法
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static boolean checkIsSignValidFromResponseString(String responseString, String key)
            throws ParserConfigurationException, IOException, SAXException, IllegalAccessException {

        Map<String, String> map = XMLParser.getMapFromXML(responseString);
        log.debug(map.toString());

        String signFromAPIResponse = map.get("sign");
        if ("".equals(signFromAPIResponse) || signFromAPIResponse == null) {
            log.debug("API返回的数据签名数据不存在，有可能被第三方篡改!!!");
            return false;
        }
        log.debug("服务器回包里面的签名是:" + signFromAPIResponse);
        //清掉返回数据对象里面的Sign数据（不能把这个数据也加进去进行签名），然后用签名算法进行签名
        map.put("sign", "");
        //将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        String signForAPIResponse = Signature.getSign(map, key);

        if (!signForAPIResponse.equals(signFromAPIResponse)) {
            //签名验不过，表示这个API返回的数据有可能已经被篡改了
            log.debug("API返回的数据签名验证不通过，有可能被第三方篡改!!!");
            return false;
        }
        log.debug("恭喜，API返回的数据签名验证通过!!!");
        return true;
    }



    private static Random random = new Random();

    private static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String getRandomStr(int size) {

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            sb.append(chars.charAt(random.nextInt(size)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRandomStr(chars.length()));
    }

}