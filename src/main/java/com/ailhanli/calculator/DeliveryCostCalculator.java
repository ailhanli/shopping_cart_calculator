package com.ailhanli.calculator;

import com.ailhanli.domain.ShoppingCart;
import com.ailhanli.util.NumberOfDeliveryCalculator;
import com.ailhanli.util.NumberOfProductCalculator;

public class DeliveryCostCalculator{

	private double fixedCost = 2.99;

	private double costPerDelivery;
	
	private double costPerProduct;
	
	private NumberOfDeliveryCalculator numberOfDeliveryCalculator;
	
	private NumberOfProductCalculator numberOfProductCalculator;

	public DeliveryCostCalculator(double fixedCost, double costPerDelivery, double costPerProduct) {
		super();
		this.fixedCost = fixedCost;
		this.costPerDelivery = costPerDelivery;
		this.costPerProduct = costPerProduct;
	}
	
	public void setNumberOfDeliveryCalculator(NumberOfDeliveryCalculator numberOfDeliveryCalculator) {
		this.numberOfDeliveryCalculator = numberOfDeliveryCalculator;
	}

	public void setNumberOfProductCalculator(NumberOfProductCalculator numberOfProductCalculator) {
		this.numberOfProductCalculator = numberOfProductCalculator;
	}
	
	public double calculateFor(ShoppingCart cart) {
		
		long numberOfDelivery = numberOfDeliveryCalculator.calculate(cart);
		long numberOfProduct = numberOfProductCalculator.calculate(cart);
		
		// formula: (costPerDelivery*NumberOfDelivery) + (costPerProduct*numberOfProduct) + fixedCost
		return (costPerDelivery*numberOfDelivery) + (costPerProduct*numberOfProduct) + fixedCost;
	}
}