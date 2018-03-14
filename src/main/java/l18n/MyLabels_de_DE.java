package l18n;

import java.util.ListResourceBundle;

public class MyLabels_de_DE extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return labels;
    }

    private Object[][] labels = {
            { "value1"   , new Integer(100) },
            { "label1", "MILES" },
    };
}
