package test;

public class Test2 {

	protected int i;
	String s;
	
	public Test2(int i) {
		System.out.println("parent is called");
		this.i = i;
	}
	
	public static void main(String[] args) {
		var ������������ = new Test3();
		System.out.println(������������.i);
		������������.���������������������������();
	}
	
}

class Test3 extends Test2 {
	
	public Test3() {
		super(1);
	}
	
	public void ���������������������������() {
		
	}
}
