package il.org.parkingweb;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("AddParkingSpot") 
public class AddParkingSpot extends HttpServlet {
  
  // automatically created
  private static final long serialVersionUID = 1;

  @Override public void init() throws ServletException {
    /**
     * 
     */
  }

  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String longitude = request.getParameter("Longitude");
    String latitude = request.getParameter("Latitude");
    String pricePH = request.getParameter("Priceph");
    String fromDate = request.getParameter("fromDate");
    String toDate = request.getParameter("toDate");
    String fromHour = request.getParameter("fromHour");
    String toHour = request.getParameter("toHour");
    System.out.println(longitude);
    response.getWriter().println("<html><body><h1>Longitude=" + longitude + "</h1></body></html>");
  }
}
