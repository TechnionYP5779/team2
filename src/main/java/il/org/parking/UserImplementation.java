package il.org.parking;

public class UserImplementation implements User {
  private Integer id;
  private String name;
  private String contact_info;
  private DataBase db;

  public UserImplementation(Integer id, String name, String contact_info, DataBase db) {
    this.id = id;
    this.name = name;
    this.contact_info = contact_info;
    this.db = db;
  }

  @Override public Integer getId() {
    return id;
  }

  @Override public String getName() {
    return name;
  }

  @Override public String getContactInfo() {
    return contact_info;
  }

  @Override public void update(User updatedUser) {
    db.update(this.id, updatedUser);
    this.id = updatedUser.getId();
    this.name = updatedUser.getName();
    this.contact_info = updatedUser.getContactInfo();
  }

  @Override public String toString() {
    return "UserImplementation [id=" + id + ", name=" + name + ", contact_info=" + contact_info + ", db=" + db + "]";
  }
  
  

}
