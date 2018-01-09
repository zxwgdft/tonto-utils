package com.tonto2.common.utils.time;

import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;

public class DateFormatUtil {

	private final static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> threadLocalMap = new ConcurrentHashMap<>();

	private static ThreadLocal<SimpleDateFormat> getThreadLocal(final String format) {

		ThreadLocal<SimpleDateFormat> threadLocal = threadLocalMap.get(format);
		
		if (threadLocal == null) {
			synchronized (threadLocalMap) {
				threadLocal = threadLocalMap.get(format);
				if (threadLocal == null) {
					threadLocal = new ThreadLocal<SimpleDateFormat>() {
						public SimpleDateFormat initialValue() {
							return new SimpleDateFormat(format);
						}
					};
					threadLocalMap.put(format, threadLocal);
				}
			}
		}

		return threadLocal;

	}

	public static SimpleDateFormat getThreadSafeFormat(String format) {
		return getThreadLocal(format).get();
	}

}
