package com.zhiyou.video.util;

import org.springframework.util.DigestUtils;

/**
 * MD5加密工具类
 * @author Administrator
 *
 */
public class MD5Utils {

	/*
	 * 将一个字符串MD5加密，方式很多，我们使用的是Spring包下
	 */
	public static String getMd5Simple(String password){
		String md502 =DigestUtils.md5DigestAsHex(password.getBytes());
		return md502;

	}
	
	public static void main(String[] args){
		System.out.println(getMd5Simple("111111"));
	}

}
