package giuaki;
class Motorcycle extends Vehicle {
    int capacity;

    public Motorcycle(String ID, String brand, int publishYear, double price, String color, int capacity) {
        super(ID, brand, publishYear, price, color);
        this.capacity = capacity;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Công suất:" + capacity);
    }
}