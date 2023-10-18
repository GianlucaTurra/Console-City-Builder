package Settlements;

import java.util.HashMap;
import java.util.Map;

public class Village {

    // Base daily production of the village
    public static final Map<String, Double> DAILY_PRODUCTION;
    static {
        DAILY_PRODUCTION = new HashMap<>();
        DAILY_PRODUCTION.put("Food", 200.0);
        DAILY_PRODUCTION.put("Wood", 200.0);
        DAILY_PRODUCTION.put("Water", 200.0);
    }

    // Initial stock of resources
    public static Map<String, Double> resourceMap;
    static {
        resourceMap = new HashMap<>();
        resourceMap.put("Food", 200.0);
        resourceMap.put("Wood", 200.0);
        resourceMap.put("Water", 200.0);
    }

}
