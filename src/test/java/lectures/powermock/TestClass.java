package lectures.powermock;

import org.junit.Test;

public class TestClass {
	
	private Stub stub = new Stub();
	
	@Test
	public void test() {
		stub.setA(1);
		System.out.println(stub.a);
	}

	@Test
	public void test2() {
//		stub.setA(1);
		System.out.println(stub.a);
	}
}

class Stub {
	public int a;
	
	void setA (int a) {
		this.a = a;
	}
}
