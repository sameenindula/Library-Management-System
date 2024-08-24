package dto;


public class UserDTO {
    private String user_ID;
    private String user_Name;
    private String address;
    private String contactNO;
    private String joiDate;
    public UserDTO(String user_ID, String user_Name, String address, String contactNO, String joiDate) {
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
    public static boolean next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }
    public static String getString(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getString'");
    }


}
