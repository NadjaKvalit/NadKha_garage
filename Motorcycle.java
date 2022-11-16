package garage;

public class Motorcycle extends Vehicle{
    private int numOfPedals;

    protected Motorcycle(String name, String regNum, String color, int yearOfManufacturing, int numOfPedals) {
        super(name, regNum, color, yearOfManufacturing);
        this.numOfPedals=numOfPedals;
    }
}
