package com.try_their.try_their_project.util.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Util {
    /**
     * 生成随机的 salt 盐值
     * @param length
     * @return
     */
    public static String  getSalt(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer salt = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            salt.append(str.charAt(number));
        }
        return salt.toString();
    }

    /**
     * MD5算法或者SHA-1算法要用到的加密算法
     * 二进制数据转换成十六进制字符串
     * @author Carry
     * @param b byte[] 字节流
     * @return String 十六进制字符串
     */
    private static String byteToHexString(byte[] b) {

        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1)
                hs = hs + "";
        }
        return hs;
    }

    /**
     * 对源字符串进行md5/SHA-1编码
     * @author Carry
     * @param sourceData 明文
     * @return 密文
     */
    public static String getMD5Digest(String sourceData) {
        try {
            //此句话是采用MD5算法加密
            MessageDigest alga = MessageDigest.getInstance("MD5");
            //此句话是采用SHA-1算法
            //MessageDigest alga=MessageDigest.getInstance("SHA-1");
            alga.update(sourceData.getBytes());
            byte[] digesta = alga.digest();
            return byteToHexString(digesta);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
