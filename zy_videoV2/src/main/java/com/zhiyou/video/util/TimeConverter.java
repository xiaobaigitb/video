package com.zhiyou.video.util;

/**
 * Descr: 时间转换，将秒转换为 小时:分钟:秒 的格式
 *
 */
public class TimeConverter {
	
	/**
	 * 秒转换为时分秒 00:00:00
	 * 
	 * @param time
	 * @return
	 */
	public static String converter(int time){
		if(time<0){
			return null;
		}
		//计算小时
		int hour = time/3600;
		int hourYu = time%3600;
		//计算分钟
		int minute = hourYu/60;
		int second = hourYu%60;
		
		//使用StringBuffer拼接结果字符串，关于StringBuffer/StringBuilder和String的区别可以查资料或api
		StringBuffer buffer = new StringBuffer();
		buffer.append(format(hour));
		buffer.append(":");
		buffer.append(format(minute));
		buffer.append(":");
		buffer.append(format(second));
		//将StringBuffer拼接好的内容转换为String返回，得到的就是时分秒的格式
		return buffer.toString();
	}
	/**
	 * 对于不满两位数的进行补零操作
	 * 
	 * @param t
	 * @return
	 */
	private static String format(int t){
		if(t<10){
			return "0"+t;
		}
		return t+"";
	}
	
}
