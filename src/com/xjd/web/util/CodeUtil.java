package com.xjd.web.util;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by Administrator on 2018/2/9.
 */
public class CodeUtil {
    public static String Base64encode(String str) {
        byte[] b = Base64.encodeBase64(str.getBytes(), true);
        return new String(b);
    }
    public static String Base64decode(String str) {
        byte[] b = Base64.decodeBase64(str.getBytes());
        return new String(b);
    }
}
