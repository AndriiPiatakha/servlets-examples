package lectures.unittesting;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class MyRule implements MethodRule {

	@Override
	public Statement apply(Statement base, FrameworkMethod method, Object target) {
		System.out.println("Method = " + method);
		System.out.println("Target = " + target);
		return new MyStatement(base);
	}
}

class MyStatement extends Statement {
	private final Statement base;

	public MyStatement(Statement base) {
		this.base = base;
	}

	@Override
	public void evaluate() throws Throwable {
		System.out.println("before");
		System.out.println(5 / 0);
		try {
			base.evaluate();
		} finally {
			System.out.println("after");
		}
	}
}
