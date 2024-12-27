public class ElectricBike extends Bike {
    private int batteryLevel;

    public ElectricBike(String id, int initialBatteryLevel) {
        super(id, "Electric", 0,"","");
        this.batteryLevel = initialBatteryLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString() {
        return "ElectricBike{id='" + getId() + "', batteryLevel=" + batteryLevel + "}";
    }

    @Override
    public void accept(IBikeVisitor visitor){
        visitor.visit(this);
    }
}