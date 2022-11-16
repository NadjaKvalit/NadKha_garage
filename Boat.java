package garage;

public class Boat extends Vehicle {
    private int numOfDeck;

    protected Boat(String name,String regNum, String color, int yearOfManufacturing,int numOfDeck) {
        super(name,regNum, color, yearOfManufacturing);
        this.numOfDeck=numOfDeck;
    }

    protected void canSwim(){
        System.out.println("The boat can swim.");
    };

    public int getNumOfDeck() {
        return numOfDeck;
    }

    public void setNumOfDeck(int numOfDeck) {
        this.numOfDeck = numOfDeck;
    }
}
