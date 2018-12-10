package il.org.parking;

import java.io.*;
import java.net.*;

import com.jayway.jsonpath.*;

import fluent.ly.*;

public class GeoLocation implements Location{

  private Double latitude;
  private Double longitude;
  private String address;
  
  public GeoLocation(Double latitude ,Double longitude){
    this.latitude = latitude;
    this.longitude = longitude;
  }
  
  public GeoLocation(String address) throws Exception {
    this.address = address;
    String formattedAddress = URLEncoder.encode(address,"UTF-8"); 
    String URL = "https://nominatim.openstreetmap.org/search?q="+formattedAddress+"&format=json&addressdetails=1";
    String json = GeoLocation.getRequest(URL);
    this.latitude = Double.valueOf(JsonPath.read(json,"$[0].lat"));
    this.longitude = Double.valueOf(JsonPath.read(json,"$[0].lon"));
  }
  
  @Override public Double calcDist(Location other) {
    if( !(other instanceof GeoLocation) )
      return null ;
    double startLat = this.latitude.doubleValue();
    double startLong = this.latitude.doubleValue();
    double endLat = ((GeoLocation)other).latitude.doubleValue();
    double endLong = ((GeoLocation)other).latitude.doubleValue();
    double dLat = Math.toRadians(endLat - startLat);
    double dLong = Math.toRadians(endLong - startLong);
    startLat = Math.toRadians(startLat);
    endLat = Math.toRadians(endLat);
    double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(startLat) * Math.cos(endLat) * Math.pow(Math.sin(dLong / 2), 2);
    double $ = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return box.it(6371 * $);
  }
  
  public static String getRequest(String url) throws Exception {

    final URL obj = new URL(url);
    final HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    con.setRequestMethod("GET");

    if (con.getResponseCode() != 200)
      return null;

    try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))){
      String inputLine;
      StringBuffer $ = new StringBuffer();
  
      while ((inputLine = in.readLine()) != null)
        $.append(inputLine);
      
      return $ + "";
    }
  }
  
  @Override public String toString() {
    return this.latitude+"\t"+this.longitude;
  }

}
