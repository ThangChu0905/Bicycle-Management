// RoundRobinDistributionStrategy.java
import java.util.List;
public class RoundRobinDistributionStrategy implements RedistributionStrategy {
    private ControlCenter controlCenter;
    private int currentIndex = 0;

    public RoundRobinDistributionStrategy(ControlCenter controlCenter) {
        this.controlCenter = controlCenter;
    }

    @Override
    public void redistribute() {
        List<Station> stations = controlCenter.getStations();
        if (stations.size() < 2) return;

        // Lấy station hiện tại và station kế tiếp
        Station fromStation = stations.get(currentIndex);
        currentIndex = (currentIndex + 1) % stations.size();
        Station toStation = stations.get(currentIndex);

        // Thực hiện phân phối
        controlCenter.distributeBikes(fromStation, toStation);
    }
}