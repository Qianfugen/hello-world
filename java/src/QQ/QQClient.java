package QQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QQClient {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 10086);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			PrintWriter pw = new PrintWriter(s.getOutputStream());

			QQReceive receive = new QQReceive(s);
			receive.start();
			while (true) {
				String info = null;
				if ((info = br.readLine()) != null) {
					pw.println(info);
					pw.flush();
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
