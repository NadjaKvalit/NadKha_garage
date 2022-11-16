package garage;

public class Car extends Vehicle {

    private int numOfWheels;

    protected Car(String name, String regNum, String color, int yearOfManufacturing, int numOfWheels) {
        super(name, regNum, color, yearOfManufacturing);
        this.numOfWheels = numOfWheels;
    }
}
