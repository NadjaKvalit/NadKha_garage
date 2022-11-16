package garage;

public class Airplane extends Vehicle {
    private int numOfWings;

    protected void canFly() {
        System.out.println("The airplane can fly.");
    }

    Airplane(String name, String regNum, String color, int yearOfManufacturing, int numOfWings) {
        super(name, regNum, color, yearOfManufacturing);
        this.numOfWings = numOfWings;
    }
}
