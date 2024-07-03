package kithara.model;

public class UserModel {

    private String userId;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String UserRole;
    private String Notice;

    public UserModel(
            String userId,
            String FirstName,
            String MiddleName,
            String LastName,
            String UserRole,
            String Notice
    ) {
        this.userId = userId;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.UserRole = UserRole;
        this.Notice = Notice;

    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String FirstName) {
        this.Notice = FirstName;
    }

    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
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

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String UserRole) {
        this.UserRole = UserRole;
    }

}
