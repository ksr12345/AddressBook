import java.util.*;

public class AddressBook implements Comparable<AddressBook>{
    private final String firstName;
    private final String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    private static final List<AddressBook> contacts = new ArrayList<>();

    public AddressBook(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;

        contacts.add(this);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void display() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Zip: " + zip);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println();
    }

    @Override
    public int compareTo(AddressBook other) {
        int lastNameComp = this.lastName.compareTo(other.lastName);
        if (lastNameComp != 0) {
            return lastNameComp;
        }
        return this.firstName.compareTo(other.firstName);
    }

    public static List<AddressBook> getAllContacts() {
        return contacts;
    }


    public static void editContact(String firstName, String lastName, String newAddress, String newCity, String newState, String newZip, String newPhoneNumber, String newEmail) {
        for (AddressBook contact : contacts) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                contact.setAddress(newAddress);
                contact.setCity(newCity);
                contact.setState(newState);
                contact.setZip(newZip);
                contact.setPhoneNumber(newPhoneNumber);
                contact.setEmail(newEmail);
                System.out.println("Contact edited successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {

        AddressBook contact1 = new AddressBook("John", "Doe", "123 Main St", "Anytown", "NY", "12345", "555-1234", "john.doe@example.com");
        AddressBook contact2 = new AddressBook("Jane", "Smith", "456 Elm St", "Othertown", "CA", "67890", "555-5678", "jane.smith@example.com");

        System.out.println("Before editing:");
        System.out.println("Contact 1:");
        contact1.display();
        System.out.println("Contact 2:");
        contact2.display();

        AddressBook.editContact("John", "Doe", "456 New Address", "NewCity", "NewState", "98765", "555-9999", "new.email@example.com");

        System.out.println("After editing:");
        System.out.println("Contact 1:");
        contact1.display();
        System.out.println("Contact 2:");
        contact2.display();
    }
}
