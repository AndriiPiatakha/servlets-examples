package listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DefaultServletContextAttributeListener implements ServletContextAttributeListener  {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("Attribute added to CONTEXT");
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("Attribute removed from CONTEXT");
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("Attribute replaced in CONTEXT");
	}
}
