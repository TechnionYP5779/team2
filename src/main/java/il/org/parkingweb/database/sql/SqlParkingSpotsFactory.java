package il.org.parkingweb.database.sql;

import il.org.parkingweb.database.*;

public class SqlParkingSpotsFactory implements ParkingSpotsFactory {
  @Override public ParkingSpots open() {
    // TODO: connect to our database and if the relevant table doesn't exist, create
    // it.
    return new SqlParkingSpots(SqlConsts.ConnectionString, SqlConsts.ParkingSpots.TableName);
  }
}
