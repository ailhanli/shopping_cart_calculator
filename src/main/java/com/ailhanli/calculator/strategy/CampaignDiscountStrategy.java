package com.ailhanli.calculator.strategy;

import com.ailhanli.domain.Campaign;

public interface CampaignDiscountStrategy {

	double calculate(Campaign campaign, double numberOfItems, double priceOfProduct);
}