package com.sbab.task;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//Calls the method for reading/parsing the files and method for printing data for each file type 
		
		HandleFiles handleFile = new HandleFiles();
		System.out.println("\n Program opens clothes.csv");
		List<Product>productListCsv = handleFile.ParseFile("csv");
		PresentFiles.printFile(productListCsv);

		System.out.println("\n Program opens clothes.xml");
		List<Product>productListXml = handleFile.ParseFile("xml");
		PresentFiles.printFile(productListXml);

		System.out.println("\n Program opens clothes.json");
		List<Product>productListJson = handleFile.ParseFile("json");
		PresentFiles.printFile(productListJson);
	}
}
