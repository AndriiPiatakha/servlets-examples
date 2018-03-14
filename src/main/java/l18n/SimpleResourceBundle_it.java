package l18n;


public class SimpleResourceBundle_it extends SimpleResourceBundle {

  public Object handleGetObject(String key) {
    if (key.equals("AMMessage")) return "Buona mattina";
    if (key.equals("PMMessage")) return "Buona sera";

    return null;
  }
}