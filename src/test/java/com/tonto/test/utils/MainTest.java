package com.tonto.test.utils;

import com.tonto.utils.test.ExpendTimer;

public class MainTest {

	public static void main(String[] args) {
		
		
		System.out.println("方法一花费时间：" + System.currentTimeMillis());
		
		int count = 1000000;

		long time1 = ExpendTimer.expendTimeBySingle(count, new Runnable() {

			@Override
			public void run() {
			}

		});

		long time2 = ExpendTimer.expendTimeBySingle(count, new Runnable() {

			@Override
			public void run() {
			}

		});

		System.out.println("方法一花费时间：" + time1);
		System.out.println("方法一花费时间：" + time2);

	}

}
