package parkingLot;

public class GeoLocation implements Location{

  private String latitude;
  private String longitude;
  private String address;
  
  public GeoLocation(String latitude ,String longitude){
    this.latitude = latitude;
    this.longitude = longitude;
  }
  
  public GeoLocation(String address) {
    this.address = address;
  }
  
  @Override public Integer calcDist(Location other) {
    return !(other instanceof GeoLocation) ? null : new Integer(0);
  }
}
