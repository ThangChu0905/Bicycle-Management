abstract class Worker implements IBikeVisitor{
    protected String name;
    protected String description;

    public Worker(String name, String description){
        this.name = name;
        this.description = description;
    }
    public abstract void visit(Bike bike);
}