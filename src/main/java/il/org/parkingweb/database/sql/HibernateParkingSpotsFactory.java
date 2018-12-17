package il.org.parkingweb.database.sql;

import org.hibernate.*;
import org.hibernate.cfg.*;

import il.org.parkingweb.database.*;
import il.org.parkingweb.parkingspot.*;

public class HibernateParkingSpotsFactory implements ParkingSpotsFactory {
  @SuppressWarnings("resource") @Override public ParkingSpots open() {
    Configuration cfg = createHibernateConfiguration();
    cfg.addAnnotatedClass(ParkingSpot.class);
    try{
      SessionFactory sessionFactory = cfg.buildSessionFactory();
      return new HibernateParkingSpots(sessionFactory);
    }
    catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  // Create Hibernate configuration via code instead of using a
  // 'hibernate.cfg.xml' file.
  private static Configuration createHibernateConfiguration() {
    return new Configuration()
        .setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver")
        .setProperty("hibernate.connection.url", SqlConsts.HostAndDbString) // set the base URL
        .setProperty("hibernate.connection.username", SqlConsts.UserName) // set the user name
        .setProperty("hibernate.connection.password", SqlConsts.Password) // set the password
        .setProperty("hibernate.connection.autocommit", "true")
        .setProperty("hibernate.show_sql", "false")
        .setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect")
        .setProperty("hibernate.show_sql", "false")
        .setProperty("hibernate.hbm2ddl.auto", "update");
  }
}
