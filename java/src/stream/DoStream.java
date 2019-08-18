package stream;

import java.io.*;

public class DoStream{
	public static void main(String[] args) {
		try {
			OutputStream output = new FileOutputStream("src/stream/test2.txt");
			String str="I love you, huihui!";
			output.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}