package il.org.parkingweb;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import il.org.parkingweb.database.*;
import il.org.parkingweb.location.*;
import il.org.parkingweb.parkingspot.*;

@WebServlet("/AddParkingSpot") 
public class AddParkingSpot extends HttpServlet {
  
  // automatically created
  private static final long serialVersionUID = 1;
  
  private ParkingSpotsFactory factory = CreateFakeFactory.create();

  @Override public void init() throws ServletException {
    /**
     * 
     */
  }

  @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ParkingSpots psDb = factory.open();
    String longitude = request.getParameter("Longitude");
    String latitude = request.getParameter("Latitude");
    String fromHour = request.getParameter("fromHour").replace(":", ""); 
    String toHour = request.getParameter("fromHour").replace(":", ""); 
    
    Location l = new Location(Double.parseDouble(latitude), Double.parseDouble(longitude));
    ParkingSpot ps = new ParkingSpot();
    ps.setLocation(l);
    
    psDb.add(ps);
    
    
    
    /* String latitude = request.getParameter("Latitude"); String pricePH =
     * request.getParameter("PricePH"); String fromDate =
     * request.getParameter("fromDate"); String toDate =
     * request.getParameter("toDate"); String fromHour =
     * request.getParameter("fromHour"); String toHour =
     * request.getParameter("toHour"); */
    response.getWriter().println("<html><body><h1>Added!</h1></body></html>");
  }
}
