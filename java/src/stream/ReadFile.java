package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream input = new FileInputStream("src/stream/hello.txt");

		try {
			byte[] bytes = new byte[1024];
			int bytesRead = input.read(bytes);
			String data = new String(bytes, 0, bytesRead, "utf-8");
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
