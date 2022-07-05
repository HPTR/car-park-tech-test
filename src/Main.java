public class Main {



    public static void main(String[] args) {

        new CarPark(50, 20);

        Commands currentCommands = new ParkingCommands();

        boolean isActive = true;
        while(isActive){
            if ("parking".equals(currentCommands.getNextCommands())) {
                currentCommands = new ParkingCommands();
                currentCommands.run();
            } else {
                isActive = false;
            }
        }

    }
}