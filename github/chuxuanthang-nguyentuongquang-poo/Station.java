import java.util.ArrayList;
import java.util.List;

public class Station {
    private String stationId;
    private int capacity;
    private String location;
    private List<Bike> bikes;

    public Station(String stationId, int capacity, String location) {
        this.stationId = stationId;
        this.capacity = capacity;
        this.location = location;
        this.bikes = new ArrayList<>();
    }

    public boolean addBike(Bike bike) {
        if (bikes.size() < capacity) {
            bikes.add(bike);
            return true;
        }
        return false;
    }

    public List<Bike> getAvailableBikes(){
        List<Bike> availableBikes = new ArrayList<>();
        for (Bike bike : bikes){
            if ( bike.getStatus().equals("available")){
                availableBikes.add(bike);
            }
        }
        return availableBikes;
    }

    public boolean removeBike(Bike bike) {
        return bikes.remove(bike);
    }

    public int getAvailableSlots() {
        return capacity - bikes.size();
    }

    public boolean isFull() {
        return bikes.size() >= capacity;
    }

    public String getLocation() {
        return location;
    }

    public String getStationId() {
        return stationId;
    }
}
