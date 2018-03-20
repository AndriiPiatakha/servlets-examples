package logging.javalogging.examples;

import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class FilterExample implements Filter {

	private static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());

	public static void main(String[] args) {
		// Setting filter FilterExample
		LOGGER.setFilter(new FilterExample());
		// Since this message string does not contain the word important.
		// Despite of being the Level SEVERE this will be ignored
		LOGGER.severe("This is SEVERE message");
		// This will get published
		LOGGER.warning("This is important warning message");

	}

	// This method will return true only if the LogRecord object contains the
	// message which contains the word important
	@Override
	public boolean isLoggable(LogRecord record) {
		if (record == null)
			return false;

		String message = record.getMessage() == null ? "" : record.getMessage();

		if (message.contains("important"))
			return true;

		return false;
	}

}
