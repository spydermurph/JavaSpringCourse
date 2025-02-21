package is.webworks;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("In service");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h2><b>Hello world</b></h2>");
    }

}
