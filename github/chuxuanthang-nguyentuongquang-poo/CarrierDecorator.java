public class CarrierDecorator extends BikeDecorator {
    protected boolean hasCarrier;
    public CarrierDecorator(Bike bike) {
        super(bike);
        this.hasCarrier = true;
    }
    @Override
    public String getStatus() {
        return bike.getStatus() + " (with Carrier)";
    }
    public boolean hasCarrier(){
        return hasCarrier;
    }
}