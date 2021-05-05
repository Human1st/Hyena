package Hyena;

import java.io.File;
import java.util.ArrayList;

public class RecursiveFileEnumerator {
    File folder;

    public RecursiveFileEnumerator(File folder) {
        this.folder = folder;
    }

    public ArrayList<File> getAsArrayList() {
        return recursiveScanFolder(folder);
    }

    private ArrayList<File> recursiveScanFolder(File folder)
    {
        ArrayList<File> files = new ArrayList<File>();
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                files.addAll(recursiveScanFolder(file));
            } else {
                files.add(file);
            }
        }
        return files;
    }
}
