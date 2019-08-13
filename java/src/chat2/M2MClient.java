package chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import chat2.M2MReceive;

/**
 * 多对多客户端
 * 
 *
 */
public class M2MClient {

	public static void main(String[] args) {

		try {

			// 构建客户端对象
			Socket s = new Socket("localhost", 1234);

			// 先从键盘接收信息
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// 写入到 Socket 中
			PrintWriter pw = new PrintWriter(s.getOutputStream());

			// 启动线程
			M2MReceive receive = new M2MReceive(s);
			receive.start();

			while (true) {

				// 用户输入信息
				String info = null;

				if ((info = br.readLine()) != null) {

					// 写出
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
