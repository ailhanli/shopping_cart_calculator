package com.ailhanli.domain;

public class SalesItem {

	private Product product;
	
	private int numberOfProducts;
	
	private double discountPerProduct;
			
	public SalesItem(Product product, int numberOfProducts) {
		this.product = product;
		this.numberOfProducts=numberOfProducts;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int getNumberOfProducts() {
		return numberOfProducts;
	}
	
	public void updateDiscountAmount(double newDiscount){
		discountPerProduct+=(double)(newDiscount/numberOfProducts);
	}
	
	public double getDiscountAmount() {
		return discountPerProduct;
	}
	
	public double getNetPrice(){
		return product.getPrice()-discountPerProduct;
	}
}