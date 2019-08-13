package practice.qq;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class QQClient {
	public static void main(String[] args) {
		Socket s = null;
		PrintWriter pw = null;

		System.out.println("请输入想说的话：");
		Scanner input = new Scanner(System.in);
		try {
			s = new Socket("localhost", 12345);
			while (true) {
				String str = input.nextLine();
				pw = new PrintWriter(s.getOutputStream());
				pw.write(str);
				pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
