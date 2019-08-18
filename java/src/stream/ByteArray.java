package stream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ByteArray {
	public static void main(String[] args) {
		InputStream input=null;
		try {
			input = new FileInputStream("src/stream/hello.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = input.read()) != -1) {
				output.write(buf, 0, bytesRead);
			}
			String data = output.toString("utf-8");
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
