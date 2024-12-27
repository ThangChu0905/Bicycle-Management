class Mechanic extends Worker {
    public Mechanic(String name) {
        super(name, "Bike maintenance and repair");
    }

    public void controlBike(Bike bike) {
        System.out.println("Mechanic " + name + " is checking the bike: " + bike.getId());  // thêm khoảng trắng
    }

    @Override  // sửa Override viết hoa
    public void visit(Bike bike) {
        System.out.println("Mechanic " + name + " is visiting bike: " + bike.getId());  // thêm khoảng trắng
        controlBike(bike);
    }
}