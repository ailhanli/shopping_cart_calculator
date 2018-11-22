package com.ailhanli.calculator;

import com.ailhanli.calculator.decider.CampaignDiscountDecider;
import com.ailhanli.calculator.strategy.CampaignDiscountStrategy;
import com.ailhanli.domain.Campaign;
import com.ailhanli.domain.ShoppingCart;
import com.ailhanli.domain.SalesItem;

public class CampaignCalculator implements DiscountCalculator {

	private CampaignDiscountStrategy calculator;

	private CampaignDiscountDecider decider;

	public CampaignCalculator(CampaignDiscountStrategy calculator, CampaignDiscountDecider decider) {
		super();
		this.calculator = calculator;
		this.decider = decider;
	}

	@Override
	public double calculate(ShoppingCart card) {

		double totalDiscount = 0d;
		for (SalesItem item : card.getItems()) {
			for (Campaign campaign : card.getCampaigns()) {
				double discount = getDiscount(item, campaign);
				
				item.updateDiscountAmount(discount); //update discount for every CardItem
				totalDiscount += discount;
			}
		}

		return totalDiscount;
	}

	public double getDiscount(SalesItem item, Campaign campaign) {
		if (decider.canApplyDiscount(item, campaign)) {
			return calculator.calculate(campaign, item.getNumberOfProducts(), item.getNetPrice());
		}
		return 0d; // NO DISCOUNT for this item
	}
}