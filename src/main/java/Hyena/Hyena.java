package Hyena;

import Hyena.csv.CSVParser;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hyena{
	public ArrayList<DataType> dataTypes;

	public static void main(String args[]) throws IOException {
		File currentFile;
		ArrayList<File> filesToSearch = new ArrayList<File>();
		if (args.length > 0) {
			for (String arg : args) {
				currentFile = new File(arg);
				fileFiller(currentFile, filesToSearch);
			}
			Hyena hyena = new Hyena("C:\\Users\\admin1\\IdeaProjects\\Hyena\\src\\main\\resources\\expressions.csv", filesToSearch);

		} else {
			System.err.println("Please specify files or directory !");
		}
	}

	public Hyena(String expressionsFile, ArrayList<File> files) throws IOException {
		loadExpressions(expressionsFile);
		for (File f : files) {
			scanFile(f);
		}
	}

	private void loadExpressions(String expressionsFile) throws IOException {
		this.dataTypes = new ArrayList<DataType>();
		CSVParser csvParser = new CSVParser(new File(expressionsFile));
		for (String [] entry : csvParser.datas) {
			this.dataTypes.add(new DataType(csvParser.getField("name", entry), csvParser.getField("expression", entry)));
		}
	}

	private void scanFile(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				for (DataType dt : this.dataTypes) {
					Matcher m = Pattern.compile(dt.getExpression()).matcher(line);

					while (m.find()) {
						System.out.println("Found "+dt.getName()+" in file "+file.getName()+" :"+m.group());
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void fileFiller(File file, ArrayList<File> files) {
		if (file.exists()) {
			if (file.isFile()) {
				files.add(file);
			} else {
				RecursiveFileEnumerator rfe = new RecursiveFileEnumerator(file);
				files.addAll(rfe.getAsArrayList());
			}
		} else {
			System.err.println("File " + file.getName() + " don't exist !");
		}
	}
}


//java -jar Hyena.jar dqsdqsdsq qsdqsdqs.jar dqsdqsd