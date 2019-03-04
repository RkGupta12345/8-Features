package com.stream.baeldung;

public class Product {
	private float price;
	private String name;

	public Product(float price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", name=" + name + "]";
	}

}
