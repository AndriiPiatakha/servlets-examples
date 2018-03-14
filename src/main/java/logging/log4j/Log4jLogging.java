package logging.log4j;

public class Log4jLogging {
	
//	log4j has three main components:
//
//		loggers: Responsible for capturing logging information.
//
//		appenders: Responsible for publishing logging information to various preferred destinations.
//
//		layouts: Responsible for formatting logging information in different styles.
//	
//	It is thread-safe.
//
//	It is optimized for speed.
//
//	It is based on a named logger hierarchy.
//
//	It supports multiple output appenders per logger.
//
//	It supports internationalization.
//
//	It is not restricted to a predefined set of facilities.
//
//	Logging behavior can be set at runtime using a configuration file.
//
//	It is designed to handle Java Exceptions from the start.
//
//	It uses multiple levels, namely ALL, TRACE, DEBUG, INFO, WARN, ERROR and FATAL.
//
//	The format of the log output can be easily changed by extending the Layout class.
//
//	The target of the log output as well as the writing strategy can be altered by implementations of the Appender interface.
//
//	It is fail-stop. However, although it certainly strives to ensure delivery, log4j does not guarantee that each log statement will be delivered to its destination.
//
//	
//	=========== Support Objects
//			
//			Level Object
//			Filter Object
//			ObjectRenderer The ObjectRenderer object is specialized in providing a String representation of different objects passed to the logging framework. This object is used by Layout objects to prepare the final logging information.
//			LogManager The LogManager object manages the logging framework. It is responsible for reading the initial configuration parameters from a system-wide configuration file or a configuration class.
//	
//	
//	
//	=========== LEVELS
//			
//			TRACE
//			DEBUG
//			INFO
//			WARN
//			ERROR
//			FATAL
//			ALL
//	
//	
//	============ APPENDERS properties
//			
//			layout	Appender uses the Layout objects and the conversion pattern associated with them to format the logging information.
//			target	The target may be a console, a file, or another item depending on the appender.
//			level	The level is required to control the filtration of the log messages.
//			threshold	Appender can have a threshold level associated with it independent of the logger level. The Appender ignores any logging messages that have a level lower than the threshold level.
//			filter	The Filter objects can analyze logging information beyond level matching and decide whether logging requests should be handled by a particular Appender or ignored.
//	
//	
//	=========== APPENDERS
//			
//			AppenderSkeleton
//			AsyncAppender
//			ConsoleAppender
//			DailyRollingFileAppender
//			ExternallyRolledFileAppender
//			FileAppender
//			JDBCAppender
//			JMSAppender
//			LF5Appender
//			NTEventLogAppender
//			NullAppender
//			RollingFileAppender
//			SMTPAppender
//			SocketAppender
//			SocketHubAppender
//			SyslogAppender
//			TelnetAppender
//			WriterAppender
//	
//	========== LAYOUTS
//			
//			DateLayout
//			HTMLLayout
//			PatternLayout
//			SimpleLayout
//			XMLLayout
//	
//	
//	=========== FILE APPENDER
//			
//			immediateFlush	This flag is by default set to true, which means the output stream to the file being flushed with each append operation.
//			encoding	It is possible to use any character-encoding. By default, it is the platform-specific encoding scheme.
//			threshold	The threshold level for this appender.
//			Filename	The name of the log file.
//			fileAppend	This is by default set to true, which means the logging information being appended to the end of the same file.
//			bufferedIO	This flag indicates whether we need buffered writing enabled. By default, it is set to false.
//			bufferSize	If buffered I/O is enabled, it indicates the buffer size. By default, it is set to 8kb.
	
	
	
	
	
}
