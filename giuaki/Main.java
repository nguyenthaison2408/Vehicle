package giuaki;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleManager manager = new VehicleManager();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1.Thêm phương tiện");
            System.out.println("2.Hiển thị toàn bộ phương tiện");
            System.out.println("3.Lưu thư mục");
            System.out.println("4.Tải thư mục");
            System.out.println("5.Xóa xe");
            System.out.println("6.Cập nhật xe");
            System.out.println("7.Thoát");
            System.out.print("Vui lòng chọn: ");
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
                manager.saveToFile("vehicles.dat");
                break;
            case 4:
                manager.loadFromFile("vehicles.dat");
                break;
            case 5:
                System.out.print("Nhập ID xe cần xóa: ");
                String deleteID = scanner.nextLine();
                manager.deleteVehicle(deleteID);
                break;
            case 6:
            	scanner.nextLine();
            	updateVehicle(scanner, manager);
                break;
            case 7:
                System.out.println("Đang thoát");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Không hợp lệ.");
        }
    }
}

    public static void addVehicle(Scanner scanner, VehicleManager manager) {
        System.out.println("Chọn Loại Xe:");
        System.out.println("1. Ôto");
        System.out.println("2. Xe Máy");
        System.out.println("3. Xe Tải");
        System.out.print("Chọn Số: ");
        int type = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Nhập ID: ");
        String ID = scanner.nextLine();
        System.out.print("Nhập hãng: ");
        String brand = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int publishYear = scanner.nextInt();
        System.out.print("Nhập giá: ");
        double price = scanner.nextDouble();
        System.out.print("Nhập màu: ");
        String color = scanner.next();

        switch (type) {
            case 1:
                System.out.print("Nhập chỗ ngồi: ");
                int slots = scanner.nextInt();
                System.out.print("Nhập kiểu động cơ: ");
                String engineType = scanner.next();
                manager.addVehicle(new Car(ID, brand, publishYear, price, color, slots, engineType));
                break;
            case 2:
                System.out.print("Nhập công suất: ");
                int capacity = scanner.nextInt();
                manager.addVehicle(new Motorcycle(ID, brand, publishYear, price, color, capacity));
                break;
            case 3:
                System.out.print("Nhập trọng tải: ");
                double loadWeight = scanner.nextDouble();
                manager.addVehicle(new Truck(ID, brand, publishYear, price, color, loadWeight));
                break;
            default:
                System.out.println("Không hợp lệ.");
        }
    }
    public static void updateVehicle(Scanner scanner, VehicleManager manager) {
        System.out.print("Nhập ID của xe cần cập nhật: ");
        String updateID = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String brand = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int publishYear = scanner.nextInt();
        System.out.print("Nhập giá xe: ");
        double price = scanner.nextDouble();
        System.out.print("Nhập màu xe: ");
        String color = scanner.next();
        manager.updateVehicle(updateID, brand, publishYear, price, color);
}
}