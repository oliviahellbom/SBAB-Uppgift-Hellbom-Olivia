package com.sbab.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortObjects {
	
	public List<Product> sortBySize(ArrayList<Product> productList){
		
		Comparator<Product> compareBySize = new Comparator<Product>() {
			public int compare(Product product1, Product product2) {
				return product1.getSize().compareTo(product2.getSize());
			}
		};
		
		Collections.sort(productList, compareBySize.reversed());
		
		return productList;
    }
}
