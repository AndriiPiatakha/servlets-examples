import java.util.Scanner;

public class CreditCalculator {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		double amount = sc.nextDouble();
		int amount = sc.nextInt();
		
		for (int i = 0; i < 6; i++) {
			amount = (int) (amount - (amount * 0.1)); 
		}
		System.out.println(amount);
	}

}
