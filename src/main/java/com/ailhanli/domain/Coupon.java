package com.ailhanli.domain;

public class Coupon {

	private double minumumAmount;
	
	private double rate;
	
	private DiscountType discountType;

	public Coupon(double minumumAmount, double rate, DiscountType discountType) {
		super();
		this.minumumAmount = minumumAmount;
		this.rate = rate;
		this.discountType = discountType;
	}

	public double getMinumumAmount() {
		return minumumAmount;
	}
	
	public double getRate() {
		return rate;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}
}