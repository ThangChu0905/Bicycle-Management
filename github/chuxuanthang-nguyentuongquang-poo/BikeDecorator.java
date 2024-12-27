abstract class BikeDecorator extends Bike {
    protected Bike bike;
    public BikeDecorator(Bike bike){
        super(bike.getId(), bike.getType(), bike.getRentalCount(), bike.getEvent(), bike.getJob());
        this.bike = bike;
    }

    @Override
    public void accept(IBikeVisitor visitor){
        bike.accept(visitor);
    }

}