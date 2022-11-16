package garage;

public abstract class Vehicle {
    protected String regNum;
    protected String color;
    protected int yearOfManufacturing;
    protected String name;

    protected Vehicle(String name, String regNum, String color, int yearOfManufacturing) {
        this.name= name;
        this.color = color;
        this.yearOfManufacturing = yearOfManufacturing;
        this.regNum = regNum;
    }
}
