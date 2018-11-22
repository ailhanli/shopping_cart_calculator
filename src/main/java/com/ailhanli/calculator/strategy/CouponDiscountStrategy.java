package com.ailhanli.calculator.strategy;

import com.ailhanli.domain.Coupon;

public interface CouponDiscountStrategy {

	double calculate(Coupon coupon, double priceToDiscount);
}