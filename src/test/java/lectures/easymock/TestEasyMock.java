//package lectures.easymock;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.times;
//import static org.easymock.EasyMock.*;
//
//import org.easymock.EasyMock;
//import org.junit.Test;
//
//public class TestEasyMock {
//	
//	@Test
//	public void test1() {
//		Engine engineMock = mock(Engine.class);
//		expect(engineMock.getName()).andReturn("Test engine");
//		expect(engineMock.getName()).andReturn("Test engine2");
//		replay(engineMock);
////		EasyMock.expect(engineMock.getName()).andReturn("Test engine2");
//		String engineName = engineMock.getName();
//		assertThat(engineName, equalTo("Test engine"));
//	}
//
//	@Test
//	public void test2() {
//		Car carMock = createNiceMock(Car.class);
//		carMock.drive();
//		expectLastCall().times(3);
//		replay(carMock);
//		
//		carMock.drive();
//		carMock.drive();
////		carMock.drive();
//		verify(carMock);
//	}
//	
//	@Test
//	public void test3() {
//		Car carMock = createNiceMock(Car.class);
//		carMock.drive();
//		expectLastCall().times(3);
//		replay(carMock);
//		
//		carMock.drive();
//		carMock.drive();
//		carMock.drive();
//		verifyRecording(carMock);
//	}
//}
//
//class Car {
//	
//	private Engine engine;
//	
//	public void drive() {
//		
//	}
//	
//	public void startEngine() {
//		this.fuelInjection(this.engine);
//		System.out.println("Engine = " + this.engine);
//		
//	}
//	
//	public Engine getEngine() {
//		return this.engine;
//	}
//	
//	public String toString() {
//		return "Car with engine: " + this.engine; 
//	}
//	
//	public void fuelInjection(Engine engine) {
//		System.out.println("Injecting fuel");
//	}
//	
//	public void setEngine(Engine engine) {
//		this.engine = engine;
//	}
//}
//
//class Engine {
//	private String name;
//	public void start() {
//		
//	};
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String getName() {
//		return this.name;
//	}
//}