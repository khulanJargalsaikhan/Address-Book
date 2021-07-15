import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public AddressBook(String name, String address, String city, String state, String zip, String phone, String email) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        setPhone(phone);
        setEmail(email);
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

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {

        if (isPhoneNumberValid(phone) == true)
            this.phone = phone;
        else
            System.out.println("Invalid phone number!");
    }

    // validating phone number before set it
    private boolean isPhoneNumberValid(String phoneNumber){
        boolean isValid = false;

        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if(isEmailValid(email) == true)
            this.email = email;
        else
            System.out.println("Invalid email!");
    }

    // validating email address before set it
    private boolean isEmailValid(String email){
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        //Make the comparison case-insensitive.
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }


    public void displayContent(){
        System.out.printf("Name: %s\nAddress: %s\nCity: %s\nState: %s\n" +
                "Zip: %s\nPhone: %s\nEmail: %s\n", name,address,city,state,zip,phone,email);
    }


}
