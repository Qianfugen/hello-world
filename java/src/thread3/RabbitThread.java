package thread3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RabbitThread extends Thread {
	SimpleDateFormat sdf = new SimpleDateFormat();
	TurtleThread turtle;

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(777);
				Date date = new Date();
				if (i==3) {
					turtle.join();
				}
				System.out.println(sdf.format(date) + " ÍÃ×ÓÅÜÁË" + i * 10 + "Ã×");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
