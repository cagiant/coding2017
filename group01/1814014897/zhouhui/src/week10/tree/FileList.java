package week10.tree;

import java.io.File;

public class FileList {
	public static void list(File f) {
		File[] files = f.listFiles();
		for(File file :files){
			if(file.isDirectory()){
				list(file);
				System.out.println(file);
			}else{
				System.out.println(file);
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File("D:\\GitHub\\1814014897\\zhouhui");
		list(file);
	}
	
}
