package logging.javalogging;

import java.util.logging.Logger;

public class JavaLogging {
	
	private final static Logger LOGGER = Logger.getLogger(JavaLogging.class.getName());
	
//	The following lists the Log Levels in descending order:
//
//		SEVERE (highest)
//
//		WARNING
//
//		INFO
//
//		CONFIG
//
//		FINE
//
//		FINER
//
//		FINEST
//		
//	LOGGER.setLevel(Level.INFO);
//	In addition to that you also have the levels OFF and ALL to turn the logging off or to log everything.
//	
//	
//	=========== HANDLERS
//	
//	ConsoleHandler: A ConsoleHandler records all the log messages to System.err. By default, a Logger is associated with this handler.
//
//	FileHandler: A FileHandler is used to record all the log messages to a specific file or to a rotating set of files.
//
//	StreamHandler: A StreamHandler publishes all the log messages to an OutputStream.
//
//	SocketHandler: The SocketHandler publish the LogRecords to a network stream connection.
//
//	MemoryHandler: It is used to keep the LogRecords into a memory buffer. If the buffer gets full, the new LogRecords starts overwriting the old LogRecords.
//	
//	=========== FORMATTERS
//			
//			Available formatter
//
//			SimpleFormatter: Generate all messages as text
//
//			XMLFormatter: Generates XML output for the log messages
//
//			You can also build your own formatter. The following is an example of a formatter which will create HTML output.
//
//	
//	
//	LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.FINE);
//	
//	
//	LogRecord
	
	public static void someMethod() {
		
	}
}
