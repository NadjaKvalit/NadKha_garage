package garage;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Garage {
    public static final int PARKING_PLACES = 20;
    boolean wrongInput;
    Scanner scanner = new Scanner(System.in);
    Vehicle[] listOfParkingVehicles = new Vehicle[Garage.PARKING_PLACES];

    {
        listOfParkingVehicles[0] = new Airplane("airplane1", "AIR123", "red", 1970, 2);
        listOfParkingVehicles[2] = new Motorcycle("motorcycle1", "MOT123", "blue", 2010, 2);
        listOfParkingVehicles[5] = new Motorcycle("motorcycle1", "MOT234", "black", 2015, 2);
        listOfParkingVehicles[8] = new Car("car1", "CAR123", "yellow", 2019, 4);
        listOfParkingVehicles[9] = new Car("car2", "CAR234", "white", 2017, 4);
        listOfParkingVehicles[12] = new Car("car3", "CAR345", "white", 2016, 6);
        listOfParkingVehicles[14] = new Bus("bus1", "BUS123", "red", 2010, 30);
        listOfParkingVehicles[16] = new Bus("bus2", "BUS234", "white", 2012, 40);
        listOfParkingVehicles[19] = new Boat("boat1", "BOA123", "green", 2016, 1);
    }

    public void getListOfParkedVehicleTypes() {
        System.out.printf("%40s", "The list of all parked Vehicles:\n");
        System.out.printf("%-10s", "Place");
        System.out.printf("%-15s", "Vehicle");
        System.out.printf("%-15s", "Name");
        System.out.printf("%12s", "RegNum" + "\n");
        for (int i = 0; i < 53; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
        for (int i = 0; i < Garage.PARKING_PLACES; i++) {
            if (listOfParkingVehicles[i] != null) {
                System.out.printf("%-10d", (i + 1));
                System.out.printf("%-15s", (listOfParkingVehicles[i].getClass().getSimpleName()));
                System.out.printf("%-15s", listOfParkingVehicles[i].name);
                System.out.printf("%12s", listOfParkingVehicles[i].regNum + "\n");
            }
        }
    }

    public boolean checkFreeParkingPlaces() {
        for (int i = 0; i < Garage.PARKING_PLACES; i++) {
            if (listOfParkingVehicles[i] != null) {
                return true;
            }
        }
        return false;
    }

    public int getTheFirstFreeParkingPlace() {
        for (int i = 0; i < Garage.PARKING_PLACES; i++) {
            if (listOfParkingVehicles[i] == null) {
                return i + 1;
            }
        }
        return 0;
    }

    public void parkTheVehicle(Vehicle newVehicle) {
        if (checkFreeParkingPlaces()) {
            System.out.println("\nYou can park your " + newVehicle.getClass().getSimpleName() + " on the place #" + getTheFirstFreeParkingPlace());
            listOfParkingVehicles[getTheFirstFreeParkingPlace() - 1] = newVehicle;
        } else {
            System.out.println("Sorry, there is no free parking places");
        }
    }

    public int searchRegNum(String regNumToSearch) {
        System.out.println("So, we are looking for " + regNumToSearch);
        for (int i = 0; i < Garage.PARKING_PLACES; i++) {
            if (listOfParkingVehicles[i] != null) {
                String isThisOurCar = listOfParkingVehicles[i].regNum;
                if (Objects.equals(regNumToSearch, isThisOurCar)) {
                    return i;
                }
            }
        }
        return -1000;
    }

    public void searchTheVehicle() {
        System.out.print("Let's find your vehicle. What RegNum does it have?: ");
        String regNumToSearch = scanner.next().toUpperCase();
        scanner.nextLine();
        int foundPlace = searchRegNum(regNumToSearch);
        if ((foundPlace + 1) > 0) {
            System.out.println("Your " + listOfParkingVehicles[foundPlace].getClass().getSimpleName() + " with RegNum " +
                    listOfParkingVehicles[foundPlace].regNum.toUpperCase() + " is on the place # : " + (foundPlace + 1));
        } else {
            System.out.println("Sorry, there is no vehicle with RegNum " + regNumToSearch);
        }
    }

    public void driveOutTheVehicle() {
        System.out.println("Hi. You want to drive out of the parking. Do you need help?\n" +
                "If you don't remember where did you park then we can find the place in the list. Choose: 1.\n" +
                "If you know the place where you parked, then choose: 2.");

        int driveOutPlace = 0;
        String choiceDriveOutTheVehicle = scanner.next();

        //TODO: titta vad IntelliJ tipsar om
        switch (choiceDriveOutTheVehicle) {
            case "1":
                getListOfParkedVehicleTypes();
                System.out.println("Did you find your vehicle? Say y/n.");
                String choiceYesNoOnGarage = scanner.next().toUpperCase();
                switch (choiceYesNoOnGarage) {

                    //TODO: casen skulle kunna faktoreras ut, dvs. brytas ut till egna metoder som anropas,
                    //Titta på parkInSwitch(int driveOutPlace)
                    case "Y":
                    case "YES":
                        System.out.println("What place do you want to drive out?: ");
                        try {
                            driveOutPlace = scanner.nextInt() - 1;
                            System.out.println("Bye. Have a nice day " + listOfParkingVehicles[driveOutPlace].name + " and welcome back! Ups, I forgot to ask.");
                            listOfParkingVehicles[driveOutPlace] = null;
                            wrongInput = false;
                        } catch (InputMismatchException i) {
                            scanner.nextLine();
                            System.err.print("Sorry, you can write only numbers in numeric fields.");
                            System.out.println("\n");
                            wrongInput = true;
                        } catch (NullPointerException n) {
                            scanner.nextLine();
                            System.err.print("Sorry, the place " + (driveOutPlace + 1) + " is empty");
                            System.out.println("\n");
                            wrongInput = true;
                        } catch (ArrayIndexOutOfBoundsException a) {
                            scanner.nextLine();
                            System.err.print("Upps, we have only " + PARKING_PLACES + " parking places in our garage");
                            System.out.println("\n");
                            wrongInput = true;
                        }
                        break;
                    case "N":
                    case "NO":
                        System.out.println("Maybe you parked on another place.");
                        wrongInput = false;
                        break;
                    default:
                        scanner.nextLine();
                        System.err.print("Sorry, you have only 2 choices: y or n.");
                        System.out.println("\n");
                        wrongInput = true;
                }
                break;
            case "2":
                System.out.println("What place do you want to drive out?: ");
                try {
                    driveOutPlace = scanner.nextInt() - 1;
                    System.out.println("Bye. Have a nice day " + listOfParkingVehicles[driveOutPlace].name + " and welcome back! Ups, I forgot to ask.");
                    listOfParkingVehicles[driveOutPlace] = null;
                    wrongInput = false;
                } catch (InputMismatchException i) {
                    scanner.nextLine();
                    System.err.print("Sorry, you can write only numbers in numeric fields.");
                    System.out.println("\n");
                    wrongInput = true;
                } catch (NullPointerException n) {
                    scanner.nextLine();
                    System.err.print("Sorry, the place " + (driveOutPlace + 1) + " is empty");
                    System.out.println("\n");
                    wrongInput = true;
                } catch (ArrayIndexOutOfBoundsException a) {
                    scanner.nextLine();
                    System.err.print("Upps, we have only " + PARKING_PLACES + " in our garage");
                    System.out.println("\n");
                    wrongInput = true;
                }
                break;
            default:
                scanner.nextLine();
                System.err.print("Sorry, you can choose only 1 or 2.");
                System.out.println("\n");
                wrongInput = true;
        }
    }

    /*
    private boolean parkInSwitch(int driveOutPlace) {
        boolean wrongInput = false;

        System.out.println("What place do you want to drive out?: ");
        try {
            driveOutPlace = scanner.nextInt() - 1;
            System.out.println("Bye. Have a nice day " + listOfParkingVehicles[driveOutPlace].name + " and welcome back! Ups, I forgot to ask.");
            listOfParkingVehicles[driveOutPlace] = null;
            wrongInput = false;
        } catch (InputMismatchException i) {
            scanner.nextLine();
            System.err.print("Sorry, you can write only numbers in numeric fields.");
            System.out.println("\n");
            wrongInput = true;
        } catch (NullPointerException n) {
            scanner.nextLine();
            System.err.print("Sorry, the place " + (driveOutPlace + 1) + " is empty");
            System.out.println("\n");
            wrongInput = true;
        } catch (ArrayIndexOutOfBoundsException a) {
            scanner.nextLine();
            System.err.print("Upps, we have only " + PARKING_PLACES + " parking places in our garage");
            System.out.println("\n");
            wrongInput = true;
        }
        return wrongInput;
    }
    */

    public boolean chooseAnotherAction() {
        System.out.println("\nDo you want to choose another option? y/n?");
        String choiceTryAgain = scanner.next();
        if (choiceTryAgain.equalsIgnoreCase("y") || choiceTryAgain.equalsIgnoreCase("yes")) {
            return true;
        } else {
            System.out.println("Ok. Bye. Have a nice day!");
        }
        return false;
    }

    public void chooseActions() {
        Factory factory = new Factory();
        System.out.println("Welcome to our Parking. You have a few options: \n" +
                "Park in the garage: 1\n" +
                "Drive out of the garage: 2\n" +
                "Search a vehicle in the garage: 3\n" +
                "Get a list of parked vehicles: 4\n" +
                "What do you choose?: ");
        try {
            int optionsChoice = scanner.nextInt();
            scanner.nextLine();
            switch (optionsChoice) {
                case 1:
                    Vehicle newVehicle;
                    do {
                        newVehicle = factory.registrationNewVehicle();
                    }
                    while (newVehicle == null);
                    parkTheVehicle(newVehicle);
                    break;
                case 2:
                    do {
                        driveOutTheVehicle();
                    }
                    while (wrongInput);
                    break;
                case 3:
                    searchTheVehicle();
                    break;
                case 4:
                    getListOfParkedVehicleTypes();
                    break;
                default:
                    System.err.println("Sorry, you can choose only options 1, 2, 3 or 4.");
                    break;
            }
        } catch (InputMismatchException m) {
            scanner.nextLine();
            System.err.println("Sorry, you can choose only options 1, 2, 3 or 4.");
        }
    }
}
