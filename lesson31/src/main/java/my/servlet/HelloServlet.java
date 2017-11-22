package my.servlet;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        try(PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("  <head>");
            out.println("   <title>Hello Worm</title>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("   <h2>Hello, Worm!</h2>");
            out.println("  </body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}