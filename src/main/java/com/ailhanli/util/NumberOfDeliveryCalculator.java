package com.ailhanli.util;

import java.util.stream.Collectors;

import com.ailhanli.domain.ShoppingCart;
import com.ailhanli.domain.SalesItem;
import com.ailhanli.domain.Product;

public class NumberOfDeliveryCalculator {
	
	public long calculate(ShoppingCart card) {
		return card
			   .getItems()
			   .stream()
			   .map(SalesItem::getProduct)
			   .map(Product::getCategory)
			   .collect(Collectors.toSet())
			   .size();
	}	
}