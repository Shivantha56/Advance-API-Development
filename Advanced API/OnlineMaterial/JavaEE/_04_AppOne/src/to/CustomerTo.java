package to;

public class CustomerTo {

    String customerID;
    String fName;
    String lName;
    String email;
    String phone;

    String birthday;
    String regDate;

    public CustomerTo(String customerID, String fName, String lName, String email, String phone, String birthday, String regDate) {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.regDate = regDate;
    }

}
