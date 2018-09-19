package l18n;

import java.util.Locale;

public class Test {
	
	public static void main(String[] args) {
		Locale[] availableLocales = Locale.getAvailableLocales();
		for (Locale locale : availableLocales) {
			System.out.println(locale);
		}
	}

}
