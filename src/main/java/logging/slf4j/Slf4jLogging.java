package logging.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLogging {
    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4jLogging.class);
    public static void main(String[] args) {
        LOGGER.info("Testing 123");
    }
}