package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile2 {

	public static void main(String[] args) {
		// 创建输入流对象
		InputStream input = null;

		try {
			input = new FileInputStream("src/stream/chengxiang.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 创建字节数组
		byte[] bytes = new byte[1024];

		// 读取文件内容
		try {

			int length = input.read(bytes);
			String str = new String(bytes, 0, length, "utf-8");
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
