package garage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factory {
    String newRegNum;
    String newColor;
    String newName;
    int newYearOfManufacturing;
    Scanner scanner = new Scanner(System.in);
    public static String thereIsError;

    public void registrationVehiclesParameters() {
        System.out.print("Your vehicle's name is: ");
        newName = scanner.next().toUpperCase();
        System.out.print("Your regNum is: ");
        newRegNum = scanner.next();
        System.out.print("The vehicle's color is: ");
        newColor = scanner.next();
    }
    public Vehicle registrationNewVehicle() {
        System.out.println("First, let's register your vehicle.\nWhat type of vehicle do you have?: ");
        System.out.print(TypeVehicle.AIRPLANE + ": 1; " + TypeVehicle.BOAT + ": 2; " + TypeVehicle.BUS + ": 3; " + TypeVehicle.CAR + ": 4; " + TypeVehicle.MOTORCYCLE + ": 5\n");
        System.out.print("Choose the type here: ");
        switch (scanner.next()) {
            case "1":
                System.out.println("Ok, New Airplane");
                try {
                    registrationVehiclesParameters();
                    System.out.print("The year of manufacturing is: ");
                    newYearOfManufacturing = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("The amount of wings is: ");
                    int newNumOfWings = scanner.nextInt();
                    scanner.nextLine();
                    return new Airplane(newName, newRegNum, newColor, newYearOfManufacturing, newNumOfWings);
                } catch (InputMismatchException m) {
                    scanner.nextLine();
                    System.err.println("Sorry, you can write only numbers in numeric fields.");
                    System.out.println("\n");
                    return null;
                }
            case "2":
                try {
                    System.out.println("Ok, New Boat");
                    registrationVehiclesParameters();
                    System.out.print("The year of manufacturing is: ");
                    newYearOfManufacturing = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("The amount of decks is: ");
                    int numOfDecks = scanner.nextInt();
                    scanner.nextLine();
                    return new Boat(newName, newRegNum, newColor, newYearOfManufacturing, numOfDecks);
                } catch (InputMismatchException m) {
                    scanner.nextLine();
                    System.err.println("Sorry, you can write only numbers in numeric fields.");
                    System.out.println("\n");
                    return null;
                }
            case "3":
                try {
                    System.out.println("Ok, New Bus");
                    registrationVehiclesParameters();
                    System.out.print("The year of manufacturing is: ");
                    newYearOfManufacturing = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("The amount of transported passengers is: ");
                    int numOfPassengers = scanner.nextInt();
                    scanner.nextLine();
                    return new Bus(newName, newRegNum, newColor, newYearOfManufacturing, numOfPassengers);
                } catch (InputMismatchException m) {
                    scanner.nextLine();
                    System.err.println("Sorry, you can write only numbers in numeric fields.");
                    System.out.println("\n");
                    return null;
                }
            case "4":
                try {
                    System.out.println("Ok, New Car");
                    registrationVehiclesParameters();
                    System.out.print("The year of manufacturing is: ");
                    newYearOfManufacturing = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("The amount of wheels is: ");
                    int numOfWheels = scanner.nextInt();
                    scanner.nextLine();
                    return new Car(newName, newRegNum, newColor, newYearOfManufacturing, numOfWheels);
                } catch (InputMismatchException m) {
                    scanner.nextLine();
                    System.err.println("Sorry, you can write only numbers in numeric fields.");
                    System.out.println("\n");
                    return null;
                }
            case "5":
                try {
                    System.out.println("Ok, New Motorcycle");
                    registrationVehiclesParameters();
                    System.out.print("The year of manufacturing is: ");
                    newYearOfManufacturing = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("The amount of pedals is: ");
                    int numOfPedals = scanner.nextInt();
                    scanner.nextLine();
                    return new Motorcycle(newName, newRegNum, newColor, newYearOfManufacturing, numOfPedals);
                } catch (InputMismatchException m) {
                    scanner.nextLine();
                    System.err.println("Sorry, you can write only numbers in numeric fields.");
                    System.out.println("\n");
                    return null;
                }
            default:
                scanner.nextLine();
                System.err.println("Sorry, you can choose only 1, 2, 3, 4 or 5.");
                System.out.println("\n");
                return null;
        }

    }
}