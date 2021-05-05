package Hyena.csv;

import Hyena.Hyena;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {
    private File file;
    private String[] fields;
    public ArrayList<String[]> datas;
    private static final String SEPARATOR = ";";

    public CSVParser(File file) throws IOException {
        this.file = file;
        this.datas = new ArrayList<String[]>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = null;
        int lineNum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (lineNum == 0) {
                this.fields = line.split(SEPARATOR);
            } else {
                this.datas.add(line.split(SEPARATOR));
            }
            lineNum += 1;
        }
    }

    public String getField(String field, String[] datas) {
        for (int fieldNum = 0; fieldNum != this.fields.length; fieldNum++) {
            if (field.equals(this.fields[fieldNum]))
                return (datas[fieldNum]);
        }
        return (null);
    }
}
