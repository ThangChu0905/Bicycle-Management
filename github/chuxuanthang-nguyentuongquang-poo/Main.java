public class Main {
    public static void main(String[] args) {
        // Test 1: Khởi tạo và kiểm tra ControlCenter Singleton
        System.out.println("=== Testing ControlCenter Singleton ===");
        ControlCenter controlCenter = ControlCenter.getInstance();
        System.out.println("ControlCenter created");

        // Test 2: Tạo và thêm Stations
        System.out.println("\n=== Testing Stations ===");
        Station station1 = new Station("S001", 5, "North");
        Station station2 = new Station("S002", 5, "South");
        controlCenter.addStation(station1);
        controlCenter.addStation(station2);
        System.out.println("Created stations: " + station1.getStationId() + ", " + station2.getStationId());

        // Test 3: Tạo các loại Bikes
        System.out.println("\n=== Testing Bike Creation ===");
        RegularBike regularBike = new RegularBike("B001", "Mountain", 0);
        ElectricBike electricBike = new ElectricBike("E001", 100);
        TraditionalBike traditionalBike = new TraditionalBike("T001");

        // Test 4: Thêm Bikes vào Station
        System.out.println("\n=== Testing Adding Bikes to Stations ===");
        station1.addBike(regularBike);
        station1.addBike(electricBike);
        station2.addBike(traditionalBike);
        System.out.println("Added bikes to stations");

        // Test 5: Kiểm tra Visitor Pattern với Mechanic
        System.out.println("\n=== Testing Mechanic Visitor ===");
        Mechanic mechanic = new Mechanic("John");
        mechanic.visit(regularBike);
        mechanic.visit(electricBike);

        // Test 6: User Operations
        System.out.println("\n=== Testing User Operations ===");
        User user = new User("U001", "Alice", null);
        user.rentBike(controlCenter, "B001");
        user.returnBike(station2, "B001");

        // Test 7: Redistribution Strategy
        System.out.println("\n=== Testing Redistribution Strategy ===");
        RoundRobinDistributionStrategy strategy = new RoundRobinDistributionStrategy(controlCenter);
        controlCenter.setRedistributionStrategy(strategy);
        controlCenter.redistributeBikes();

        // Test 8: Maintenance and Status
        System.out.println("\n=== Testing Maintenance and Status ===");
        regularBike.incrementRentalCount(); // Tăng số lần thuê
        controlCenter.maintenanceCheck();
        
        // Test 9: Test Bike Decorators
        System.out.println("\n=== Testing Bike Decorators ===");
        Bike bikeWithBasket = new BasketDecorator(regularBike);
        Bike bikeWithCarrier = new CarrierDecorator(electricBike);
        System.out.println("Bike with basket status: " + bikeWithBasket.getStatus());
        System.out.println("Bike with carrier status: " + bikeWithCarrier.getStatus());

        // Test 10: Report stolen bike
        System.out.println("\n=== Testing Stolen Bike Report ===");
        controlCenter.reportStolenBike("T001");
    }
}