package thread2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过接口实现多线程
 * 
 * @author root
 *
 */
public class MyRunnable implements Runnable {
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		for (int i = 1; i <= 10; i++) {
			Date date = new Date();
			System.out.println(sdf.format(date) + " " + t.getName() + "跑了" + i * 10 + "米");
			try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
