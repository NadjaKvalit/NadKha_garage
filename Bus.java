package garage;

public class Bus extends Vehicle {
    private int numOfPassengers;

    protected Bus(String name, String regNum, String color, int yearOfManufacturing, int numOfPassengers) {
        super(name, regNum, color, yearOfManufacturing);
        this.numOfPassengers = numOfPassengers;
    }
}
