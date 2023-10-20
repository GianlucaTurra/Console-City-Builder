package Buildings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class House extends Building{

    // Default upkeep for the one house
    public static final Map<String, Double> DEFAULT_UPKEEP;
    static {
        DEFAULT_UPKEEP = new HashMap<>();
        DEFAULT_UPKEEP.put("Food", 3.0);
        DEFAULT_UPKEEP.put("Wood", 5.0);
        DEFAULT_UPKEEP.put("Water", 2.5);
    }
    public static final Map<String, Double> DEFAULT_PRODUCTION;
    static {
        DEFAULT_PRODUCTION = new HashMap<>();
        DEFAULT_PRODUCTION.put("Food", 0.0);
        DEFAULT_PRODUCTION.put("Wood", 0.0);
        DEFAULT_PRODUCTION.put("Water", 0.0);
    }



    // Generate number of inhabitants per house
    Random inhabitants = new Random();
    public double houseInhabitants = inhabitants.nextInt(10) + 1;



    // Generate house upkeep based on number of inhabitants
    @Override
    public Map<String, Double> returnUpkeep() {
        Map<String, Double> dailyUpkeep = new HashMap<>();
        for (Map.Entry<String, Double> set: DEFAULT_UPKEEP.entrySet()) {
            dailyUpkeep.put(set.getKey(), set.getValue() * upkeepModifier * houseInhabitants);
        }
        return dailyUpkeep;
    }

    @Override
    public Map<String, Double> returnProduction() {
        return null;
    }

    // Constructor
    public House() {
        super(DEFAULT_UPKEEP, DEFAULT_PRODUCTION);
    }
}
