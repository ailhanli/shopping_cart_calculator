package com.ailhanli.calculator.decider;

import com.ailhanli.domain.ShoppingCart;

public class CouponDiscountDeciderImpl implements CouponDiscountDecider {

	@Override
	public boolean canApplyDiscount(ShoppingCart card) {
		double totalPurchase= card.getTotalAmount();
		
		return totalPurchase >= card.getCoupon().getMinumumAmount();
	}
}