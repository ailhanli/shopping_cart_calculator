package com.ailhanli.util;

import com.ailhanli.domain.ShoppingCart;

public class TotalPurchasePriceCalculator {

	private ShoppingCart card;

	public TotalPurchasePriceCalculator(ShoppingCart card) {
		super();
		this.card = card;
	}

	public double calculate() {
		return card
			   .getItems()
			   .stream()
			   .map(item -> item.getNumberOfProducts() * item.getProduct().getPrice())
			   .reduce(Double::sum)
			   .orElse(0d);
	}
}