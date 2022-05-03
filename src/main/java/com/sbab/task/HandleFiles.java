package com.sbab.task;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.opencsv.CSVReader;

public class HandleFiles {
	
		public List<Product> ParseFile (String fileFormat) {
			List <Product> products = null;
		
			try {		
				if (fileFormat.equals("xml")) {
					products = parseTheXml();
				}
				
				if (fileFormat.equals("csv")) {
					products = parseTheCsv();
				}
				
				if (fileFormat.equals("json")) {
					products = parseTheJson();
				}
			
				return products;
					
			}catch (Exception e) {
				e.printStackTrace();  
			}
				return products;
		}
			
		public List<Product> parseTheXml(){
			List<Product> xmlProducts = new ArrayList<Product>();
			String type = null;
			String size = null;
			String color = null;
			String brand = null;
			
			try {
				File xmlFile = new File("src/test/resources/Clothes.xml");  
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
				
				DocumentBuilder db = dbf.newDocumentBuilder();  
				org.w3c.dom.Document doc = db.parse(xmlFile);  
				doc.getDocumentElement().normalize();  
				
				org.w3c.dom.NodeList nodeList = doc.getElementsByTagName("garment");  

				for (int i = 0; i < nodeList.getLength(); i++){  
					org.w3c.dom.Node node = nodeList.item(i);  
										
					if (node.getNodeName() == "garment"){  
						
						org.w3c.dom.Element element = (org.w3c.dom.Element) node;  
						
						if(element.getElementsByTagName("type") != null) {
							type = element.getElementsByTagName("type").item(0).getTextContent();  
						}
						if(element.getElementsByTagName("size") != null) {
							size = element.getElementsByTagName("size").item(0).getTextContent();  
						}
						if(element.getElementsByTagName("color") != null) {
							color = element.getElementsByTagName("color").item(0).getTextContent();  
						}					
						if(element.getElementsByTagName("brand").item(0) != null) {
							brand = element.getElementsByTagName("brand").item(0).getTextContent();  
						}				
						else {
							brand = "Null";  
						}
					}  
					
					Product product = new Product(type, size, brand, color);					
					xmlProducts.add(product);
				
				}  
			}catch (Exception e)   
			{  
				e.printStackTrace();  
			}

			return xmlProducts;  
		}
		public List<Product> parseTheJson() {
			
			ArrayList<Product> jsonProducts = new ArrayList<Product>();
		
		    try {	

		        Object obj = new JSONParser().parse(new FileReader("src/test/resources/Clothes.json"));	        
		        JSONObject jo = (JSONObject) obj;	     
		        JSONArray clothingArray = (JSONArray) jo.get("clothes");
		        	      	
		        for(int i =0; i<clothingArray.size(); i++) {
		        	
					JSONObject clothObject = (JSONObject) ((JSONArray) clothingArray).get(i);
		                          
		            String type = (String) clothObject.get("type");    	                 
		            String size = (String) clothObject.get("size");  
		            String brand = (String) clothObject.get("brand");    
		            String color = (String) clothObject.get("color");    
		                
	                Product product = new Product(type, size, brand, color);
	                jsonProducts.add(product);
	                
	            }//Stänger for-loop		        
		    }catch (Exception e) {
			    	e.printStackTrace();
		    }//Stänger catch
		    
			return jsonProducts;
		}//Stänger 
		
		public List<Product> parseTheCsv() {		
			
			ArrayList<Product> csvProducts = new ArrayList<Product>();	
			CSVReader reader = null;  
			
			try {  
				
				reader = new CSVReader(new FileReader("src/test/resources/Clothes.csv"));   
				String [] nextLine;  
				int counter=0;
						
				while ((nextLine = reader.readNext()) != null){  
					
					for(String token : nextLine){  
						
						String[] result = token.split(";");
						String type = result[0];
						String size = result[1];
						String brand = result[2];
						String color = result[3];

						if(counter >= 1) {			
							Product product = new Product(type, size, brand, color);
							csvProducts.add(product);
						}
						
						counter +=1; 
						
					}//Stänger for-loop  
				}//Stänger while-loop        
		  }catch(Exception e) {
			  e.printStackTrace();
		  }//Stänger catch
			
			return csvProducts;
		}//Stänger metod parseTheCsv()
}
