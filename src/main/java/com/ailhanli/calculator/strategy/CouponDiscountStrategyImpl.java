package com.ailhanli.calculator.strategy;

import com.ailhanli.domain.Coupon;
import com.ailhanli.domain.DiscountType;

public class CouponDiscountStrategyImpl implements CouponDiscountStrategy {

	@Override
	public double calculate(Coupon coupon, double priceToDiscount) {
		DiscountType discountType =  coupon.getDiscountType();
		if (discountType == DiscountType.Amount) {
			return coupon.getRate();
		} else if (discountType == DiscountType.Rate) {
			return priceToDiscount * coupon.getRate();
		}
		return 0d;
	}
}