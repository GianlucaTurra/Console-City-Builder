package Buildings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class House extends Building{

    // Default upkeep for the one house
    public static final Map<String, Double> DEFAULT_UPKEEP;
    static {
        DEFAULT_UPKEEP = new HashMap<>();
        DEFAULT_UPKEEP.put("Wood", 2.5);
        DEFAULT_UPKEEP.put("Water", 5.0);
    }

    // Generate number of inhabitants per house
    Random inhabitants = new Random();
    public double houseInhabitants = inhabitants.nextInt(10) + 1;



    // Generate house upkeep based on number of inhabitants
    public Map<String, Double> returnUpkeep() {
        Map<String, Double> dailyUpkeep = new HashMap<String, Double>();
        for (Map.Entry<String, Double> set: DEFAULT_UPKEEP.entrySet()) {
            dailyUpkeep.put(set.getKey(), set.getValue() * upkeepModifier * houseInhabitants);
        }
        return dailyUpkeep;
    }

    // Constructor
    public House() {
        super(DEFAULT_UPKEEP);
    }
}
