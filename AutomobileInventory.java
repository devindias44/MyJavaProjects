import java.io.*;
import java.util.Scanner;

public class Automobile {
    // Private variables to store vehicle information
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Default constructor
    public Automobile() {
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }

    // Parameterized constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // Method to add a vehicle
    public String addVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle added successfully.";
        } catch (Exception e) {
            return "Error adding vehicle: " + e.getMessage();
        }
    }

    // Method to list vehicle information (return string array)
    public String[] listVehicleInfo() {
        try {
            if (this.make == null || this.make.isEmpty()) {
                return new String[]{"No vehicle information available."};
            }
            return new String[]{
                "Make: " + this.make,
                "Model: " + this.model,
                "Color: " + this.color,
                "Year: " + this.year,
                "Mileage: " + this.mileage
            };
        } catch (Exception e) {
            return new String[]{"Error retrieving vehicle information: " + e.getMessage()};
        }
    }

    // Method to remove a vehicle
    public String removeVehicle() {
        try {
            this.make = "";
            this.model = "";
            this.color = "";
            this.year = 0;
            this.mileage = 0;
            return "Vehicle removed successfully.";
        } catch (Exception e) {
            return "Error removing vehicle: " + e.getMessage();
        }
    }

    // Method to update vehicle attributes
    public String updateVehicle(String make, String model, String color, int year, int mileage) {
        try {
            if (make != null) this.make = make;
            if (model != null) this.model = model;
            if (color != null) this.color = color;
            if (year > 0) this.year = year;
            if (mileage >= 0) this.mileage = mileage;
            return "Vehicle updated successfully.";
        } catch (Exception e) {
            return "Error updating vehicle: " + e.getMessage();
        }
    }
}

public class AutomobileInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Create automobile with parameterized constructor
            Automobile auto = new Automobile("Toyota", "Camry", "Blue", 2020, 25000);
            
            // List vehicle values
            System.out.println("\nInitial Vehicle Information:");
            String[] vehicleInfo = auto.listVehicleInfo();
            for (String info : vehicleInfo) {
                System.out.println(info);
            }
            
            // Remove vehicle
            System.out.println("\n" + auto.removeVehicle());
            
            // Add new vehicle
            System.out.println("\n" + auto.addVehicle("Honda", "Accord", "Red", 2021, 15000));
            
            // List new vehicle information
            System.out.println("\nNew Vehicle Information:");
            vehicleInfo = auto.listVehicleInfo();
            for (String info : vehicleInfo) {
                System.out.println(info);
            }
            
            // Update vehicle
            System.out.println("\n" + auto.updateVehicle("Honda", "Civic", "Black", 2022, 5000));
            
            // List updated vehicle information
            System.out.println("\nUpdated Vehicle Information:");
            vehicleInfo = auto.listVehicleInfo();
            for (String info : vehicleInfo) {
                System.out.println(info);
            }
            
            // Ask user if they want to print to file
            System.out.print("\nDo you want to print the information to a file? (Y/N): ");
            String response = scanner.nextLine().trim().toUpperCase();
            
            if (response.equals("Y")) {
                try {
                    PrintWriter writer = new PrintWriter("C:\\Temp\\Autos.txt");
                    for (String info : vehicleInfo) {
                        writer.println(info);
                    }
                    writer.close();
                    System.out.println("File printed successfully to C:\\Temp\\Autos.txt");
                } catch (IOException e) {
                    System.out.println("Error printing to file: " + e.getMessage());
                }
            } else {
                System.out.println("File will not be printed.");
            }
        } catch (Exception e) {
            System.out.println("Error in AutomobileInventory: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
