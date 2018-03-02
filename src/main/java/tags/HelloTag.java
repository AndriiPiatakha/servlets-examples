package tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.Collection;

public class HelloTag extends SimpleTagSupport {
	private String message;
	private Collection coll;

	public void setMessage(String msg) {
		this.message = msg;
	}
	
	public void setColl(Collection coll) {
		this.coll = coll;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("Hello Custom Tag!" + " " + message + " coll size = " + coll.size());
	}
}
