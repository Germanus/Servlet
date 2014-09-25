package my.ilya.sessions;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionLogger implements HttpSessionListener{
	
	private Logger log;
	
	public SessionLogger(){
		 /*
	     * The loggers are typically initialized by a special initialization
	     * listener or servlet. If this is not the case, then initialize the
	     * logger here:
	     * 
	     * java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle(
	     * "com.java2s.global");
	     * PropertyConfigurator.configure(bundle.getString(
	     * "log-configure-path"));
	     */

	    log = Logger.getLogger(SessionLogger.class);
	}

	public void sessionCreated(HttpSessionEvent event) {
		//log request of the INFO level
		log.info("HttpSession created: " + event.getSession().getId());
		log.fatal("HttpSession created: " + event.getSession().getId());
		log.debug("HttpSession created: " + event.getSession().getId());
		log.error("HttpSession created: " + event.getSession().getId());
		log.trace("HttpSession created: " + event.getSession().getId());
		log.warn("HttpSession created: " + event.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		//log request about session's that are invalidated
		log.info("HttpSession invalidated: " + event.getSession().getId());
		log.fatal("HttpSession invalidated: " + event.getSession().getId());
		log.debug("HttpSession invalidated: " + event.getSession().getId());
		log.error("HttpSession invalidated: " + event.getSession().getId());
		log.trace("HttpSession invalidated: " + event.getSession().getId());
		log.warn("HttpSession invalidated: " + event.getSession().getId());
	}

}
