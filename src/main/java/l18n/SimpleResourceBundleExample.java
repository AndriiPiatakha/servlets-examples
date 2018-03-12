package l18n;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class SimpleResourceBundleExample {

  public static void main(String [] argv) {
    try {
      ResourceBundle rb = ResourceBundle.getBundle("l18n.SimpleResourceBundle");

      System.out.println(rb.getString("AMMessage"));
      System.out.println(rb.getString("PMMessage"));

    } catch (MissingResourceException mre) {
      mre.printStackTrace();
    }
  }
}


