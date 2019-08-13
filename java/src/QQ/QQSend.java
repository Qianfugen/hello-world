package QQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class QQSend extends Thread {
	private ArrayList<Socket> list = QQServer.getList();

	private Socket s;

	public QQSend(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		String ip = s.getInetAddress().getHostAddress();

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			while (true) {
				String info=null;
				
				if((info=reader.readLine())!=null) {
					for(Socket ss:list) {
						PrintWriter pw;
						pw=new PrintWriter(ss.getOutputStream());
						pw.println(ip+"said:"+info);
						pw.flush();
					}
				}
			}
		} catch (IOException e) {
			list.remove(s);
			System.out.println(ip+"outline,number of online clients:"+list.size());
		}

	}

}
