package service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ImgService {
	// 返回独一无二的头像名
	public static String getPortraitName(String portraitName) {
		// 获取当前时间
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String name = format.format(date) + portraitName;
		return name;
	}
}
