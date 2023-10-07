package Buildings;

import java.util.HashMap;
import java.util.Map;

public class House extends Building {

    // Defining DEFAULT_DAILY_UPKEEP as a constant (final)
    /*The Hashmap has to be declared and initialized after or in the same row values are PUT into it using double
    * curly braces and semicolon*/
    public static final HashMap<String, Integer> DEFAULT_DAILY_UPKEEP = new HashMap<>(){{
        DEFAULT_DAILY_UPKEEP.put("Wood", 5);
        DEFAULT_DAILY_UPKEEP.put("Water", 3);
    }};

    // Look at houseUpkeep declaration and initialization for alternative way to put values in it

    // Static field modifier, meaning it can be called without creating a class instance
    static int modifier = 1;

    // HashMap for daily upkeep given house inhabitants
    public int inhabitants;
    public HashMap<String, Integer> houseUpkeep() {
        HashMap<String, Integer> dailyUpkeep = new HashMap<>();
        for (Map.Entry<String, Integer> entry : DEFAULT_DAILY_UPKEEP.entrySet()) {
            dailyUpkeep.put(entry.getKey(), (entry.getValue() * modifier) * inhabitants);
            dailyUpkeep.put(entry.getKey(), (entry.getValue() * modifier) * inhabitants);
        }
        return dailyUpkeep;
    }

    // Building class inherited requires a HashMap constructor, DEFAULT_DAILY_UPKEEP is used for this
    public House() {
        super(DEFAULT_DAILY_UPKEEP);
    }
}
