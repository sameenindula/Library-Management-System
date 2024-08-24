package entity;

public class UserEntity {
    private String user_ID;
    private String user_Name;
    private String address;
    private String contactNO;
    private String joiDate;
    public UserEntity(String user_ID, String user_Name, String address, String contactNO, String joiDate) {
        this.user_ID = user_ID;
        this.user_Name = user_Name;
        this.address = address;
        this.contactNO = contactNO;
        this.joiDate = joiDate;
    }
    public String getUser_ID() {
        return user_ID;
    }
    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }
    public String getUser_Name() {
        return user_Name;
    }
    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getContactNO() {
        return contactNO;
    }
    public void setContactNO(String contactNO) {
        this.contactNO = contactNO;
    }
    public String getJoiDate() {
        return joiDate;
    }
    public void setJoiDate(String joiDate) {
        this.joiDate = joiDate;
    }
    @Override
    public String toString() {
        return "UserEntity [user_ID=" + user_ID + ", user_Name=" + user_Name + ", address=" + address + ", contactNO="
                + contactNO + ", joiDate=" + joiDate + "]";
    }




}
