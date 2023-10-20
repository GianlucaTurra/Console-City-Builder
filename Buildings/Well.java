package Buildings;

import java.util.HashMap;
import java.util.Map;

public class Well extends Building {

    public static final Map<String, Double> DEFAULT_UPKEEP;
    static {
        DEFAULT_UPKEEP = new HashMap<>();
        DEFAULT_UPKEEP.put("Food", 0.0);
        DEFAULT_UPKEEP.put("Wood", 0.0);
        DEFAULT_UPKEEP.put("Water", 0.0);
    }

    public static Map<String, Double> DEFAULT_PRODUCTION;
    static {
        DEFAULT_PRODUCTION = new HashMap<>();
        DEFAULT_PRODUCTION.put("Food", 0.0);
        DEFAULT_PRODUCTION.put("Wood", 0.0);
        DEFAULT_PRODUCTION.put("Water", 100.0);
    }

    @Override
    public Map<String, Double> returnUpkeep() {
        return null;
    }

    @Override
    public Map<String, Double> returnProduction() {
        Map<String, Double> dailyProduction = new HashMap<>();
        for (Map.Entry<String, Double> set: DEFAULT_PRODUCTION.entrySet()) {
            dailyProduction.put(set.getKey(), set.getValue() * productionModifier);
        }
        return dailyProduction;
    }

    public Well() {
        super(DEFAULT_UPKEEP, DEFAULT_PRODUCTION);
    }
}
