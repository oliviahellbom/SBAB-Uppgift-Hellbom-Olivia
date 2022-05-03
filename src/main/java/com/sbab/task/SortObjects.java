package com.sbab.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortObjects {
	public List<Product> sortBySize(ArrayList<Product> productList){
			
			Comparator<Product> compareBySize = new Comparator<Product>() {
				public int compare(Product o1, Product o2) {
					return o1.getSize().compareTo(o2.getSize());
				}
			};
			
			Collections.sort(productList, compareBySize.reversed());
			
			return productList;
    }
}
