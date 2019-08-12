package thread3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TurtleThread extends Thread {
	SimpleDateFormat sdf = new SimpleDateFormat();

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
				Date date = new Date();
				System.out.println(sdf.format(date) + " ÎÚ¹ê ÅÜÁË" + i * 10 + "Ã×");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
