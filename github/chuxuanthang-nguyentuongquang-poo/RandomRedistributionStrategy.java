// RandomRedistributionStrategy.java
import java.util.List;
import java.util.Random;

public class RandomRedistributionStrategy implements RedistributionStrategy {
    private ControlCenter controlCenter;
    private Random random = new Random();

    public RandomRedistributionStrategy(ControlCenter controlCenter) {
        this.controlCenter = controlCenter;
    }

    @Override
    public void redistribute() {
        List<Station> stations = controlCenter.getStations();  // cần thêm getter trong ControlCenter
        if (stations.size() < 2) return;  // cần ít nhất 2 station

        // Chọn ngẫu nhiên station nguồn và đích
        int fromIndex = random.nextInt(stations.size());
        int toIndex;
        do {
            toIndex = random.nextInt(stations.size());
        } while (toIndex == fromIndex);

        Station fromStation = stations.get(fromIndex);
        Station toStation = stations.get(toIndex);

        // Thực hiện phân phối
        controlCenter.distributeBikes(fromStation, toStation);
    }
}