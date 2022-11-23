package garage;

public class Boat extends Vehicle {
    private int numOfDeck;
    protected Boat(String name,String regNum, String color, int yearOfManufacturing,int numOfDeck) {
        super(name,regNum, color, yearOfManufacturing);
        this.numOfDeck=numOfDeck;
    }

    //TODO: du kan lägga till getter/setter till numOfDeck, annars kan den inte nås

}
