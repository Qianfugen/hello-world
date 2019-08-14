package stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class WriteFile {
	public static void main(String[] args) throws FileNotFoundException {
		OutputStream output = new FileOutputStream("src/stream/test.txt");
		String data = "this is just a test!";
		byte[] bytes = data.getBytes(Charset.forName("utf-8"));
		try {
			output.write(bytes);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
