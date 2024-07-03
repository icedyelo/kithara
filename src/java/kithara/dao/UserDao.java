
package kithara.dao;

import kithara.model.UserModel;

/**
 *
 * @author aisi
 */
public class UserDao {

    public UserModel getUserDetails(UserModel user) {
        UserModel userDetails;
        String pID = user.getuserId();
        String firstName = user.getFirstName();
        String middleName = user.getMiddleName();
        String lastName = user.getLastName();
        String userRole = user.getUserRole();
        String notice = user.getNotice();

        userDetails = new UserModel(pID, firstName, middleName, lastName, userRole, notice);
        System.out.println("userDetails: " + userDetails);
        return userDetails;
    }

    public String getuserId() {
        String userId = null;
        return userId;
    }

}
