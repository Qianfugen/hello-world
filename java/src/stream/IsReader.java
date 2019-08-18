package stream;

import java.io.*;

public class IsReader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream("src/stream/haha.txt"));
			char[] cbuf = new char[3];
			int charReader = 0;
			while((charReader=reader.read(cbuf)) !=-1) {
				System.out.print(new String(cbuf, 0, charReader));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
