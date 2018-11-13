package com.zhiyou.video;

/**
 * Descr:
 *
 */
public class Test {

	public static void main(String[] args){
		float a = -0.000000000000000000000000000001f;
		
		int i = new Float(a).compareTo(new Float(0));
		if(i==0){
			//a等于0
		}else if(i>0){
			//a大于0
		}else{
			//i<0,则a小于0
		}
		
		System.out.println(new Float(a).compareTo(new Float(0)));
	}
	
}
