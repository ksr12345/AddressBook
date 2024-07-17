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

    public static void addContact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        AddressBook newContact = new AddressBook(firstName, lastName, address, city, state, zip, phoneNumber, email);
        contacts.add(newContact);
    }

    public static void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("All Contacts:");
            for (AddressBook contact : contacts) {
                contact.display();
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Address Book");

        char choice;
        do {
            System.out.println("Enter details for new contact:");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("City: ");
            String city = scanner.nextLine();

            System.out.print("State: ");
            String state = scanner.nextLine();

            System.out.print("Zip: ");
            String zip = scanner.nextLine();

            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            AddressBook.addContact(firstName, lastName, address, city, state, zip, phoneNumber, email);

            System.out.print("Do you want to add another contact? (y/n): ");
            choice = scanner.nextLine().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        // Display all contacts in the address book
        AddressBook.displayAllContacts();

        scanner.close();
    }
}
