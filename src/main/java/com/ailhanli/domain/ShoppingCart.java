package com.ailhanli.domain;

import java.util.HashSet;
import java.util.Set;

import com.ailhanli.calculator.DeliveryCostCalculator;
import com.ailhanli.calculator.DiscountCalculator;
import com.ailhanli.util.TotalPurchasePriceCalculator;

public class ShoppingCart {

	private Set<SalesItem> items = new HashSet<>();

	private Campaign[] campaigns;

	private Coupon coupon;
	
	private TotalPurchasePriceCalculator totalPriceCalculator;
	
	private DiscountCalculator campaignCalculator;
	
	private DiscountCalculator couponCalculator;
	
	private DeliveryCostCalculator deliveryCostCalculator;
		
	private double totalPriceAfterDiscount;
	
	private double totalCampaignDiscount;

	private double totalCouponDiscount;
	
	private double totalAmount;

	public void setItems(Set<SalesItem> items) {
		this.items = items;
	}
	
	public void addItem(Product product, int numberOfProducts) {
		items.add(new SalesItem(product, numberOfProducts));
		
		totalAmount = totalPriceCalculator.calculate();
		totalPriceAfterDiscount = totalAmount;
	}
	
	public void applyDiscounts(Campaign... campaigns) {
		this.campaigns = campaigns;
		
		if(campaignCalculator!=null){
			totalCampaignDiscount = campaignCalculator.calculate(this);
			totalPriceAfterDiscount-=totalCampaignDiscount;
		}
	}
	
	public void applyCoupon(Coupon coupon) {
		this.coupon = coupon;
		
		if(couponCalculator!=null){
			totalCouponDiscount = couponCalculator.calculate(this);
			totalPriceAfterDiscount-=totalCouponDiscount;
		}
	}

	public Set<SalesItem> getItems() {
		return items;
	}
	public Campaign[] getCampaigns() {
		return campaigns;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public double getTotalAmount() {
		return totalPriceAfterDiscount;
	}

	public double getTotalAmountAfterDiscounts() {
		return getTotalAmount();
	}
	public double getCouponDiscount() {
		return totalCouponDiscount;
	}
	public double getCampaingDiscount() {
		return totalCampaignDiscount;
	}
	public double getDeliveryCost() {
		return deliveryCostCalculator.calculateFor(this);
	}

	public void print() {
		
		for(SalesItem item: items){
			StringBuilder builder = new StringBuilder();

			builder.append("Category name: ");
			builder.append(item.getProduct().getCategory().getTitle());
			builder.append("\n");
			builder.append("Product name: ");
			builder.append(item.getProduct().getTitle());
			builder.append("Quantity: ");
			builder.append(item.getNumberOfProducts());
			builder.append("Unit price: "	);
			builder.append(item.getProduct().getPrice());
			builder.append("Total price: "	);
			builder.append(item.getProduct().getPrice()*item.getNumberOfProducts());
			builder.append("Total discount: "	);
			builder.append(item.getDiscountAmount()*item.getNumberOfProducts());
			builder.append("applied");
			System.out.println(builder.toString());
		}
		
		System.out.println("Total delivery cost: "+getDeliveryCost());
		System.out.println("Total amount: "+totalAmount );
	}
}