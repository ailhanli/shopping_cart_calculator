package com.ailhanli.util;

import com.ailhanli.domain.SalesItem;
import com.ailhanli.domain.ShoppingCart;

public class TotalNumberOfCardItemCalculator {

	private ShoppingCart cart;

	public TotalNumberOfCardItemCalculator(ShoppingCart cart) {
		super();
		this.cart = cart;
	}
	
	public int getTotalNumberOfProducts(){
		return cart
		.getItems()
		.stream()
		.mapToInt(SalesItem::getNumberOfProducts)
		.sum();
	}
	
	public int getTotalNumberOfProducts(String productTitle){
		return cart
		.getItems()
		.stream()
		.filter(c->c.getProduct().getTitle().equals(productTitle))
		.mapToInt(SalesItem::getNumberOfProducts)
		.sum();
	}
}