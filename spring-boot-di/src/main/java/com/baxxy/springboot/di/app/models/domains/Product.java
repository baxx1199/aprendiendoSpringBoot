package com.baxxy.springboot.di.app.models.domains;

public class Product {
	private String nameProduct;
	private Integer price;

	public Product(String nameProduct, Integer price) {

		this.nameProduct = nameProduct;
		this.price = price;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
