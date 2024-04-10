package giuaki;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VehicleManager {
    List<Vehicle> vehicles;

    public VehicleManager() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void showAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.showInfo();
        }
    }

    public void saveToFile(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(vehicles);
            out.close();
            fileOut.close();
            System.out.println("Dữ liệu đã lưu trong file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            vehicles = (List<Vehicle>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Dữ liệu đã tải từ file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void deleteVehicle(String ID) {
        for (Iterator<Vehicle> iterator = vehicles.iterator(); iterator.hasNext();) {
            Vehicle vehicle = iterator.next();
            if (vehicle.ID.equals(ID)) {
                iterator.remove();
                System.out.println("ID Xe " + ID + " đã bị xóa.");
                return;
            }
        }
        System.out.println("ID xe " + ID + " không tìm thấy");
    }
    public void updateVehicle(String ID, String brand, int publishYear, double price, String color) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.ID.equals(ID)) {
                vehicle.brand = brand;
                vehicle.publishYear = publishYear;
                vehicle.price = price;
                vehicle.color = color;
                System.out.println("ID xe " + ID + " đã cập nhật.");
                return;
            }
        }
        System.out.println("ID xe " + ID + " không tìm thấy.");
    }

}
