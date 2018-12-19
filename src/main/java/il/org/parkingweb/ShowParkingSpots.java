package il.org.parkingweb;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import il.org.parkingweb.database.*;
import il.org.parkingweb.location.*;
import il.org.parkingweb.parkingspot.*;

@WebServlet("/ShowParkingSpot") 
public class ShowParkingSpots extends HttpServlet{
//automatically created
 private static final long serialVersionUID = 1;
 
 private static final String HTML_Prefix =
     "<head><title>OpenLayers Marker Popups</title></head>\r\n" + 
     "  <body>\r\n" + 
     "  \r\n" + 
     "  <div id=\"linksdiv\">\r\n" + 
     "     Click to jump to a new location:\r\n" + 
     "        <li><a href=\"#\" onClick=\"javascript:jump( 32.77890,35.02005); return false;\">Technion, Israel</a></li>\r\n" + 
     "        \r\n" + 
     "     \r\n" + 
     "  </div>\r\n" + 
     "  \r\n" + 
     "  <div id=\"mapdiv\"></div>\r\n" + 
     "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/openlayers/2.11/lib/OpenLayers.js\"></script> \r\n" + 
     "  <script>\r\n" + 
     "     var markers =";
 
 private static final String HTML_Suffix = 
     "</script>\r\n" + 
     "  <script src=\"js/mapSimple.js\"></script>\r\n" + 
     "  \r\n" + 
     "</body></html>";
 
 @Override public void init() throws ServletException {
   /**
    * 
    */
 }

 @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
   
  ParkingSpotsFactory factory = CreateFakeFactory.create();
  
  ParkingSpots parkingSpots = factory.open();
  
  String html_list = "[";
  
  List<ParkingSpot> list = parkingSpots.getParkingSpotIn(new Location(32.778885, 35.018709), 100);
  String comma = ",";
  for(int i =0; i < list.size(); i++) {
    if(i == list.size()-1) {
      comma = "";
    }
    html_list += "["+list.get(i).getLocation().latitude+", "+list.get(i).getLocation().longitude +"]"+comma;
  }
  html_list += "]";
  
   response.getWriter().println(HTML_Prefix+ html_list+HTML_Suffix);
 }
}
