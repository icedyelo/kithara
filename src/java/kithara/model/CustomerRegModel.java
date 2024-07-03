package kithara.model;

public class CustomerRegModel {

    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String BirthDate;
    private String Mobile;
    private String Address;
    private String UserId;
    private String Password;
    private String UserRole;
    private String AccountStatus;
    private String LoginStatus;
    

    public CustomerRegModel () {
        //Set as empty
    }
    
    public CustomerRegModel(
            String FirstName,
            String MiddleName,
            String LastName,
            String BirthDate,
            String Mobile,
            String Address,
            String UserId,
            String Password,
            
            String UserRole,
            String AccountStatus,
            String LoginStatus) {
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.BirthDate = BirthDate;
        this.Mobile = Mobile;
        this.Address = Address;
        this.UserId = UserId;
        this.Password = Password;
        
        this.UserRole = UserRole;
        this.AccountStatus = AccountStatus;
        this.LoginStatus = LoginStatus;
    }
    
    
    
    public String getLoginStatus() {
        return LoginStatus;
    }

    public void setLoginStatus(String LoginStatus) {
        this.LoginStatus = LoginStatus;
    }
    
    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String AccountStatus) {
        this.AccountStatus = AccountStatus;
    }
    
    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String UserRole) {
        this.UserRole = UserRole;
    }
    
    

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
