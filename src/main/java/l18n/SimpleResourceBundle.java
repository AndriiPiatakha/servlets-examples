package l18n;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class SimpleResourceBundle extends ResourceBundle {

	private String keys = "AMMessage PMMessage";

	public Object handleGetObject(String key) {
		if (key.equals("AMMessage"))
			return "Good morning";
		if (key.equals("PMMessage"))
			return "Good evening";

		return null;
	}

	public Enumeration getKeys() {
		StringTokenizer keyTokenizer = new StringTokenizer(keys);

		return keyTokenizer;
	}
}
