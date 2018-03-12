package l18n;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class L18nDemo {

	public static void main(String[] args) {

		// ru_RU
		System.out.println("Current Locale: " + Locale.getDefault());
		ResourceBundle mybundle = ResourceBundle.getBundle("MyLabels");
//		ResourceBundle mybundle = ResourceBundle.getBundle("MyLabels", Locale.ENGLISH);

		// read MyLabels_ru_RU.properties
		System.out.println("Say how are you in Russian: " + mybundle.getString("how_are_you"));

		Locale.setDefault(new Locale("en", "US"));

		// read MyLabels_en_US.properties
		System.out.println("Current Locale: " + Locale.getDefault());
		mybundle = ResourceBundle.getBundle("MyLabels");
		System.out.println("Say how are you in English language: " + mybundle.getString("how_are_you"));

		
		// class bundle
		mybundle = ResourceBundle.getBundle("l18n.MyLabels", Locale.GERMANY);
		Object object = mybundle.getObject("value1");
		Set<String> keySet = mybundle.keySet();
		System.out.println(object);
		System.out.println(keySet);
	}

}
