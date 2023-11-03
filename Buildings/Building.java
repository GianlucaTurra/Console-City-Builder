package Buildings;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Getter @Setter
public abstract class Building {

    // ----------------------------------------------------------------------------------------------------------------
    // BUILDING STATS
    // ----------------------------------------------------------------------------------------------------------------
    protected int workersNeeded = 0;
    protected int buildingSize = 1;
    protected int population = 0;
    public void changeWorkersNeeded(int mod) {
        workersNeeded += mod;
    }
    public void changeBuildingSize(int mod) {
        buildingSize += mod;
    }

    public Building() {
        workersNeeded = 0;
        buildingSize = 1;

    }

    // ----------------------------------------------------------------------------------------------------------------
    // MODIFIERS AND METHODS TO CHANGE THEM
    // ----------------------------------------------------------------------------------------------------------------
    protected double upkeepModifier = 1;
    public void changeUpkeepModifier(double mod) {
        upkeepModifier += mod;
    }

    protected double productionModifier = 1;
    public void changeProductionModifier(double mod) {
        productionModifier += mod;
    }

    protected double constructionModifier = 1;
    public void changeConstructionModifier(double mod) {
        constructionModifier += mod;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // ABSTRACT METHODS TO RETURN MAPS
    // ----------------------------------------------------------------------------------------------------------------
    public abstract Map<String, Double> getDailyUpkeep();
    public abstract Map<String, Double> getDailyProduction();
    public abstract Map<String, Double> getConstructionCost();

}
