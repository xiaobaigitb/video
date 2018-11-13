package com.zhiyou.video.util;

public class RandomCode {

	public static String getRandomCode(int length){
		
		int[] arr={0,1,2,3,4,5,6,7,8,9};
		String code="";
		
		for(int i=0;i<=length-1;i++){
			int random=(int) (Math.random()*10);
			code+=arr[random];
		}
		return code;
	}

}
