package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;
		BufferedReader br = null;

		try {
			ss = new ServerSocket(10086);
			System.out.println("����������");
			s = ss.accept();

			while (true) {
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String str = br.readLine();
				System.out.println("�ͻ���˵:" + str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
