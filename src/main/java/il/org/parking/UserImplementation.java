package il.org.parking;

//Temp, will be replaced in merge
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

  public UserImplementation(Integer box, String name2, String contact_info2) {
    // Temp for the test
    this.id = box;
    this.name = name2;
    this.contact_info = contact_info2;
    this.db = null;
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