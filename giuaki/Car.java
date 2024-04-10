package giuaki;
class Car extends Vehicle {
    int slots;
    String engineType;

    public Car(String ID, String brand, int publishYear, double price, String color, int slots, String engineType) {
        super(ID, brand, publishYear, price, color);
        this.slots = slots;
        this.engineType = engineType;
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Slots: " + slots + ", Engine Type: " + engineType);
    }
}
