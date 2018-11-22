package com.ailhanli.calculator.decider;

import com.ailhanli.domain.ShoppingCart;

public interface CouponDiscountDecider {

	boolean canApplyDiscount(ShoppingCart card);
	
}
