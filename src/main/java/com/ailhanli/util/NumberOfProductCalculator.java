package com.ailhanli.util;

import java.util.stream.Collectors;

import com.ailhanli.domain.ShoppingCart;
import com.ailhanli.domain.SalesItem;

public class NumberOfProductCalculator {
	public long calculate(ShoppingCart card) {
		return   card
				.getItems()
				.stream()
				.map(SalesItem::getProduct)
				.collect(Collectors.toSet())
				.size();
	}
}