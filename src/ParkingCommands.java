public class ParkingCommands extends Commands {
    public ParkingCommands() {
        super("Parking", new String[]{"Park Car", "Park Van", "Park Motorcycle", "Quit" }, "parking");
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        if (userInput == 1) {
            CarPark.parkVehicle(new Car());
            printMessage(CarPark.getInfo());
        } else if (userInput == 2) {
            CarPark.parkVehicle(new Van());
            printMessage(CarPark.getInfo());
        } else if (userInput == 3) {
            CarPark.parkVehicle(new Motorcycle());
            printMessage(CarPark.getInfo());
        } else {
            setNextCommands("");
        }
    }
}