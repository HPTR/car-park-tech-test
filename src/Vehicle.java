public abstract class Vehicle {
    private final String type;
    private final Integer vehicleSize;

    //Maybe add IDs/number plates
    public Vehicle(String type, Integer vehicleSize) {
        this.type = type;
        this.vehicleSize = vehicleSize;
    }

    public String getType() {
        return type;
    }

    public Integer getVehicleSize() {
        return vehicleSize;
    }
}
