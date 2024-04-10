package giuaki;
import java.io.*;
import java.util.*;

interface ICar {
    void showInfo();
}

class Vehicle implements ICar, Serializable {
    String ID;
    String brand;
    int publishYear;
    double price;
    String color;

    public Vehicle(String ID, String brand, int publishYear, double price, String color) {
        this.ID = ID;
        this.brand = brand;
        this.publishYear = publishYear;
        this.price = price;
        this.color = color;
    }

    public void showInfo() {
        System.out.println("ID: " + ID + ", Hãng sản xuất: " + brand + ", Năm sản xuất: " + publishYear + ", Gía bán: " + price + ", Màu xe: " + color);
    }
}