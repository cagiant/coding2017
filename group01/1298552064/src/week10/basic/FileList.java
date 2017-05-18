package week10.basic;

import java.io.File;

public class FileList {
	public void list(File f) {
		if (f.isDirectory()) {
			System.out.println("directory:" + f.getName());
			File[] files = f.listFiles();
			for (File file : files) {
				list(file);
			}
		}

		if (f.isFile()) {
			System.out.println("		file:  " + f.getName());
		}
	}
}
