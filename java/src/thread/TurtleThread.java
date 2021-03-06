package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 通过继承实现多进程
 * @author root
 *
 */
public class TurtleThread extends Thread {
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			Date date = new Date();
			System.out.println(sdf.format(date) + " 乌龟跑了 " + i * 10 + "米");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
