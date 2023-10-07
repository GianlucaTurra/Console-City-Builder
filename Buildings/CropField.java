package Buildings;

import java.util.HashMap;

public class CropField extends Building {

    public static final HashMap<String, Double> DEFAULT_DAILY_UPKEEP = new HashMap<>() {{
       DEFAULT_DAILY_UPKEEP.put("Water", 20.0);
    }};

    public static HashMap<String, Double> dailyProduction = new HashMap<>() {{
       dailyProduction.put("Grain", 10.0);
    }};

    public CropField() {
        super(DEFAULT_DAILY_UPKEEP);
    }
}
