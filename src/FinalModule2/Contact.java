package FinalModule2;

public class Contact {
    private String phone;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String birthdate;
    private String email;

    public Contact(String phone, String group, String name, String gender, String address, String birthdate, String email) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthdate = birthdate;
        this.email = email;
    }

    public String getPhone() { return phone; }
    public String getGroup() { return group; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public String getBirthdate() { return birthdate; }
    public String getEmail() { return email; }

    public void setGroup(String group) { this.group = group; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAddress(String address) { this.address = address; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %s", phone, group, name, gender, address);
    }
}
