package examplediploma.services.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import examplediploma.models.TourData;
import examplediploma.models.OrderData;
import examplediploma.models.UserData;

public class BonusCalculationServiceTest {
	
	private static final int RANDOM_ORDER_TOTAL_AMOUNT = 1000;
	private static final double DISCOUNT_RATE = 0.05;
	private static final int TOURS_AMOUNT_BONUS_TRESHOLD = 10;
	
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
	 * - @BeforeClas & @AfterClass
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
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenOrderIsNull() {
		testInstance.getDiscountForOrderAndUser(null, new UserData());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenUserIsNull() {
		testInstance.getDiscountForOrderAndUser(new OrderData(), null);
	}
	
	@Test
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


}
