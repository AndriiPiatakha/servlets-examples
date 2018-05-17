package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DefaultServletContextListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		System.out.println("Context initizlized");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context destroyed");
	}

}
