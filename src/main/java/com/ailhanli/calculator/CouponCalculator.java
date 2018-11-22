package com.ailhanli.calculator;

import com.ailhanli.calculator.decider.CouponDiscountDecider;
import com.ailhanli.calculator.strategy.CouponDiscountStrategy;
import com.ailhanli.domain.ShoppingCart;
import com.ailhanli.util.CouponRatePerProductCalculator;

public class CouponCalculator implements DiscountCalculator{

	private CouponDiscountStrategy calculator;
	
	private CouponDiscountDecider decider;
	
	private CouponRatePerProductCalculator couponRatePerProductCalculator;

	public CouponCalculator(CouponDiscountStrategy calculator, CouponDiscountDecider decider, CouponRatePerProductCalculator couponRatePerProductCalculator ) {
		super();
		this.calculator = calculator;
		this.decider = decider;
		this.couponRatePerProductCalculator = couponRatePerProductCalculator;
	}

	@Override
	public double calculate(ShoppingCart cart) {
		if (decider.canApplyDiscount(cart)) {
			double couponDiscount= calculator.calculate(cart.getCoupon(), cart.getTotalAmount());
			couponRatePerProductCalculator.setCouponDiscount(couponDiscount);
			couponRatePerProductCalculator.updateCartItemDiscount();
			return couponDiscount;
		}
		return 0d; //NO DISCOUNT for this item
	}
}