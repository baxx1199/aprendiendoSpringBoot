package com.baxxy.springboot.di.app.models.domains;

public class ItemInvoice {

	private Product product;
	private Integer quantity;

	public ItemInvoice(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	public Integer getTotalPrice() {
		return product.getPrice() * quantity;
	}
}
