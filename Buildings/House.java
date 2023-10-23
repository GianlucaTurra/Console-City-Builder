package Buildings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class House extends Building{

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    public House() {
        super(DEFAULT_UPKEEP, DEFAULT_PRODUCTION);
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Generate number of inhabitants per house
    // ----------------------------------------------------------------------------------------------------------------
    private final Random inhabitants = new Random();
    private final double houseInhabitants = inhabitants.nextInt(10) + 1;
    double getHouseInhabitants() {
        return houseInhabitants;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining the default upkeep and encapsulation
    // ----------------------------------------------------------------------------------------------------------------
    private static final Map<String, Double> DEFAULT_UPKEEP;
    static {
        DEFAULT_UPKEEP = new HashMap<>();
        DEFAULT_UPKEEP.put("Food", 3.0);
        DEFAULT_UPKEEP.put("Wood", 5.0);
        DEFAULT_UPKEEP.put("Water", 2.5);
    }

    public static Map<String, Double> getDefaultUpkeep() {
        return DEFAULT_UPKEEP;
    }

    @Override
    public Map<String, Double> getDailyUpkeep() {
        Map<String, Double> dailyUpkeep = new HashMap<>();
        for (Map.Entry<String, Double> set: DEFAULT_UPKEEP.entrySet()) {
            dailyUpkeep.put(set.getKey(), set.getValue() * getUpkeepModifier() * houseInhabitants);
        }
        return dailyUpkeep;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Defining default production and encapsulation
    // ----------------------------------------------------------------------------------------------------------------
    private static final Map<String, Double> DEFAULT_PRODUCTION;
    static {
        DEFAULT_PRODUCTION = new HashMap<>();
        DEFAULT_PRODUCTION.put("Food", 0.0);
        DEFAULT_PRODUCTION.put("Wood", 0.0);
        DEFAULT_PRODUCTION.put("Water", 0.0);
    }

    public static Map<String, Double> getDefaultProduction() {
        return DEFAULT_PRODUCTION;
    }

    @Override
    public Map<String, Double> getDailyProduction() {
        return DEFAULT_PRODUCTION;
    }
}
