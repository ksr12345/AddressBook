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

    public static void deleteContact(String firstName, String lastName) {
        Iterator<AddressBook> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            AddressBook contact = iterator.next();
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public static void main(String[] args) {

        AddressBook contact1 = new AddressBook("John", "Doe", "123 Main St", "Anytown", "NY", "12345", "555-1234", "john.doe@example.com");
        AddressBook contact2 = new AddressBook("Jane", "Smith", "456 Elm St", "Othertown", "CA", "67890", "555-5678", "jane.smith@example.com");
        AddressBook contact3 = new AddressBook("Alice", "Johnson", "789 Oak St", "Somewhere", "TX", "13579", "555-9876", "alice.johnson@example.com");

        System.out.println("\nAll Contacts:");
        List<AddressBook> allContacts = AddressBook.getAllContacts();
        for (AddressBook contact : allContacts) {
            contact.display();
        }

        AddressBook.deleteContact("John", "Doe");

        System.out.println("After Deletion:");
        for (AddressBook contact : allContacts) {
            contact.display();
        }

    }
}
