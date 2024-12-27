public class BasketDecorator extends BikeDecorator {
    protected boolean hasBasket;
    public BasketDecorator(Bike bike) {
        super(bike);
        this.hasBasket = true;
    }
    @Override
    public String getStatus() {
        return bike.getStatus() + " (with Basket)";
    }
    public boolean hasBasket(){
        return hasBasket;
    }
}