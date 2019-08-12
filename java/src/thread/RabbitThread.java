package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ͨ���̳�ʵ�ֶ��߳�
 * @author root
 *
 */
public class RabbitThread extends Thread {
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			Date date = new Date();
			System.out.println(sdf.format(date) + " �������� " + i * 10 + "��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
