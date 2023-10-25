package Buildings;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
public class House extends Building{

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    public House() {
        super(DEFAULT_UPKEEP, DEFAULT_PRODUCTION);
        this.upkeepModifier = super.getUpkeepModifier();
    }

    // ----------------------------------------------------------------------------------------------------------------
    // Generate base statistics for House object
    // ----------------------------------------------------------------------------------------------------------------
    private double upkeepModifier;
    @Override
    public void changeUpkeepModifier(double mod) {
        super.changeUpkeepModifier(mod);
        this.upkeepModifier = super.getUpkeepModifier();
    }

    private final Random inhabitants = new Random();
    private final double houseInhabitants = inhabitants.nextInt(10) + 1;

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

    @Override
    public Map<String, Double> getDailyUpkeep() {
        Map<String, Double> dailyUpkeep = new HashMap<>();
        DEFAULT_UPKEEP.forEach((key, value) -> dailyUpkeep.put(key, value * getUpkeepModifier() * houseInhabitants));
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

    @Override
    public Map<String, Double> getDailyProduction() {
        return DEFAULT_PRODUCTION;
    }
}
