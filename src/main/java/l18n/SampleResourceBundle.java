package l18n;

import java.awt.*;
import java.util.*;

public class SampleResourceBundle extends ListResourceBundle {

  public Object [][] getContents() {
    return contents;
  }

  static final Object [][] contents = {
      {"okButton", new Button("OK")},
      {"negativeInteger", new Integer(-1)},
      {"textString", "Thank you for reading our book"}
  };
}
