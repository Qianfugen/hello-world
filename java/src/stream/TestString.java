package stream;

import java.io.UnsupportedEncodingException;

public class TestString {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes= {97,98,99,100,101};
		//����һ���µ� Stringͨ��ʹ��ָ�����ַ�������ָ�����ֽ�������
		String str=new String(bytes,0,bytes.length,"utf-8");
		System.out.println(str);
	}

}
