public class RegularBike extends Bike {
    public RegularBike(String id, String type, int rentalCount) {
        super(id, type, rentalCount, "","");
    }

    @Override
    public void accept(IBikeVisitor visitor) {
        visitor.visit(this);
    }
}