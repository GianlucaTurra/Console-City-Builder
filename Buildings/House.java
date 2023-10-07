package Buildings;

import java.util.HashMap;
import java.util.Map;

public class House extends Building {

    // Defining DEFAULT_DAILY_UPKEEP as a constant (final)
    /*The Hashmap has to be declared and initialized after or in the same row values are PUT into it using double
    * curly braces and semicolon*/
    public static final HashMap<String, Double> DEFAULT_DAILY_UPKEEP = new HashMap<>(){{
        DEFAULT_DAILY_UPKEEP.put("Wood", 5.0);
        DEFAULT_DAILY_UPKEEP.put("Water", 3.0);
    }};

    // Look at houseUpkeep declaration and initialization for alternative way to put values in it

    // HashMap for daily upkeep given house inhabitants
    public int inhabitants;
    public HashMap<String, Double> houseUpkeep() {
        HashMap<String, Double> dailyUpkeep = new HashMap<>();
        for (Map.Entry<String, Double> entry : DEFAULT_DAILY_UPKEEP.entrySet()) {
            dailyUpkeep.put(entry.getKey(), (entry.getValue() * upkeepModifier) * inhabitants);
            dailyUpkeep.put(entry.getKey(), (entry.getValue() * upkeepModifier) * inhabitants);
        }
        return dailyUpkeep;
    }

    // Building class inherited requires a HashMap constructor, DEFAULT_DAILY_UPKEEP is used for this
    public House() {
        super(DEFAULT_DAILY_UPKEEP);
    }
}
