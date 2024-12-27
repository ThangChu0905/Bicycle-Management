public class TraditionalBike extends Bike {
    public TraditionalBike(String id) {
        super(id, "Traditional", 0,"","");
    }

    @Override
    public void accept(IBikeVisitor visitor){
        visitor.visit(this);
    }
}