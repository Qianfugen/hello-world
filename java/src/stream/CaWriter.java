package stream;

import java.io.*;

public class CaWriter {

	public static void main(String[] args) {
		Reader reader=null;
		try {
			reader = new InputStreamReader(new FileInputStream("src/stream/haha.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			CharArrayWriter writer=new CharArrayWriter();
			char[] cbuf=new char[1024];
			int charRead=0;
			while((charRead=reader.read(cbuf))!=-1) {
				writer.write(cbuf,0,charRead);
			}
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
