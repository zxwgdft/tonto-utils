package tonto.test.util;

public class WaitTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		final Object lock = new Object();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
					
					
					System.out.println("Thread one start");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					lock.notifyAll();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Thread one continue after notify");

				}
			}

		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
					
				
					System.out.println("Thread two start");
					System.out.println("Thread two wait");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("Thread two continue after wait");

				}
			}

		});
		
		t1.start();
		t2.start();
		
		Thread.sleep(100000);

	}
}
