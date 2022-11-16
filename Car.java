package garage;

public class Car extends Vehicle{

    private int numOfWheels;

    protected Car(String name,String regNum, String color, int yearOfManufacturing, int numOfWheels) {
        super(name,regNum, color, yearOfManufacturing);
        this.numOfWheels=numOfWheels;
    }

    protected void canDrive(){
        System.out.println("The car can drive.");
    };

    public int getNumOfWheels() {
        return numOfWheels;
    }

    public void setNumOfWheels(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }
}
