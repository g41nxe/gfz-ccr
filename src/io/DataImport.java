package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class DataImport {

	private List<List<Float>> data;
	private File file;
	private int rows, cols;

	private final static Logger l = Logger
			.getLogger(DataImport.class.getName());

	public DataImport(File file) throws FileNotFoundException {
		this.file = file;

		if (!file.exists()) {
			l.severe("Error: File " + file.getAbsolutePath() + file.getName()
					+ " does not exist.");
			throw new FileNotFoundException();
		}

		// calc col and row count
		int rows = 0, cols = 0;
		
		Scanner scanner = new Scanner(file);
		for (rows = 0; scanner.hasNextLine(); rows++) {
			int tmp = scanner.nextLine().split("\\s+").length;
			if (tmp > cols)
				cols = tmp;
		}
		scanner.close();

		// init
		this.rows = rows;
		this.cols = cols;

		data = new ArrayList<List<Float>>(this.cols);
		for (int i = 0; i < cols; i++)
			data.add(new ArrayList<Float>(this.rows));
	}

	public List<List<Float>> importFromTxt() throws IOException {
		l.info("Reading from file " + file.getName());

		Scanner scanner = new Scanner(file);
		for (int row = 0; scanner.hasNextLine(); row++) {

			Scanner s = new Scanner(scanner.nextLine());
			for (int i = 0; s.hasNext("\\S+"); i++) {
				data.get(i).add(Float.parseFloat(s.next("\\S+")));
			}
			s.close();
		}
		scanner.close();

		l.info("File successfully read. " + cols + " data sets a " + rows
				+ " values.");

		return data;
	}
}
