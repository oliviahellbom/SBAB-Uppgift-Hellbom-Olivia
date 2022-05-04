package com.sbab.task;

import java.util.ArrayList;
import java.util.List;

public class PresentFiles {

	/* Reads the list of objects
	*  Presents data from each file in order 
	*/
	public static void printFile(List<Product> productListIn) {
				
		String type = null;
		String size = null;
		String brand = null;
		String color = null;
		String headers= null;		
		
		
		SortObjects sortObjects = new SortObjects();
		
	    List<Product>sortedBySize = sortObjects.sortBySize(productListIn);
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
			e1.printStackTrace();
		}
	}
	//Checks the string to make the output presentation correct
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
