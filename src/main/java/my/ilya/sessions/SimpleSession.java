package my.ilya.sessions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SimpleSession extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, java.io.IOException {
		   response.setContentType("text/html");
		    java.io.PrintWriter out = response.getWriter();
		    HttpSession session = request.getSession();
		    
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Simple Session Tracker</title>");
		    out.println("</head>");
		    out.println("<body>");

		    out.println("<h2>Session Info</h2>");
		    out.println("session Id: " + session.getId() + "<br><br>");
		    out.println("The SESSION TIMEOUT period is "
		        + session.getMaxInactiveInterval() + " seconds.<br><br>");
		    out.println("Now changing it to 15 seconds.<br><br>");
		    session.setMaxInactiveInterval(15);
		    out.println("The SESSION TIMEOUT period is now "
		        + session.getMaxInactiveInterval() + " seconds.");

		    out.println("</body>");
		    out.println("</html>");
		    
	 }
	 
	 /**
	   * Handles the HTTP <code>POST</code> method.
	   * 
	   * @param request
	   *            servlet request
	   * @param response
	   *            servlet response
	   */
	  protected void doPost(HttpServletRequest request,
	      HttpServletResponse response) throws ServletException,
	      java.io.IOException {

	    doGet(request, response);
	  }
}
