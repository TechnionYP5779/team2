package il.org.parking;

import java.io.*;
import java.net.*;

import com.jayway.jsonpath.*;

import fluent.ly.*;

public class GeoLocation implements Location {
  private double latitude;
  private double longitude;
  private String address;
  private final String UTF8 = "UTF-8";

  public GeoLocation(double latitude, double longitude) throws Exception {
    if (latitude > 90 || latitude < -90 || longitude > 180 || longitude < -180)
      throw new IllegalArgumentException();
    this.latitude = latitude;
    this.longitude = longitude;
    String URL = "https://nominatim.openstreetmap.org/reverse?lat=" + URLEncoder.encode(latitude + "", UTF8) + "&lon="
        + URLEncoder.encode(longitude + "", UTF8) + "&format=json&addressdetails=1";
    String json = GeoLocation.getRequest(URL);
    this.address = JsonPath.read(json, "$.display_name");
  }

  public GeoLocation(String address) throws Exception {
    this.address = address;
    String formattedAddress = URLEncoder.encode(address, UTF8);
    String URL = "https://nominatim.openstreetmap.org/search?q=" + formattedAddress + "&format=json&addressdetails=1";
    String json = GeoLocation.getRequest(URL);
    this.latitude = Double.parseDouble(JsonPath.read(json, "$[0].lat"));
    this.longitude = Double.parseDouble(JsonPath.read(json, "$[0].lon"));
    this.address = JsonPath.read(json, "$[0].display_name");
  }

  public double getLatitude() {
    return this.latitude;
  }

  public double getLongitude() {
    return this.longitude;
  }

  public String getAddress() {
    return this.address;
  }

  // Calculate the air distance between two geographic coordinates with the
  // Haversine formula
  @Override public Double calcDist(Location other) {
    if (!(other instanceof GeoLocation))
      return null;
    final int $ = 6371; // Radius of the earth
    double lat1 = this.latitude;
    double lon1 = this.longitude;
    double lat2 = ((GeoLocation) other).latitude;
    double lon2 = ((GeoLocation) other).longitude;
    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
        + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return box.it($ * c);
  }

  private static String getRequest(String url) throws IOException {
    final URL obj = new URL(url);
    final HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestProperty("Referer", "https://www.goggle.com");
    con.setRequestMethod("GET");
    if (con.getResponseCode() != 200)
      return null;
    try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
      String inputLine;
      StringBuilder $ = new StringBuilder();
      while ((inputLine = in.readLine()) != null)
        $.append(inputLine);
      return $ + "";
    }
  }

  @Override public String toString() {
    return this.latitude + "\t" + this.longitude;
  }
}
