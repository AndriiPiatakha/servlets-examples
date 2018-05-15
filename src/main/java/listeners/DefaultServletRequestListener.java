package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DefaultServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("REQUEST LISTENER, request destroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("REQUEST LISTENER, request initialized");
	}

}
