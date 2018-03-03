package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class DefaultHttpSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Attribute added to SESSION");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Attribute removed from SESSION");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Attribute replaced in SESSION");
	}
	

}
