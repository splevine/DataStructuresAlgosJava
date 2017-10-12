package filesize;

import java.io.File;

public class FileSize {
    private static final String rootFolder = ".";

    public static void printSize(int space, File folder) {
        
        for (File f : folder.listFiles()) {
            if (f.isDirectory()) {
                System.out.println(f.getPath());
                printSize(space + 1, f);
            } else {
                for (int i = 0; i < space; i++)
                    System.out.print(" ");
                System.out.println(f.getName() + " : " + f.length());
            }
        }
    }

    public static void main(String[] args) {
        printSize(3, new File(rootFolder));
    }
}
