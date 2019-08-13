package practice.qq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;
		BufferedReader br = null;

		try {
			System.out.println("服务器启动...");
			ss = new ServerSocket(12345);
			s = ss.accept();
			while (true) {
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String str = br.readLine();
				System.out.println("客户端说：" + str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
