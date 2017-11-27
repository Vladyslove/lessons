package my.servlet;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class StudentsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        String action = request.getParameter("action");
        String id= request.getParameter("id");

        try(PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("  <head>");
            out.println("   <title>Hello Worm</title>");
            out.println("  </head>");
            out.println("  <body>");
            out.println("   <h1>Hello, Worm!</h1>");
            out.println("   <h2>Hello, Worm!</h2>");
            out.println("   <h3>Hello, Worm!</h3>");

            request.getParameterMap().forEach((k, v) ->
                    out.println("<p>" + k + " : " + Arrays.toString((String[]) v) + "/<"));

            out.println("  </body>");
            out.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}