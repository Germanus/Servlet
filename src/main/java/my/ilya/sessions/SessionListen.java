package my.ilya.sessions;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListen implements HttpSessionListener {

	private int sessionCount;
	private Logger log;

	public SessionListen() {
		this.sessionCount = 0;
		 log = Logger.getLogger(SessionListen.class);
	}

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		session.setMaxInactiveInterval(10);
		synchronized (this) {
			sessionCount++;
		}
		String id = session.getId();
		Date now = new Date();
		String message = new StringBuffer("New Session created on ").append(now.toString()).append("\nID: ").append(id)
				.append("\n").append("There are now ").append("" + sessionCount)
				.append(" live sessions in the application.").toString();

		System.out.println(message);
		log.info(message);
	}

	public void sessionDestroyed(HttpSessionEvent se) {

		HttpSession session = se.getSession();
		
		String id = session.getId();
		synchronized (this) {
			--sessionCount;
		}
		String message = new StringBuffer("Session destroyed" + "\nValue of destroyed session ID is").append("" + id)
				.append("\n").append("There are now ").append("" + sessionCount)
				.append(" live sessions in the application.").toString();
		System.out.println(message);
		log.info(message);
	}
}