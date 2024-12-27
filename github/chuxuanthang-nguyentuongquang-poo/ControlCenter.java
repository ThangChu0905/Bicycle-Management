import java.util.ArrayList;
import java.util.List;

public class ControlCenter {
    private static ControlCenter instance; // singleton pattern 
    private List<Station> stations; 
    private RedistributionStrategy redistributionStrategy;

    public List<Station> getStations(){
        return new ArrayList<>(stations);
    }
    
    private ControlCenter(){
        this.stations = new ArrayList<>(); 
    }

    public static ControlCenter getInstance(){
        if ( instance == null){
            instance = new ControlCenter();
        }
        return instance;
    }

    public void setRedistributionStrategy(RedistributionStrategy strategy){
        this.redistributionStrategy = strategy;
    }

    public void redistributeBikes(){
        if(redistributionStrategy != null){
            redistributionStrategy.redistribute();
        }
    }


// add stations to the list
    public void addStation(Station station) {
        stations.add(station);
    }

    public void distributeBikes(Station fromStation, Station toStation ){    
            if (toStation != fromStation && !toStation.isFull()){
                for (Bike bike : fromStation.getAvailableBikes()){
                    if (toStation.addBike(bike)){
                        fromStation.removeBike(bike);
                        System.out.println("Bike" + bike.getId() +"distributed from station" + fromStation.getStationId() + "to station" + toStation.getStationId());
                    }
                }

            }
        }
    

    public boolean checkBikeRedistributionNeeded(){
        return false;
    }
// anounce if bike get lose
    public void reportStolenBike(String bikeId) {
        for (Station station : stations){
            for (Bike bike : station.getAvailableBikes()){
                if (bike.getId().equals(bikeId)){
                    station.removeBike(bike);
                    System.out.println("Bike" + bikeId + " reported as stolen and removed from station" + station.getStationId());
                    return;
                }
            }
        }
        System.out.println("Bike with ID" + bikeId + "not found.");
    }
// check for all of the bike 
    public void maintenanceCheck() {
        for (Station station: stations){
            for (Bike bike : station.getAvailableBikes()){
                if (bike.needsMaintenance()){
                    System.out.println("Bike" + bike.getId() + " at station" + station.getStationId() + " needs maintenance.");
                }
            }
        }
    }
}
