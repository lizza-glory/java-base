package com.lizza.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 多线程操作SimpleDateFormat出现线程安全问题
 * @author lt
 * @date 2019年6月12日
 * @version v1.0
 */
public class SimpleDateFormat_1 {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String s = "2019-06-12";
		for(int i=0; i<5; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Date d = f.parse(s);
						System.out.println(f.format(d).toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
