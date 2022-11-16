package garage;

public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage();
        do{garage.chooseActions();}
        while (garage.chooseAnotherAction());
    }
}


