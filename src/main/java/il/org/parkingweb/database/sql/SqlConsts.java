package il.org.parkingweb.database.sql;

class SqlConsts {
  static final String HostName = "parkingteam2sql.database.windows.net";
  static final String DbName = "parkingSQL";
  static final String UserName = "parking2";
  static final String Password = "P^po0f60v%$DOJ3P";
  static final String BaseFormat = "jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
  
  static final String ConnectionString = String.format(BaseFormat, HostName, DbName, UserName, Password);

  static class ParkingSpots {
    static final String TableName = ""; // TODO:
  }

  static class Users {
    static final String TableName = ""; // TODO:
  }
}
