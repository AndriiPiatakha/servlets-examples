package examplediploma.services.impl;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsInstanceOf.*;
import static org.hamcrest.core.IsEqual.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import examplediploma.models.TourData;
import examplediploma.models.OrderData;
import examplediploma.models.UserData;

public class BonusCalculationServiceTest {
	
	private static final double REFERAL_BONUS = 0.05;
	private static final int RANDOM_ORDER_TOTAL_AMOUNT = 1000;
	private static final int RANDOM_ORDER_TOTAL_AMOUNT2 = 2000;
	private static final double DISCOUNT_RATE = 0.05;
	private static final int TOURS_AMOUNT_BONUS_TRESHOLD = 10;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	private BonusCalculationService testInstance;
	
	// FIRST
	/*
	 *   	FAST 
	 * 		ISOLATED 
	 * 		REPEATABLE 
	 * 		SELF-VALIDATING
	 * 		TIMELY
	 */
	
	// BDD approach for test naming (GIVEN, WHEN, THEN) 
	
	// TODO: ExceptionRule

	/*
	 * TODO: Share information about:
	 * - @After
	 * - @BeforeClass & @AfterClass
	 * - @Rule
	 * - TDD Approach
	 * - @RunWith
	 * - @Suite
	 * 
	 * 
	 */
	
	@Before
	public void setUp() {
		testInstance = new BonusCalculationService();
	}
	
	@Test
	public void shouldThrowExceptionWhenOrderIsNull() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(equalTo("specific error message"));
		expectedException.expectCause(instanceOf(FileNotFoundException.class));
		testInstance.getDiscountForOrderAndUser(null, new UserData());
	}
	
	@Test
	public void shouldThrowExceptionWhenUserIsNull() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(equalTo("specific error message"));
		expectedException.expectCause(instanceOf(FileNotFoundException.class));
		testInstance.getDiscountForOrderAndUser(new OrderData(), null);
	}
	
	@Test(timeout = 100)
	public void shouldReturnDiscountWhenUserHasMoreThanAvailableTresholdToursAmount() {
		// GIVEN
		UserData user = new UserData();
		List<TourData> tours = new ArrayList<TourData>();
		for (int i = 0; i < TOURS_AMOUNT_BONUS_TRESHOLD; i++) {
			tours.add(new TourData());
		}
		user.setTours(tours);
		OrderData order = new OrderData();
		order.setTotalAmount(BigDecimal.valueOf(RANDOM_ORDER_TOTAL_AMOUNT));
		
		//WHEN
		BigDecimal discount = testInstance
				.getDiscountForOrderAndUser(order, user);
		
		//THEN
		assertEquals(BigDecimal.valueOf(50).setScale(2), discount);
	}
	
	@Test
	public void shouldReturnZeroDiscountWhenUserHasNoTours() {
		BigDecimal discount = testInstance
				.getDiscountForOrderAndUser(new OrderData(), new UserData());
		
		assertEquals(BigDecimal.valueOf(0), discount);
	}
	
	@Test
	public void shouldReturnZeroDiscountWhenUserHasLessThanAvailableTresholdToursAmount() {
		UserData user = new UserData();
		List<TourData> tours = new ArrayList<TourData>(Arrays.asList(new TourData()));
		user.setTours(tours);
		
		BigDecimal discount = testInstance
				.getDiscountForOrderAndUser(new OrderData(), user);
		
		assertEquals(BigDecimal.valueOf(0), discount);
	}
	
	@Test
	public void shouldReturnZeroDiscountWhenUserHasZeroToursAmount() {
		UserData user = new UserData();
		List<TourData> tours = new ArrayList<TourData>();
		user.setTours(tours);
		
		BigDecimal discount = testInstance
				.getDiscountForOrderAndUser(new OrderData(), user);
		
		assertEquals(BigDecimal.valueOf(0), discount);
	}
	
	
	
	//====================== TDD
	
	/*
	 * Red - Green - Refactor
	 */
	
	/*
	 * - покрыть юнит тестом начисление реферальных бонусов при покупке тура
	 * 
	 * - Bonus Service should be able to add bonuses to the referer
	 * - Bonus Service should be able to calculate referer bonus
	 * 
	 */
	
	@Test
	public void shouldAddMoneyToReferer() {
		UserData refererUser = new UserData();
		OrderData order = new OrderData();
		order.setTotalAmount(BigDecimal.valueOf(RANDOM_ORDER_TOTAL_AMOUNT));
		
		BigDecimal initialMoneyBalance = refererUser.getMoney();
		
		testInstance.processBonuesForReferer(refererUser, order);
		
		assertEquals(BigDecimal.valueOf(50).setScale(2, RoundingMode.HALF_UP)
				, refererUser.getMoney());
	}
	
	@Test
	public void shouldAddMoneyToReferer2() {
		UserData refererUser = new UserData();
		OrderData order = new OrderData();
		order.setTotalAmount(BigDecimal.valueOf(RANDOM_ORDER_TOTAL_AMOUNT2));
		
		BigDecimal initialMoneyBalance = refererUser.getMoney();
		
		testInstance.processBonuesForReferer(refererUser, order);
		
		assertEquals(BigDecimal.valueOf(100).setScale(2, RoundingMode.HALF_UP), 
				refererUser.getMoney());
	}
	
	@Test
	@Ignore
	public void shouldCalculateRefererBonus() {
		OrderData order = new OrderData();
		BigDecimal refererBonus = order.getTotalAmount()
				.multiply(BigDecimal.valueOf(REFERAL_BONUS).
						setScale(2, RoundingMode.HALF_UP));
	}



}
