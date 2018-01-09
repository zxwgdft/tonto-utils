package com.tonto2.common.utils.time;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


/**
 * 年龄工具类
 * 
 * @author TontZhou
 * 
 */
public class AgeUtil {

	/**
	 * 从身份证号码获取出生日期
	 * 
	 * @param idCardNumber
	 * @return
	 */
	public static Date getBirthDayFromIdCardNumber(String idCardNumber) {

		if (idCardNumber != null && idCardNumber.length() > 14) {
			try {
				return DateFormatUtil.getThreadSafeFormat("yyyyMMdd").parse(idCardNumber.substring(6, 14));
			} catch (ParseException e) {
				throw new IllegalArgumentException("The idCardNumber [" + idCardNumber + "] is invalid!", e);
			}
		}

		throw new IllegalArgumentException("The idCardNumber [" + idCardNumber + "] is invalid!");
	}

	/**
	 * 根据出生日期计算年龄
	 * @param birthDay
	 * @return
	 */
	public static int getAge(Date birthDay) {
		
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth)
					age--;
			} else {
				age--;
			}
		}
		return age;

	}
	
}
