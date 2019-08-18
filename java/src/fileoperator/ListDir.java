package fileoperator;

import java.io.File;

public class ListDir {
	public static void main(String[] args) {
		File file = new File("src/stream");
		listDir(file);
	}

	public static void listDir(final File directory) {
		if (directory.isFile()) {
			System.out.println(directory.getName());
		} else {
			// �г�Ŀ¼�������ļ�
			for (File file : directory.listFiles()) {
				if (file.isFile()) {
					System.out.println(file.getName());
				} else {
					listDir(file);
				}
			}
		}
	}
}