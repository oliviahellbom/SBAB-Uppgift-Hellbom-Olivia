package com.sbab.task;

public class Product {
	private String type;
	private String size;
	private String brand;
	private String color;
	
	public Product() {
        super();
    }

    public Product(String type, String size, String brand, String color){
        super();
        this.type = type;
        this.size = size;
        this.brand = brand;
        this.color = color;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
