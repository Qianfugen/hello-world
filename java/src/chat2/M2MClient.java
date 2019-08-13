package chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import chat2.M2MReceive;

/**
 * ��Զ�ͻ���
 * 
 *
 */
public class M2MClient {

	public static void main(String[] args) {

		try {

			// �����ͻ��˶���
			Socket s = new Socket("localhost", 1234);

			// �ȴӼ��̽�����Ϣ
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// д�뵽 Socket ��
			PrintWriter pw = new PrintWriter(s.getOutputStream());

			// �����߳�
			M2MReceive receive = new M2MReceive(s);
			receive.start();

			while (true) {

				// �û�������Ϣ
				String info = null;

				if ((info = br.readLine()) != null) {

					// д��
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
