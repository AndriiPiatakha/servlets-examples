package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class DefaultHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Session is created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session is destroyed");
	}

}
