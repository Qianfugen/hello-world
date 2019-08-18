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
			// 列出目录下所有文件
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