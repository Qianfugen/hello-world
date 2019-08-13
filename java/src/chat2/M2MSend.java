package chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * �����߳�
 * 
 *
 */
public class M2MSend extends Thread {
	
	//�û�����
	private ArrayList<Socket> list = M2MServer.getList();
	//��ǰ�û�
	private Socket s;
	
	public M2MSend(Socket s){
		this.s = s;
	}
	
	public void run(){
		
		//��ȡ���û� IP
		String ip = s.getInetAddress().getHostAddress();
		
		try {
			
			//��ȡ�û���Ϣ
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			//���ϵĶ�ȡд������
			while(true){
				
				//��������
				String info = null;
			
				//�����ȡ��Ϣ��Ϊ��
				if((info=reader.readLine()) != null){
					
					//�������е������û�,���Ұ���Ϣ���͹�ȥ
					for(Socket ss : list){
						
						//��ȡ����������
						PrintWriter pw;
						pw = new PrintWriter(ss.getOutputStream());
						//д����Ϣ
						pw.println(ip + " ˵: " + info);
						pw.flush();
						
					}
					
				}
			}
			
		} catch (IOException e1) {
			//�û�����
			list.remove(s);
			System.err.println(ip + " ������ , ��ǰ��������Ϊ: " + list.size() + " �� !");
		}
		
		
	}

}
