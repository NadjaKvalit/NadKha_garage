package garage;

public class Bus extends Vehicle{
    private int numOfPassengers;

    protected Bus(String name,String regNum, String color, int yearOfManufacturing,int numOfPassengers) {
        super(name,regNum, color, yearOfManufacturing);
        this.numOfPassengers=numOfPassengers;
    }

    protected void canTransportPeople(){
        System.out.println("The bus can transport a lot of people.");
    };

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
}
