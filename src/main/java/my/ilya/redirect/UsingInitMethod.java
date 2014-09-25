package my.ilya.redirect;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kazakevich Ilya
 */
public class UsingInitMethod extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	String msg = "";

    public void init(ServletConfig config) {
        msg = "Hello from Java servlets!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>");
        out.println("Using the init Method");
        out.println("</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<H1>Using the init Method</H1>");
        out.println(msg);
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
