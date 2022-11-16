package garage;

public class Motorcycle extends Vehicle{
    private int numOfPedals;

    protected Motorcycle(String name, String regNum, String color, int yearOfManufacturing, int numOfPedals) {
        super(name, regNum, color, yearOfManufacturing);
        this.numOfPedals=numOfPedals;
    }

    protected void canBeRode(){
        System.out.println("The motorcycle can be rode.");
    };

    public int getNumOfPedals() {
        return numOfPedals;
    }

    public void setNumOfPedals(int numOfPedals) {
        this.numOfPedals = numOfPedals;
    }
}
