package com.salesmans.expances;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvtoModelMapper {

	public static List<SalesmanExpensesDTO> csvMapper(String csvFilePath) throws IOException {
		String line = null;
		int count = 0;
		List<SalesmanExpensesDTO> expanses = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(csvFilePath)));) {
			while ((line = br.readLine()) != null) {
				count++;
				if (count != 1) {
					String[] data = line.split(",");
					expanses.add(new SalesmanExpensesDTO(data[0], data[1], data[2], Double.valueOf(data[3])));
				}
			}
		}
		return expanses;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(csvMapper("expancess.txt"));
	}
}
