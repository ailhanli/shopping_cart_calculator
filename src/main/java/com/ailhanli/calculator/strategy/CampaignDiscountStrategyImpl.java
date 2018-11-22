package com.ailhanli.calculator.strategy;

import com.ailhanli.domain.Campaign;
import com.ailhanli.domain.DiscountType;

public class CampaignDiscountStrategyImpl implements CampaignDiscountStrategy {

	@Override
	public double calculate(Campaign campaign, double numberOfItems, double priceOfProduct) {
		DiscountType discountType = campaign.getDiscountType();
		if (discountType.equals(DiscountType.Rate)) {
			return priceOfProduct * numberOfItems * campaign.getRate();
		} else if (discountType.equals(DiscountType.Amount)) {
			return campaign.getRate();
		}
		return 0d;
	}
}