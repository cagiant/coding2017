package datastructure.tree;

import java.io.File;

public class FileList {
	public void list(File f) {
	    if (!f.isDirectory()) {
	        throw new IllegalArgumentException("这不是一个目录");
	    }
	    File[] listFiles = f.listFiles();
	    System.out.println(f.getName() + ":");
	    for (File file : listFiles) {
	        if (file.isDirectory()) {
	            list(file);
	        } else if (file.isFile()){
	            System.out.println("\t" + file.getName());
	        }
	    }
	}
}
