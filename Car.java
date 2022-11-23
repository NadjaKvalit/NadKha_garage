package garage;

public class Car extends Vehicle {

    private int numOfWheels;

    /*TODO: eftersom konstruktorn är protected kan den bara nås inifrån paketet.
    Det spelar ingen roll i det här fallet eftersom allt ligger i samma mapp,
    men om någon vill använda ditt projekt så kommer de inte kunna skapa egna instanser av objekten.
    */

    protected Car(String name, String regNum, String color, int yearOfManufacturing, int numOfWheels) {
        super(name, regNum, color, yearOfManufacturing);
        this.numOfWheels = numOfWheels;
    }
}
