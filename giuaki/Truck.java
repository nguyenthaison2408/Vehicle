package giuaki;

class Truck extends Vehicle {
    double loadWeight;

    public Truck(String ID, String brand, int publishYear, double price, String color, double loadWeight) {
        super(ID, brand, publishYear, price, color);
        this.loadWeight = loadWeight;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Trọng tải: " + loadWeight);
    }
}

