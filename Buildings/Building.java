package Buildings;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
abstract class Building {

    // ----------------------------------------------------------------------------------------------------------------
    // Default modifiers and abstract methods to change them
    // ----------------------------------------------------------------------------------------------------------------

    private double baseUpkeepModifier = 1;

    public abstract void changeUpkeepModifier(double mod);

    private double baseProductionModifier = 1;
    public abstract void changeProductionModifier(double mod);

    private double baseConstructionModifier = 1;
    public abstract void changeConstructionModifier(double mod);

    // ----------------------------------------------------------------------------------------------------------------
    // Abstract methods to return Maps
    // ----------------------------------------------------------------------------------------------------------------
    public abstract Map<String, Double> getDailyUpkeep();
    public abstract Map<String, Double> getDailyProduction();
    public abstract Map<String, Double> getConstructionCost();

}
