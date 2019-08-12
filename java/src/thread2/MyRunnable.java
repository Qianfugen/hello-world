package thread2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ͨ���ӿ�ʵ�ֶ��߳�
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
			System.out.println(sdf.format(date) + " " + t.getName() + "����" + i * 10 + "��");
			try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
