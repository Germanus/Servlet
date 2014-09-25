package my.ilya.sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsingSessions extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		Integer counter = (Integer) session.getAttribute("counter");
		
		if (counter == null) {
			counter = new Integer(1);
		} else {
			counter = new Integer(counter.intValue() + 1);
		}

		session.setAttribute("counter", counter);
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>");
		out.println("Using Sessions");
		out.println("</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<H1>Using Sessions</H1>");
		
		out.println("Welcome! You have been here " + counter + " times.<BR>");
		
		if(session.isNew()){
			out.println("This is a new session<BR>");
		} else {
			out.println("This is not a new session <BR>");
		}

		
		out.println("The session ID: " + session.getId() + "<BR>");
		out.println("Last time accessed: " + new Date(session.getLastAccessedTime()) + "<BR>");
		out.println("Creation time: " + new Date(session.getCreationTime()) + "<BR>");
		out.println("Timeout length: " + session.getMaxInactiveInterval() + "<BR>");		
		
		out.println("</BODY>");
        out.println("</HTML>");
        
	}

}
