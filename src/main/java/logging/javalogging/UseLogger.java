package logging.javalogging;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseLogger {
    // use the classname for the logger, this way you can refactor
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public void doSomeThingAndLog() {
        // ... more code

        // now we demo the logging

        // set the LogLevel to Severe, only severe Messages will be written
        LOGGER.setLevel(Level.FINEST);
        
        
        
        LOGGER.severe("SEVER Log");
        LOGGER.warning("WARNING Log");
        LOGGER.info("Info Log");
        LOGGER.finest("FINEST Really not important");

        // set the LogLevel to Info, severe, warning and info will be written
        // finest is still not written
        LOGGER.setLevel(Level.FINEST);
        LOGGER.severe("SEVERE Log");
        LOGGER.warning("WARNING Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Finest Really not important");
    }

    public static void main(String[] args) {
        UseLogger tester = new UseLogger();
        try {
            MyLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        tester.doSomeThingAndLog();
        System.out.println("Demo finished");
        System.out.println(LOGGER.getLevel());
    }
}
