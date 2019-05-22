package FunctionLayer;

public class User {
    public User(String name, String email, String password, String address, String zipcode, String city, String phone, String type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.phone = phone;
        this.type = type;
    }

    public User(int id, String name, String email, String password, String address, String zipcode, String city, String phone, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.phone = phone;
        this.type = type;
    }

    public User(String email, String password, String type) {
        this.email = email;
        this.password = password;
        this.type = type;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String name;
    private String email;
    private String password; // Should be hashed and secured
    private String address;
    private String zipcode;
    private String city;
    private String phone;
    private String type;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public int getIdInt() {return id;}

    public void setId( int id ) {
        this.id = id;
    }
}