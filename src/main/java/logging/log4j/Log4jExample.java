package logging.log4j;

import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class Log4jExample{

   /* Get actual class name to be printed on */
   public static final Logger LOGGER = Logger.getLogger(Log4jExample.class.getName());
   
   public static final String ERROR_PRODUCT_NAME_MESSAGE = "This product %s is invalid";
   
   public static void main(String[] args)throws IOException,SQLException{
      LOGGER.debug("Hello this is a debug message");
      LOGGER.info("Hello this is an info message");
//      log.info(String.format(ERROR_PRODUCT_NAME_MESSAGE, product.getName()));
      System.out.println("Finished");
   }
}