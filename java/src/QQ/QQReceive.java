package QQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class QQReceive extends Thread {
	private Socket s;

	public QQReceive(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while (true) {
				String info = null;
				if ((info = br.readLine()) != null) {
					System.out.println(info);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
