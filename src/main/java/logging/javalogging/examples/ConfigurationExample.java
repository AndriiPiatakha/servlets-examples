package logging.javalogging.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ConfigurationExample {
	
//	handlers: used to set the default handlers for all the loggers.
//	.level: sets the default Level for all the loggers to ALL.
//	java.util.logging.ConsoleHandler.level: sets the default Level for all the ConsoleHandler to ALL.
//	java.util.logging.ConsoleHandler.formatter: sets the default formatter for the ConsoleHandler to a SimpleFormatter.
//	confLogger.level: sets the default level of the Logger named confLogger to ALL.

	private static final LogManager LOG_MANAGER = LogManager.getLogManager();
	private static final Logger LOGGER = Logger.getLogger("confLogger");
	static{
		try {
//			LOG_MANAGER.readConfiguration(new FileInputStream("./logging.properties"));
			LOG_MANAGER.readConfiguration(ConfigurationExample.class.getClassLoader().getResourceAsStream("./logging.properties"));
		} catch (IOException exception) {
			LOGGER.log(Level.SEVERE, "Error in loading configuration", exception);
		}
	}
	public static void main(String[] args) {
		LOGGER.fine("Fine message logged");
	}
}

