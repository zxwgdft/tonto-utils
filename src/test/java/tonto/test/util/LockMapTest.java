package tonto.test.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

import com.tonto2.common.concurrency.util.LockMap;

public class LockMapTest {

	private Map<String, Object> map;

	final AtomicLong writeCount = new AtomicLong(100000);
	final AtomicLong readCount = new AtomicLong(100000000);

	
	@Test
	public void performanceTest() throws InterruptedException {
		
		map = new LockMap<>(new HashMap<String, Object>());
		map = new ConcurrentHashMap<>();		
		System.out.println(System.currentTimeMillis());
		long time = System.currentTimeMillis();
		
		for(int i = 1000;i>0;i--)
			startReadThread(time);
		
		for(int i = 20;i>0;i--)
			startWriteThread(time);
		
		
		Thread.sleep(200000);
	}

	private void startReadThread(final long time) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					String s = String.valueOf(System.currentTimeMillis());
					map.containsKey(s);
					long i = readCount.decrementAndGet();
					if (i < 0)
					{
						System.out.println(System.currentTimeMillis() - time);
						break;
					}
				}
			}

		}).start();
	}

	private void startWriteThread(final long time) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					String s = String.valueOf(new Date().getTime());
					map.put(s, s);
					long i = writeCount.decrementAndGet();
					if (i < 0)
					{
						System.out.println(System.currentTimeMillis() - time);
						break;
					}
				}

			}

		}).start();
	}

}
