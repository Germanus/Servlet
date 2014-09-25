package my.ilya.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectNewLocation extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", "http://www.java2s.com");

    response.setContentType("text/html");
    return;
  }
}
