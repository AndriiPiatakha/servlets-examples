package lectures.mockito;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.powermock.api.mockito.*;
import org.hamcrest.core.AnyOf;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.powermock.configuration.PowerMockConfiguration;
import org.powermock.core.classloader.annotations.PrepareForTest;

import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({String.class, Static.class})
public class DemoMock {
	
	@Mock
	private Engine engine;
	
	@Mock
//	(answer=Answers.RETURNS_DEEP_STUBS)
//	@Spy
//	@InjectMocks
	private Car car;
	
//	@Rule
//	public PowerMockRule pmRule;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	@Ignore
	public void shouldMockInterface() {
		Inter mock = mock(Inter.class);
		System.out.println(mock.getClass());
		when(mock.doSomething()).thenCallRealMethod();
		String doSomething = mock.doSomething();
		System.out.println(doSomething);
	}
	
	@Test
	@Ignore
	public void shouldCallRealMethod() {
		Car car = mock(Car.class);
//		when(car.getName()).thenCallRealMethod();
		System.out.println(car.getName());
	}
	
	@Test
	@Ignore
	public void shouldNotThrowException() {
		car.drive();
	}
	
	@Test
//	@Ignore
	public void shouldThrowNullPointerWithoutDeepStub() {
//		car.startEngine();
		Engine engine = car.getEngine();
		engine.start();
		System.out.println(engine.getClass());
	}
	
	@Test
	@Ignore
	public void shouldWorkAsExpected() {
		List<String> mockedList = mock(ArrayList.class);
		when(car.toString()).thenReturn("first");
		when(mockedList.get(or(eq(1), eq(2)))).thenReturn("more");
//		when(mockedList.get(anyOf(is(1), is(2))).thenReturn("more");
		String string = mockedList.get(1);
		String string3 = mockedList.get(3);
		System.out.println("String get 1 = " + string);
		System.out.println("String get 3 = " + string3);
		when(mockedList.get(gt(2))).thenThrow(new RuntimeException());
//		mockedList.get(3); // Now error will be thrown
		verify(mockedList, atLeastOnce()).get(anyInt());
//		verify(mockedList, times(1)).get(anyInt()); // test will fail
		
	}
	
	@Test
	@Ignore
	public void demoSpy() {
		List<String> spyList = spy(new ArrayList<String>());
//		spyList.get(0);
//		when(spyList.get(0)).thenReturn("Hello");	this will throw IOB exception
		doReturn("Hello").when(spyList).get(20);
		String string = spyList.get(20);
		assertThat(string, equalTo("Hello"));
	}
	
	@Test
	@Ignore
	public void demoCaptor() {
		ArgumentCaptor<Engine> captor = ArgumentCaptor.forClass(Engine.class);
		Car carSpy = spy(new Car());
		
		Engine engine = new Engine();
		engine.setName("BMW engine");
		carSpy.setEngine(engine);
		
		carSpy.startEngine();
		
		verify(carSpy).fuelInjection(captor.capture());
		assertThat(captor.getValue().getName(), equalTo("BMW engine"));
	}
	
	@Test
	@Ignore
	public void test6() {
		ArgumentCaptor<Engine> captor = ArgumentCaptor.forClass(Engine.class);
		car.fuelInjection(new Engine());
		verify(car).fuelInjection(captor.capture());
		assertThat(captor.getValue(), instanceOf(Engine.class));
	}
	
	// cannot mock final classes
	@Test
//	@Ignore
	public void shouldThrowExceptionWhenMockFinalClass() {
		String string = mock(String.class);
		when(string.length()).thenReturn(20);
		assertThat(string.length(), equalTo(20));
	}
	
	@Test
	public void shouldThrowExceptionWhenStubEqualsAndHashCode() {
//		when(car.hashCode()).thenReturn(1);
		when(car.equals(new Object())).thenReturn(true);
	}
	
	@Test
	public void shouldThrowExceptionWhenMockStaticMethod() {
		when(car.someStaticMethodInCar()).thenReturn(3);
	}
	
	@Test
	@Ignore
	public void shouldMockFinalClass() {
		String string = PowerMockito.mock(String.class);
		PowerMockito.when(string.length()).thenReturn(20);
		assertThat(string.length(), equalTo(20));
	}
	
	@Test
	@Ignore
	public void shouldMockStaticMethod() {
		PowerMockito.mockStatic(Static.class);
		when(Static.getNumber()).thenReturn(10);
		assertThat(Static.getNumber(), equalTo(10));
	}
	
	@Test
	@Ignore
	public void demoChainOfReturn() {
		Engine engine = mock(Engine.class);
		when(engine.getName()).thenReturn("Engine name")
								.thenReturn("engine name 21");
		
		assertThat(engine.getName(), equalTo("Engine name"));
		assertThat(engine.getName(), equalTo("engine name 21"));
		
		// last stub
		System.out.println(engine.getName());
		
	}
	
	@Test
	@Ignore
	public void demoChainOfReturn2() {
		Engine engine = mock(Engine.class);
		when(engine.getName()).thenReturn("Engine name", "engine name 21");
		
		assertThat(engine.getName(), equalTo("Engine name"));
		assertThat(engine.getName(), equalTo("engine name 21"));
		
		// last stub
		System.out.println(engine.getName());
	}
	
	@Test
	@Ignore
	public void demoAnswer() {
		doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				for (Object object : arguments) {
					System.out.println(object);
				}
				return null;
			}
		}).when(car).fuelInjection(Mockito.any(Engine.class));
		car.fuelInjection(new Engine());
	}
	
	@Test
	@Ignore
	public void demoAnswer2() {
		doAnswer((invocation) -> {
			Object[] arguments = invocation.getArguments();
			for (Object object : arguments) {
				System.out.println(object);
			}
			return null;
		}).when(car).fuelInjection(Mockito.any(Engine.class));;
		car.fuelInjection(new Engine());
	}
	
	@Test
//	@Ignore
	public void demoCallRealMethod() {
		when(car.getName()).thenReturn("BMW");
		assertThat(car.getName(), equalTo("BMW"));
		
		// should fail here
//		when(car.getName()).thenCallRealMethod();
//		assertThat(car.getName(), equalTo("BMW"));
	}
	
	
	// Make car Spy before test
	
//	One thing you should notice about this syntax:
//
//		when(spy.method()).thenAnswer(someAnswer);
//		Is that the first thing Java will do when evaluating it is to run:
//
//		     spy.method()
//		...so that it can pass an accurate return value into the when method. 
//	Of course, when discards its parameter and just reads the last call to a mock, 
//	but Java can't know that from the syntax. For the very first call to when on a 
//	mock, the method should have no exceptions or side effects, 
//	but that assumption doesn't hold on spies or on methods that 
//	you've already stubbed.
//
//		In general, doAnswer and other doVerb methods have two key uses: 
//	stubbing void methods and overriding already-defined behavior 
//	(i.e. for spies and already-stubbed methods).
	
	@Test
	public void demoDifferenceDoReturn() {
//		doReturn(new Engine()).when(car).getName();
//		car.drive(); // different types
		
//		when(car.getName()).thenReturn((new Engine())); // compilation error
//		car.getEngine();
		
		when(car.getEngine()).thenReturn((new Engine()));
		car.getEngine();
		
		doReturn(new Engine()).when(car).getEngine();
		car.getEngine();
	}
	
	@Test
	public void demoDifferenceDoReturn2() {
		List<String> spyList = spy(new ArrayList<String>());
		//Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
		when(spyList.get(0)).thenReturn("foo");

		//You have to use doReturn() for stubbing
//		doReturn("foo").when(spyList).get(0);
	}

}

class Car {
	
	private Engine engine;
	private String name;
	
	public void drive() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void startEngine() {
		this.fuelInjection(this.engine);
		System.out.println("Engine = " + this.engine);
		
	}
	
	public Engine getEngine() {
		int a = 2 / 0;
		System.out.println("In get engine");
		return this.engine;
	}
	
	public String toString() {
		return "Car with engine: " + this.engine; 
	}
	
	public void fuelInjection(Engine engine) {
		System.out.println("Injecting fuel");
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public static int someStaticMethodInCar() {
		return 1;
	}
}

class Engine {
	private String name;
	public void start() {
		
	};
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

class Static {
	public static int getNumber() {
		return 1;
	}
}

interface Inter {
	String doSomething();
}

