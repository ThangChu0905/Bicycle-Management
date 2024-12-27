import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String userName;
    private List<Bike> rentedBikes;

    public User(String userId, String userName, List<Bike> rentedBikes) {
        this.userId = userId;
        this.userName = userName;
        if (rentedBikes != null) {
            this.rentedBikes = rentedBikes;
        } else {
            this.rentedBikes = new ArrayList<>();
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void rentBike(ControlCenter controlCenter, String bikeId) {
        List<Station> stations = controlCenter.getStations();
        for (Station station : stations) {
            for (Bike bike : station.getAvailableBikes()) {
                if (bike.getId().equals(bikeId)) {
                    if (!rentedBikes.contains(bike)) {
                        rentedBikes.add(bike);
                        bike.setStatus("rented");
                        System.out.println("Bike " + bike.getId() + " rented");
                        return;
                    }
                }
            }
        }
        System.out.println("Bike " + bikeId + " is not available");
    }

    public void returnBike(Station station, String bikeId) {
        for (Bike bike : rentedBikes) {
            if (bike.getId().equals(bikeId)) {
                if (station.addBike(bike)) {
                    rentedBikes.remove(bike);
                    bike.setStatus("available");
                    System.out.println("Bike " + bike.getId() + " returned to station " + station.getStationId());
                    return;
                } else {
                    System.out.println("Station " + station.getStationId() + " is full");
                    return;
                }
            }
        }
        System.out.println("You have not rented bike " + bikeId);
    }

    public List<Bike> getRentedBikes() {
        return rentedBikes;
    }

    public boolean getRentedBike() {
        return !rentedBikes.isEmpty();
    }

    @Override
    public String toString() {
        return "User{id='" + userId + "', name='" + userName + "', rentedBikes='" + rentedBikes + "'}";
    }
}