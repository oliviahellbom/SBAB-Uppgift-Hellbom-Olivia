package com.sbab.task;

public class Main {

	public static void main(String[] args) {
		
		//Calls the method for printing data for each file type 
		String csv = "csv";
		String xml = "xml";
		String json = "json";
						
		PresentFiles.printFile(csv);
		PresentFiles.printFile(xml);
		PresentFiles.printFile(json);
	}
}
