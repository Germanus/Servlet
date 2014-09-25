package my.ilya.redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlRewrite extends HttpServlet {

	private static final long serialVersionUID = -3830010030630479443L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			java.io.IOException {

		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		String contextPath = request.getContextPath();
		String encodedUrl = response.encodeURL(contextPath + "/index.jsp");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>URL Rewriter</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>This page will use URL rewriting if necessary</h2>");
		out.println("Go to the index.jsp page <a href=\"" + encodedUrl + "\">here</a>.");
		out.println("</body>");
		out.println("</html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			java.io.IOException {
		doGet(request, response);

	}
}
