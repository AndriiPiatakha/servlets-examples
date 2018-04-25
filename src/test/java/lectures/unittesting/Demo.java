package lectures.unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class Demo {

	@Test
	public void tst_emptyness() {
		double a = 5;
		double b = 2;
		assertEquals(2.5, a / b, 0.01);
	}
	
	@Test
	public void test() {
		double c = 1.9999;
		System.out.println(Math.round(c));
	}
}
