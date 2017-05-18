package algorithm.tree;

import java.io.File;
import java.util.Arrays;

public class FileList {

    public void list(File f) {
        list(f, 0);
    }

    private void list(File f, int depth) {
        if (f == null) {
            return;
        }
        System.out.println(inset(depth) + f.getName() + (f.isDirectory() ? " <dir>" : ""));
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> list(file, depth + 1));
            }
        }
    }

    private String inset(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; ++i) {
            builder.append("    ");
        }
        return builder.toString();
    }
}
