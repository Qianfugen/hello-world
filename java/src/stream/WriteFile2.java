package stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.OutputStream;

public class WriteFile2 {

	public static void main(String[] args) {
		// �������������
		OutputStream output = null;
		try {
			output = new FileOutputStream("src/stream/chengxiang.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// ����д������
		String content = "I am a pig!haha!";

		// �ַ���ת�ֽ�����
		byte[] bytes = content.getBytes();

		try {
			output.write(bytes, 0, bytes.length);
			// ˢ��
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (output != null) {
					output.close();
					System.out.println("д��ɹ�!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
