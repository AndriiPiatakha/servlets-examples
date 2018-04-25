package lectures.unittesting;

import org.junit.Rule;
import org.junit.Test;

public class MyTestMyRule {

	@Rule
	public MyRule myRule = new MyRule();

	@Test
	public void testRun() {
		System.out.println("during");
	}
}
