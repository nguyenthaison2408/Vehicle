package giuaki;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleManager manager = new VehicleManager();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1.Add Vehicle");
            System.out.println("2.Show All Vehicles");
            System.out.println("3.Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addVehicle(scanner, manager);
                    break;
                case 2:
                    manager.showAllVehicles();
                    break;
                case 3:
                    System.out.println("Exiting");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    public static void addVehicle(Scanner scanner, VehicleManager manager) {
        System.out.println("Select Vehicle Type:");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Truck");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();
        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter Publish Year: ");
        int publishYear = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Color: ");
        String color = scanner.next();

        switch (type) {
            case 1:
                System.out.print("Enter Slots: ");
                int slots = scanner.nextInt();
                System.out.print("Enter Engine Type: ");
                String engineType = scanner.next();
                manager.addVehicle(new Car(ID, brand, publishYear, price, color, slots, engineType));
                break;
            case 2:
                System.out.print("Enter Capacity: ");
                int capacity = scanner.nextInt();
                manager.addVehicle(new Motorcycle(ID, brand, publishYear, price, color, capacity));
                break;
            case 3:
                System.out.print("Enter Load Weight: ");
                double loadWeight = scanner.nextDouble();
                manager.addVehicle(new Truck(ID, brand, publishYear, price, color, loadWeight));
                break;
            default:
                System.out.println("Invalid.");
        }
    }
}