package il.org.parkingweb.database.sql;

import java.sql.*;
import java.util.*;

import il.org.parkingweb.database.*;
import il.org.parkingweb.location.*;
import il.org.parkingweb.parkingspot.*;

public class SqlParkingSpots implements ParkingSpots {
  private final String connectionString;
  private final String tableName;
  private Connection connection;

  SqlParkingSpots(String connectionString, String tableName) {
    this.connectionString = connectionString;
    this.tableName = tableName;
  }

  @Override public void add(int id, ParkingSpot ps) {
    openConnection();

    String sqlInsertBaseFormat = ""
        + "INSERT INTO [" + tableName + "] \n"
        + "VALUES (?, ?)";

    // TODO: create and execute statement.
    
    closeConnection();
  }

  @Override public void remove(int id) {
    openConnection();
    // TODO: add SQL statement and query.
    closeConnection();
  }

  @Override public void update(int id, ParkingSpot ps) {
    openConnection();
    // TODO: add SQL statement and query.
    closeConnection();
  }

  @Override public ParkingSpot get(int id) {
    openConnection();
    // TODO: add SQL statement and query.
    closeConnection();
    return null;
  }

  @Override public List<ParkingSpot> getParkingSpotIn(Location location, double range) {
    openConnection();
    // TODO: add SQL statement and query.
    closeConnection();
    return null;
  }

  private void openConnection() {
    try {
      connection = DriverManager.getConnection(connectionString);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  private void closeConnection() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
