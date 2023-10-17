package Buildings;

import java.util.HashMap;
import java.util.Map;

public class CropField extends Building{

    public static final Map<String, Double> DEFAULT_UPKEEP;
    static {
        DEFAULT_UPKEEP = new HashMap<>();
        DEFAULT_UPKEEP.put("Water", 25.0);
    }

    public static final Map<String, Double> DEFAULT_PRODUCTION;
    static {
        DEFAULT_PRODUCTION = new HashMap<>();
        DEFAULT_PRODUCTION.put("Food", 25.0);
    }

    int workersNeeded = 3;

    public CropField() {
        super(DEFAULT_UPKEEP);
    }

}
