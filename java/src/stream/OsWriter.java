package stream;

import java.io.*;

public class OsWriter{
	public static void main(String[] args) {
		OutputStreamWriter writer=null;
		try {
			writer=new OutputStreamWriter(new FileOutputStream("src/stream/haha.txt"));
			String str="我真的还想再活五百年!";
			writer.write(str);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}