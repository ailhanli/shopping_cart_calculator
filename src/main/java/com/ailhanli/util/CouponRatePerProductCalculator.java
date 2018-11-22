package com.ailhanli.util;

import com.ailhanli.domain.ShoppingCart;

public class CouponRatePerProductCalculator {
	
	private TotalNumberOfCardItemCalculator totalCalculator;

	private ShoppingCart cart;
	
	private double couponDiscount;

	public CouponRatePerProductCalculator(ShoppingCart cart) {
		super();
		this.cart = cart;
	}
	
	public void setCouponDiscount(double couponDiscount) {
		this.couponDiscount = couponDiscount;
	}
	
	public void updateCartItemDiscount(){
		int totalNumberOfProducts = totalCalculator.getTotalNumberOfProducts();
		
		cart
		.getItems()
		.stream()
		.forEach(item->{
			double discountRate = (double)totalCalculator.getTotalNumberOfProducts(item.getProduct().getTitle())/totalNumberOfProducts;
			double couponDiscountPerProduct = couponDiscount*discountRate;
			item.updateDiscountAmount(couponDiscountPerProduct);
		});
		
	}
	
	
}