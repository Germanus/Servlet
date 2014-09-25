package my.ilya.redirect;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectWithLinkServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    response.setContentType("text/html");
    out.println("<html><body>");
    out.println("<H1>Java Source and Support</H1><BR>");
    out.println("<a href=\"http://www.java2s.com\">Click here</a>");
    out.println("</body></html>");

    return;
  }
}