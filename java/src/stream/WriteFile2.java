package stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.OutputStream;

public class WriteFile2 {

	public static void main(String[] args) {
		// 创建输出流对象
		OutputStream output = null;
		try {
			output = new FileOutputStream("src/stream/chengxiang.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 创建写入内容
		String content = "I am a pig!haha!";

		// 字符串转字节数组
		byte[] bytes = content.getBytes();

		try {
			output.write(bytes, 0, bytes.length);
			// 刷新
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (output != null) {
					output.close();
					System.out.println("写入成功!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
