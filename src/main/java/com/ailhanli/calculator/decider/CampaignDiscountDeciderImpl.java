package com.ailhanli.calculator.decider;

import com.ailhanli.domain.Campaign;
import com.ailhanli.domain.SalesItem;
import com.ailhanli.domain.Category;

public class CampaignDiscountDeciderImpl implements CampaignDiscountDecider {

	@Override
	public boolean canApplyDiscount(SalesItem cardItem, Campaign campaign) {
		int numberOfProductsToBuy = cardItem.getNumberOfProducts();
		Category categoryOfProducyToBuy = cardItem.getProduct().getCategory();
		Category itemCategory = cardItem.getProduct().getCategory();

		return checkCategory(itemCategory, categoryOfProducyToBuy)
				&& numberOfProductsToBuy >= campaign.getNumberOfItems();
	}
	
	public boolean checkCategory(Category itemCategory, Category campaignCategory){
		if(itemCategory==null){
			return false;
		}
		if(campaignCategory.equals(itemCategory)){
			return true;
		}
		
		return checkCategory(itemCategory.getParent(), campaignCategory);
	}

}
