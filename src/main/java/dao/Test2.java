package dao;

public class Test2 {


	
	private static Boolean b1, b2; 

	public static void main(String[] args) {
		if (b1 || !b2 || !b1 || b2) { 
            System.out.println(true); 
        } 
        else { 
            System.out.println(false); 
        } 
		char c = 'a';
		char c1 = '1';
		System.out.println(c * c1);
		
		long b = 1;
		long l = 2;
		byte b3 = (byte) (b/l);
	}

}
