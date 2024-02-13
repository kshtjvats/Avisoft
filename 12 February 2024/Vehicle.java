import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Abstract class representing a generic Vehicle
abstract class Vehicle {
    // Attributes common to all vehicles
    private String make, model, year;
    private double rentalPrice;
    private int vid;

    // Constructor to initialize attributes
    Vehicle(String make, String model, String year, double rentalPrice, int vid) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
        this.vid = vid;
    }

    // Getters to access private attributes
    String getMake() {
        return make;
    }

    String getModel() {
        return model;
    }

    String getyear() {
        return year;
    }

    double getPrice() {
        return rentalPrice;
    }

    int getvId() {
        return vid;
    }

    // Abstract method to calculate rent, to be implemented by subclasses
    abstract double calculateRent();
}

// Subclass representing a car, extends Vehicle
class Car extends Vehicle {
    // Additional attributes specific to cars
    int doors, seats;
    String fuelType;

    // Constructor to initialize car attributes
    Car(String make, String model, String year, double rentalPrice, int vid, int doors, int seats, String fuelType) {
        super(make, model, year, rentalPrice, vid);
        this.doors = doors;
        this.seats = seats;
        this.fuelType = fuelType;
    }

    // Overridden method to calculate rent for a car
    @Override
    double calculateRent() {
        return getPrice();
    }

    // Method to display car details
    void showDetails() {
        System.out.println("********************************");
        System.out.println("Vehicle details are-:");
        System.out.println("Vehicle Name : " + getMake() + " " + getModel());
        System.out.println("Vehicle Year : " + getyear());
        System.out.println("Vehicle ID : " + getvId());
        System.out.println("Vehicle Doors : " + doors);
        System.out.println("Vehicle Seats : " + seats);
        System.out.println("Vehicle RentalPrice : " + getPrice());
        System.out.println("********************************");
    }
}

// Class representing a Customer
class Customer {
    // Attributes of a customer
    private String name;
    private String email;
    int uid;
    ArrayList<Car> rented; // Cars rented by the customer

    // Constructor to initialize customer attributes
    Customer(String name, String email, int uid, ArrayList<Car> rented) {
        this.name = name;
        this.email = email;
        this.rented = rented;
        this.uid = uid;
    }

    // Getter methods
    String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    int getUid() {
        return uid;
    }

    // Method to display rental history of a customer
    void dispHistory() {
        for (int i = 0; i < rented.size(); i++) {
            rented.get(i).showDetails();
        }
    }

    // Method to display customer details
    void displayUser() {
        System.out.println("********************************");
        System.out.println("User details are-:");
        System.out.println("User Name : " + getName());
        System.out.println("User Email : " + getEmail());
        System.out.println("User ID : " + getUid());
        System.out.println("Number of cars rented :" + rented.size());
        System.out.println("********************************");
    }
}

// Main class to run the program
class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Lists to store cars, users, and rented cars
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Customer> users = new ArrayList<>();
        ArrayList<Car> rented = new ArrayList<>();
        // Sets to ensure uniqueness of IDs and email addresses
        Set<Integer> carIds = new HashSet<>();
        Set<Integer> userIds = new HashSet<>();
        Set<String> userEmails = new HashSet<>();
        int choice = 0;
        // Menu-driven loop to perform various operations
        while (choice != -1) {
            System.out.println("Enter a choice");
            System.out.println("1 : To add a Vehicle");
            System.out.println("2 : Display All available Vehicles");
            System.out.println("3 : To display Vehicle info");
            System.out.println("4 : Register a User");
            System.out.println("5 : Show User info");
            System.out.println("6 : Rent a car");
            System.out.println("7 : Return a Rented Vehicle");
            System.out.println("8 : Show Rented Vehicles");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addVehicle(cars, carIds);
                    break;
                case 2:
                    System.out.println("List of Available Cars is");
                    if(cars.size()==0)
                    System.out.println("Sorry No cars available,come another time");
                    else
                    DisplayAllCars(cars);
                    break;
                case 3:
                    int index = searchCar(cars,carIds);
                    cars.get(index).showDetails();
                    break;
                case 4:
                    addUser(users, rented, userIds, userEmails);
                    break;
                case 5:
                if (users.size() == 0)
                        System.out.println("No active user found!");
                    else
                    {
                    int userIndex = searchUser(users);
                    users.get(userIndex).displayUser();
                    }
                    break;
                case 6:
                    if (users.size() == 0)
                        System.out.println("No active user found!");
                    else {
                        int userIndex1 = searchUser(users);
                        int carIndex = searchCar(cars,carIds);
                        if(carIndex!=-1)
                        {
                        cars.get(carIndex).showDetails();
                        System.out.println("Enter 1 to rent or press any key to continue");
                        int rentChoice = sc.nextInt();
                        if (rentChoice == 1) {
                            System.out.println("Enter number of days to rent");
                            int days = sc.nextInt();
                            System.out.println("******************Amount to be Paid: " + (cars.get(carIndex).getPrice() * days));
                            if (isPaid(cars.get(carIndex).getPrice() * days)) {
                                Customer customer = new Customer(users.get(userIndex1).getName(), users.get(userIndex1).getEmail(), users.get(userIndex1).getUid(), rented);
                                customer.rented.add(cars.get(carIndex));
                                cars.remove(cars.get(carIndex));
                                System.out.println("Car Rented");
                            } else
                                System.out.println("Payment failed, car Not rented");
                        }
                    }
                    else
                    break;
                    break;
                }
                case 7:
                    int userIndex3 = searchUser(users);
                    if (rented.size() != 0) {
                        int carIndex2 = searchCar(rented,carIds);
                        cars.add(rented.get(carIndex2));
                        System.out.println("Vehicle Returned!");
                    } else
                        System.out.println("No cars Rented so far!");
                    break;
                case 8:
                    int userIndex2 = searchUser(users);
                    users.get(userIndex2).dispHistory();
                    break;
                default:
                    break;
            }
        }
    }

    // Method to add a vehicle to the list
    static void addVehicle(ArrayList<Car> cars, Set<Integer> carIds) {
        System.out.println("Enter Car Make");
        String make = sc.next();
        System.out.println("Enter Car Model");
        String model = sc.next();
        System.out.println("Enter Car ID");
        int vid = sc.nextInt();
        System.out.println("Enter Car Year");
        String year = sc.next();
        System.out.println("Enter Car Rental Price");
        double rent = sc.nextDouble();
        System.out.println("Enter Number of doors in car");
        int doors = sc.nextInt();
        System.out.println("Enter Number of seats in car");
        int seats = sc.nextInt();
        System.out.println("Enter Car Fuel Type");
        String fuel = sc.next();
        if (!isIdUnique(carIds, vid) && isNameCorrect(make) && isNameCorrect(model) && isNameCorrect(fuel) && doors > 0 && seats > 0 && rent > 0) {
            carIds.add(vid);
            cars.add(new Car(make, model, year, rent, vid, doors, seats, fuel));
        } else
            System.out.println("Cannot make this entry");
    }

    // Method to add a user to the list
    static void addUser(ArrayList<Customer> users, ArrayList<Car> rented, Set<Integer> userIds, Set<String> userEmails) {
        System.out.println("Enter User Name");
        String name = sc.next();
        System.out.println("Enter User ID");
        int uid = sc.nextInt();
        System.out.println("Enter User Email");
        String email = sc.next();
        if (!isIdUnique(userIds, uid) && !isEmailUnique(userEmails, email) && isNameCorrect(name)) {
            userIds.add(uid);
            users.add(new Customer(name, email, uid, rented));
        } else
            System.out.println("Cannot make this entry");
    }

    // Method to search for a car in the list
    static int searchCar(ArrayList<Car> cars,Set<Integer>cid) {
        if (cars.size() == 0) {
            System.out.println("Car List Empty, No cars available!");
            return 0;
        }
        System.out.println("Enter car ID");
        int carId = sc.nextInt();
        if(cid.contains(carId)==true)
        {
        int index = 0;
        for (index = 0; index < cars.size(); index++) {
            if (cars.get(index).getvId() == carId)
                break;
        }
        return index;
        }
        else
        {
            System.out.println("Car not present at the moment!");
            return -1;
        }
    }
    //Method to show all cars List
    static void DisplayAllCars(ArrayList<Car> cars)
    {
    for(int i=0;i<cars.size();i++)
    cars.get(i).showDetails();
    }

    // Method to search for a user in the list
    static int searchUser(ArrayList<Customer> users) {
        System.out.println("Enter user ID");
        int uid = sc.nextInt();
        int index = 0;
        for (index = 0; index < users.size(); index++) {
            if (users.get(index).getUid() == uid)
                break;
        }
        return index;
    }

    // Method to verify payment
    static boolean isPaid(double price) {
        System.out.println("Enter Your Amount");
        double amount = sc.nextDouble();
        return amount == price;
    }

    // Method to check uniqueness of ID
    static boolean isIdUnique(Set<Integer> id, int xid) {
        return id.contains(xid);
    }

    // Method to check uniqueness of email
    static boolean isEmailUnique(Set<String> id, String xid) {
        return id.contains(xid);
    }

    // Method to validate name
    static boolean isNameCorrect(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!(name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') && !(name.charAt(i) >= 'a' && name.charAt(i) <= 'z')) {
                return false;
            }
        }
        return true;
    }
}
