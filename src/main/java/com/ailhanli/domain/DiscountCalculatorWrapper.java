package com.ailhanli.domain;

import com.ailhanli.calculator.DiscountCalculator;

public class DiscountCalculatorWrapper implements Comparable<DiscountCalculatorWrapper>{

	private DiscountCalculator discountCalculator;

	private int priority;

	public DiscountCalculatorWrapper(DiscountCalculator discountCalculator, int priority) {
		super();
		this.discountCalculator = discountCalculator;
		this.priority = priority;
	}

	public DiscountCalculator getDiscountCalculator() {
		return discountCalculator;
	}
	
	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(DiscountCalculatorWrapper o) {
		if(priority>o.getPriority()){
			return 1;
		}else if(priority<o.getPriority()){
			return -1;
		}
		return 0;
	}
	
	
}
