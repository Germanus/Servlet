package my.ilya.sessions;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

public class SessionAttributeListen implements HttpSessionAttributeListener {

	private Logger log;
	/** Creates new SessionAttribListen */
	public SessionAttributeListen() {
		log = Logger.getLogger(SessionAttributeListen.class);
		System.out.println(getClass().getName());
		log.info(getClass().getName());
	}

	public void attributeAdded(HttpSessionBindingEvent se) {

		HttpSession session = se.getSession();
		String id = session.getId();
		String name = se.getName();
		String value =se.getValue().toString();
		String source = se.getSource().getClass().getName();
		String message = new StringBuffer("Attribute bound to session in ").append(source)
				.append("\nThe attribute name: ").append(name).append("\n").append("The attribute value:")
				.append(value).append("\n").append("The session ID: ").append(id).toString();
		System.out.println(message);
		log.info(message);
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {

		HttpSession session = se.getSession();
		String id = session.getId();
		String name = se.getName();
		if (name == null)
			name = "Unknown";
		String value = se.getValue().toString();
		String source = se.getSource().getClass().getName();
		String message = new StringBuffer("Attribute unbound from session in ").append(source)
				.append("\nThe attribute name: ").append(name).append("\n").append("The attribute value: ")
				.append(value).append("\n").append("The session ID: ").append(id).toString();
		System.out.println(message);
		log.info(message);
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {

		String source = se.getSource().getClass().getName();
		String message = new StringBuffer("Attribute replaced in session  ").append(source).toString();
		System.out.println(message);
		log.info(message);
	}
}
