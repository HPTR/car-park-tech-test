import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarPark {
    private static final List<Vehicle> carPark = new ArrayList<>();

    private static Integer standardSpots;
    private static Integer motorcycleSpots;
    private static Integer maxSpots;
    private static Integer vehiclesParked;

    public CarPark(int standardSpots, int motorcycleSpots) {
        CarPark.standardSpots = standardSpots;
        CarPark.motorcycleSpots = motorcycleSpots;
        CarPark.maxSpots = standardSpots + motorcycleSpots;
        CarPark.vehiclesParked = 0;
    }

    public static void parkVehicle(@NotNull Vehicle vehicle) {
        int standardSpotsRemaining = getStandardSpots();
        int motorcycleSpotsRemaining = getMotorcycleSpots();

        if (Objects.equals(vehicle.getType(), "car") && standardSpotsRemaining >= 1) {
            carPark.add(new Car());
            setStandardSpots(standardSpots - vehicle.getVehicleSize());
            setVehiclesParked(vehiclesParked + 1);
        }

        if (Objects.equals(vehicle.getType(), "van") && standardSpotsRemaining >= 3) {
            carPark.add(new Van());
            setStandardSpots(standardSpots - vehicle.getVehicleSize());
            setVehiclesParked(vehiclesParked + 1);
        }

        if (Objects.equals(vehicle.getType(), "motorcycle") && motorcycleSpotsRemaining >= 1) {
            carPark.add(new Motorcycle());
            setMotorcycleSpots(motorcycleSpots - vehicle.getVehicleSize());
            setVehiclesParked(vehiclesParked + 1);
        } else if (Objects.equals(vehicle.getType(), "motorcycle") && standardSpotsRemaining >= 1) {
            carPark.add(new Motorcycle());
            setStandardSpots(standardSpots - vehicle.getVehicleSize());
            setVehiclesParked(vehiclesParked + 1);
        }
    }

    public static List<Vehicle> getCarPark(){
        return carPark;
    }

    public static Integer getStandardSpots() {
        return standardSpots;
    }

    public static void setStandardSpots(Integer standardSpots) {
        CarPark.standardSpots = standardSpots;
    }

    public static Integer getMotorcycleSpots() {
        return motorcycleSpots;
    }

    public static void setMotorcycleSpots(Integer motorcycleSpots) {
        CarPark.motorcycleSpots = motorcycleSpots;
    }

    public static Integer getVehiclesParked() {
        return vehiclesParked;
    }

    public static void setVehiclesParked(Integer vehiclesParked) {
        CarPark.vehiclesParked = vehiclesParked;
    }

    public static void populate() {
        for (int i = 0; i < 5; i++) {
            CarPark.parkVehicle(new Car());
            CarPark.parkVehicle(new Van());
        }

        for (int i = 0; i < 15; i++) {
            CarPark.parkVehicle(new Motorcycle());
        }
    }

    public static Integer getVehiclesByType(String type) {
        List<Vehicle> result = carPark.stream()
                .filter(item -> Objects.equals(item.getType(), type))
                .collect(Collectors.toList());
        return result.size();
    }

    public static String getInfo() {
        return String.format("Total Vehicles Parked: %s - Cars: %s - Vans: %s - Motorcycles: %s\nTotal Spots Remaining: %s - Standard: %s - Motorcycle: %s", vehiclesParked, getVehiclesByType("car"), getVehiclesByType("van"), getVehiclesByType("motorcycle"), (maxSpots - vehiclesParked), getStandardSpots(), getMotorcycleSpots());
    }
}
