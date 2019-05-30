package com.yingchong.service.data_service.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

/**
 * Created by zhoujia on 2016/7/12.
 * MD5 加密， uuid，随机字符串工具类
 */
public class MD5 {
    private static char hexDigits[] = {'0', '1', '2', '3', '4',
                        '5', '6', '7', '8', '9',
                        'a', 'b', 'c', 'd', 'e', 'f'};
    public static String SAFE_CODE = "UTF-8";
    public final static String encode(byte[] btInput) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] safecode(String str){
        try {
            return str.getBytes(SAFE_CODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String encode(String str){
        return encode(safecode(str));
    }

    public static boolean compare(String src,String md5){
        return encode(src).equals(md5);
    }
    public static String uuid(){
    	return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /***
     * @return  返回16位随机字符串，作为二级域名
     */
    public static String getRandomDomain(){
        Random r = new Random();
        int i = r.nextInt(26)+97;
        char random = (char) i;
        String uuid = uuid() + uuid();
        int i1 = r.nextInt(48);
        return random + uuid.substring(i1,i1+15);
    }

//    public static void main(String[] args) {
//        for(int i=0;i<1000;i++){
//            System.out.println(getRandomDomain());
//        }
//
//    }
}
