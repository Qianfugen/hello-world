package stream;

import java.io.UnsupportedEncodingException;

public class TestString {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes= {97,98,99,100,101};
		//构造一个新的 String通过使用指定的字符集解码指定的字节子阵列
		String str=new String(bytes,0,bytes.length,"utf-8");
		System.out.println(str);
	}

}
