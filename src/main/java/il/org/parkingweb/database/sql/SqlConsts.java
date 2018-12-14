package il.org.parkingweb.database.sql;

class SqlConsts {
  private static final String FullUrlFormat = "jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
  private static final String HostAndDbFormat = "jdbc:sqlserver://%s:1433;database=%s";
  
  
  static final String HostName = "parkingteam2sql.database.windows.net";
  static final String DbName = "parkingSQL";
  static final String UserName = "parking2";
  static final String Password = "P^po0f60v%$DOJ3P";
  
  static final String ConnectionString = String.format(FullUrlFormat, HostName, DbName, UserName, Password);
  static final String HostAndDbString = String.format(HostAndDbFormat, HostName, DbName);
  
  static class ParkingSpots {
    static final String TableName = "ParkingSpots"; // TODO:
  }

  static class Users {
    static final String TableName = "Users"; // TODO:
  }
}
