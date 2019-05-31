package com.yingchong.service.data_service.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class CodeUtils {
    public static String convertCharset(String s) {
        if (s != null)
        {
            byte[] buffer = getByte(s);
            String result = new String(buffer, StandardCharsets.UTF_8);
            return result;
        }
        return null;
    }

    public static String convertCharset88591(String s) {
        if (s != null)
        {
            byte[] buffer = getByte(s);
            String result = new String(buffer, StandardCharsets.ISO_8859_1);
            return result;
        }
        return null;
    }

    private static byte[] getByte(String s) {
        int length = s.length();
        byte[] buffer = new byte[length];
        //0x81 to Unicode 0x0081, 0x8d to 0x008d, 0x8f to 0x008f, 0x90 to 0x0090, and 0x9d to 0x009d.
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            if (c == 0x0081) {
                buffer[i] = (byte) 0x81;
            } else if (c == 0x008d) {
                buffer[i] = (byte) 0x8d;
            } else if (c == 0x008f) {
                buffer[i] = (byte) 0x8f;
            } else if (c == 0x0090) {
                buffer[i] = (byte) 0x90;
            } else if (c == 0x009d) {
                buffer[i] = (byte) 0x9d;
            } else {
                try {
                    buffer[i] = Character.toString(c).getBytes("cp1252")[0];
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }
}
