package Buildings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class House extends Building{

    // Default upkeep for the one house
    public static final Map<String, Double> DEFAULT_UPKEEP = new HashMap<>();;
    public static final Map<String, Double> DEFAULT_PRODUCTION  = new HashMap<>();


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
