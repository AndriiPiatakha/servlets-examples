package examplediploma.services.impl;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import examplediploma.models.OrderData;
import examplediploma.models.UserData;

public class BonusCalculationService {
	
	public static final double DISCOUNT_RATE = 0.05;
	public static final double REFERAL_BONUS_RATE = 0.05;
	public static final int TOURS_AMOUNT_BONUS_TRESHOLD = 10;

	public BigDecimal getDiscountForOrderAndUser(OrderData order, UserData user) {
		if (order == null || user == null) {
			// For the sake of example in unit testing
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("specific error message");
			illegalArgumentException.initCause(new FileNotFoundException());
			throw illegalArgumentException;
		}
		BigDecimal discount = BigDecimal.valueOf(0);
		
		if (user.getTours() == null || user.getTours().size() == 0) {
			return discount;
		}
		
		if (user.getTours().size() >= TOURS_AMOUNT_BONUS_TRESHOLD) {
			discount = discount.add( order.getTotalAmount()
					.multiply(BigDecimal.valueOf(DISCOUNT_RATE)).setScale(2, RoundingMode.HALF_UP));
		}
			
		return discount;
	}

	public void processBonuesForReferer(UserData refererUser, OrderData order) {
		BigDecimal refererBonus = order.getTotalAmount()
				.multiply(BigDecimal.valueOf(REFERAL_BONUS_RATE).
						setScale(2, RoundingMode.HALF_UP));
		if (refererUser.getMoney() == null) {
			refererUser.setMoney(BigDecimal.valueOf(0));
		}
		
		refererUser.setMoney(refererUser.getMoney()
				.add(refererBonus)
				.setScale(2, RoundingMode.HALF_UP));
	}

}
