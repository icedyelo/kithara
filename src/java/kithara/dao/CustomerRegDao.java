package kithara.dao;
import kithara.model.CustomerRegModel;
public class CustomerRegDao {

    public CustomerRegModel getCustomerRegDetails(CustomerRegModel customer) {
        CustomerRegModel CustomerRegDetails;

        String firstName = customer.getFirstName();
        String middleName = customer.getMiddleName();
        String lastName = customer.getLastName();
        String birthDate = customer.getBirthDate();
        String Mobile = customer.getMobile();
        String Address = customer.getAddress();
        String userName = customer.getUserName();
        String Password = customer.getPassword();
        String regNotice = customer.getRegNotice();
        String regError = customer.getRegError();

        CustomerRegDetails = new CustomerRegModel(firstName, middleName, lastName, birthDate, Mobile, Address, userName, Password, regNotice, regError);
        System.out.println("CustomerReg Details: " + CustomerRegDetails);
        return CustomerRegDetails;
    }

    public String getfirstName() {
        String firstName = null;
        return firstName;
    }

    public String getmiddleName() {
        String middleName = null;
        return middleName;
    }

    public String getlastName() {
        String lastName = null;
        return lastName;
    }

   public String getbirthDate() {
        String birthDate = null;
        return birthDate;
    }

    public String getMobile() {
        String Mobile = null;
        return Mobile;
    }

    public String getAddress() {
        String Address = null;
        return Address;
    }

    public String getuserName() {
        String userName = null;
        return userName;
    }

    public String getPassword() {
        String Password = null;
        return Password;
    }
}