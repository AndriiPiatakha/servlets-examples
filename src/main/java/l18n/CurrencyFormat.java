package l18n;

import java.text.NumberFormat;

public class CurrencyFormat {

	public static void main(String[] args) {
		NumberFormat format = 
				java.text.NumberFormat.getCurrencyInstance(java.util.Locale.GERMANY);
		System.out.println(format.format(23));
	}

}
