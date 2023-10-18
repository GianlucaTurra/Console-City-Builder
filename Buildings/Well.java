package Buildings;

import java.util.HashMap;
import java.util.Map;

public class Well extends Building {

    static {
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
