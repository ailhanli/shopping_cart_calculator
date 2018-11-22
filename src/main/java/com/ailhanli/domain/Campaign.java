package com.ailhanli.domain;

public class Campaign {

	private Category category;

	private int numberOfItems;

	private double rate;

	private DiscountType discountType;

	public Campaign(Category category, int numberOfItems, double rate, DiscountType discountType) {
		super();
		this.category = category;
		this.numberOfItems = numberOfItems;
		this.rate = rate;
		this.discountType = discountType;
	}

	public Category getCategory() {
		return category;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public double getRate() {
		return rate;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}
}