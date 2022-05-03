package com.sbab.task;

import java.util.ArrayList;
import java.util.List;

public class PresentFiles {
		
	public void callMethods() {
			
			String answer="";
			
			try {
					System.out.println("\n Program opens clothes.csv");
					answer="csv";
					printFile(answer);
					System.out.println("\n Program opens clothes.xml");
					answer="xml";
					printFile(answer);
					System.out.println("\n Program opens clothes.Json");
					answer="json";
					printFile(answer);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void printFile(String answer) {
			
			String type = null;
			String size = null;
			String brand = null;
			String color = null;
			String headers= null;
			ArrayList<Product> ProductList;
			
			HandleFiles handleFile = new HandleFiles();
			ProductList = new ArrayList<Product>(handleFile.ParseFile(answer));
			
			SortObjects sortObjects = new SortObjects();
			
	        List<Product>sortedBySize = sortObjects.sortBySize(ProductList);
	        List<Product>sizeXlList = new ArrayList<Product>();
			
			try {
				headers = "Type:"+"\t\t"+"Size:"+"\t\t"+"Brand:"+"\t\t"+"Color: \t\t";
				System.out.println(headers);
			
				for(Product product: sortedBySize) {		
					if(product.getSize().equals("XL")) {
						sizeXlList.add(product);
					}
					else {				
						size = formatText(product.getSize()); 
						type= formatText(product.getType()); 
						color = formatText(product.getColor()); 
						brand = formatText(product.getBrand());
						
						System.out.println(type + size + brand + color);
					}		
				}
				
				if(!sizeXlList.isEmpty()) {				
					for(Product prod: sizeXlList) {
						
						size = formatText(prod.getSize()); 
						type= formatText(prod.getType()); 
						color = formatText(prod.getColor()); 
						brand = formatText(prod.getBrand()); 
						
						System.out.println(type + size + brand + color);
					}
				}
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		public static String formatText(String in) {
			String out;
			
			if (in.length()>7) {
				out =	in + "\t";
			}else {						
				out = in + "\t" + "\t"; 
			}
		
			return out;
		}
}
