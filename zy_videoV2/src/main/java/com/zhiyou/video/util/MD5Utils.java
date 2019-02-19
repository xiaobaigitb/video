package com.zhiyou.video.util;

import org.springframework.util.DigestUtils;

/**
 * MD5加密工具类
 *
 * @author Administrator
 */
public class MD5Utils {

    /*
     * 将一个字符串MD5加密，方式很多，我们使用的是Spring包下
     */
    public static String getMd5Simple(String password) {
        String md502 = DigestUtils.md5DigestAsHex(password.getBytes());
        return md502;
    }

    /**
     * 加密，把一个字符串在原有的基础上+1
     *
     * @param data 需要解密的原字符串
     * @return 返回解密后的新字符串
     */
    public static String encode(String data) {
        //把字符串转为字节数组
        byte[] b = data.getBytes();
        //遍历
        for (int i = 0; i < b.length; i++) {
            b[i] += 1;//在原有的基础上+1
        }
        return new String(b);
    }
    /**
     * 解密：把一个加密后的字符串在原有基础上-1
     * @param data 加密后的字符串
     * @return 返回解密后的新字符串
     */
    public static String decode(String data) {
        //把字符串转为字节数组
        byte[] b = data.getBytes();
        //遍历
        for(int i=0;i<b.length;i++) {
            b[i] -= 1;//在原有的基础上-1
        }
        return new String(b);
    }

    public static void main(String[] args) {
        //System.out.println(getMd5Simple("111111"));

        //加密英文
        String data = "ABCDEFG";
        String result = encode(data);
        System.out.println("加密后:"+result);
        //解密
        String str = decode(result);
        System.out.println("解密后:"+str);

        //加密中文
        data = "跳梁小豆tlxd666";
        result = encode(data);
        System.out.println("加密后:"+result);
        String str1 = decode(result);
        System.out.println("解密后:"+str1);
    }

}
