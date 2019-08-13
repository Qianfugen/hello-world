package QQ;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class QQServer {
	private static ArrayList<Socket> list;
	
	public static void main(String[] args) {
		Socket s=null;
		String ip=null;
		
		try {
			ServerSocket ss=new ServerSocket(10086);
			list=new ArrayList<Socket>();
			System.out.println("server is all ready...");
			
			while(true) {
				s=ss.accept();
				list.add(s);
				
				ip=s.getInetAddress().getHostAddress();
				System.out.println(ip+"new client online,number of clients:"+list.size());
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static ArrayList<Socket> getList(){
		return list;
	}
	
}
