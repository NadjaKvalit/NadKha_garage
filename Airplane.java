package garage;

public class Airplane extends Vehicle {
    private int numOfWings;

    //@Det här skulle kunna vara ett fält, en boolean som är true eller false beroende på olika omständigheter, tex. vädret:
    //Om det är storm så kan den vara false, tex...
    protected void canFly() {
        System.out.println("The airplane can fly.");
    }

    Airplane(String name, String regNum, String color, int yearOfManufacturing, int numOfWings) {
        super(name, regNum, color, yearOfManufacturing);
        this.numOfWings = numOfWings;
    }
}
