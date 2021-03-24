package com.hunter.linux;

import com.jfinal.kit.PropKit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/**
 * @filename Md5Utils.java
 * @author tianyang.chen
 * @date 2016年5月25日 上午8:54:45
 * @desc
 **/

public class Md5Utils {
    private String md5_32;
    private String md5_16;
    public Md5Utils(String sourceStr){
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            md5_32=result;
            md5_16= buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }
    public String get16(){
        return md5_16;
    }
    public String get32(){
        return md5_32;
    }

    public static String get16(String sourceStr){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String get32(String sourceStr){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
//        Md5Utils m = new Md5Utils("Admin4cdh@bb");
//        System.out.println(get16("f0f4c8e0c4abe54b"));
//        System.out.println(m.get32());
//
//
//        System.out.println(get32("from_monitor_1"+"1560417462000"+"from_monitor_1:realtime_module"));
//        System.out.println(UUID.randomUUID().toString());
//        System.out.println(UUID.randomUUID().toString());

        String password = "Acmin1fdh@aa"
                .replace("1","4").replace("aa","bb").replace("c","d").replace("f", "c");
        System.out.println(password);

    }

}

