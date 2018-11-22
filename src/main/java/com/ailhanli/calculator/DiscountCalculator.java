package com.ailhanli.calculator;

import com.ailhanli.domain.ShoppingCart;

public interface DiscountCalculator {
	double calculate(ShoppingCart card);
}
