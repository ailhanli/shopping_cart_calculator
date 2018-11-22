package com.ailhanli.calculator.decider;

import com.ailhanli.domain.Campaign;
import com.ailhanli.domain.SalesItem;

public interface CampaignDiscountDecider {

	boolean canApplyDiscount(SalesItem cardItem, Campaign campaign);	
}
