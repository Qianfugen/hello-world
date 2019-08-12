package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

@SuppressWarnings("all")
public class QQClient {
	public static void main(String[] args) {
		Socket s = null;
		PrintWriter pw = null;
		
		// 创建客户端套接字
		System.out.println("请输入需要传输的数据");
		Scanner input = new Scanner(System.in);
		
		try {
			s = new Socket("10.1.13.58", 11088);
			while(true) {
				String str=input.nextLine();
				pw=new PrintWriter(s.getOutputStream());
				pw.println(str);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
