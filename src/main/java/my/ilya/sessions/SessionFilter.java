package my.ilya.sessions;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SessionFilter implements Filter {

	private FilterConfig config;
	private Logger log;

	/** creates new SessionFilter */
	public SessionFilter() {
		log = Logger.getLogger(SessionFilter.class);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Instance created of " + getClass().getName());
		log.info("Instance created of " + getClass().getName());
		this.config = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		ServletContext context = config.getServletContext();
		context.log("doFilter called in: " + config.getFilterName() + " on " + (new Date()));
		//log the session ID
		context.log("session ID: " + session.getId());
		//Find out whether the logged-in session attribute is set
		String logged = (String) session.getAttribute("logged-in");
		if(logged == null){
			session.setAttribute("logged-in", "no");
		}
		//log a message about the log-in status
		context.log("log-in status: " + (String) session.getAttribute("logged-in"));
		context.log("");
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
