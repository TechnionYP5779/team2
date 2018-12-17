package il.org.parkingweb.database.sql;

import java.util.*;

import org.hibernate.*;

import il.org.parkingweb.database.*;
import il.org.parkingweb.location.*;
import il.org.parkingweb.parkingspot.*;

public class HibernateParkingSpots implements ParkingSpots {
  private final SessionFactory sf;
  private Session session;
  
  HibernateParkingSpots(SessionFactory sessionFactory) {
    sf = sessionFactory;
  }

  @Override public void add(ParkingSpot ps) {
    openSession();
    session.save(ps);
    closeSession();
  }

  @Override public void remove(Long id) {
    openSession();
    Optional<ParkingSpot> ops = Optional.of(session.get(ParkingSpot.class, id));
    ops.ifPresent(ps -> session.delete(ps));
    closeSession();
  }

  @Override public Optional<ParkingSpot> get(Long id) {
    openSession();
    Optional<ParkingSpot> ops = Optional.of(session.get(ParkingSpot.class, id));
    closeSession();
    return ops;
  }

  @Override public List<ParkingSpot> getParkingSpotIn(Location location, double range) {
    openSession();
    
    Double minLatitude = Double.valueOf(location.latitude - range);
    Double maxLatitude = Double.valueOf(location.latitude + range);
    Double minLongitude = Double.valueOf(location.longitude - range);
    Double maxLongitude = Double.valueOf(location.longitude + range);
    
    String hqlQuery = ""
        + "From " + SqlConsts.ParkingSpots.TableName + " "
        + "Where latitude >= :minLatitude "
        + "And latitude <= :maxLatitude "
        + "And longitude >= :minLongitude "
        + "And longitude <= :maxLongitude ";
    
    List<ParkingSpot> spots = session.createQuery(hqlQuery, ParkingSpot.class)
        .setParameter("minLatitude", minLatitude)
        .setParameter("maxLatitude", maxLatitude)
        .setParameter("minLongitude", minLongitude)
        .setParameter("maxLongitude", maxLongitude)
        .getResultList();
        
    closeSession();
    return spots;
  }
  
  private void openSession() {
    session = sf.openSession();
    session.beginTransaction();
  }

  private void closeSession() {
    session.getTransaction().commit();
    session.close();
  }
}
