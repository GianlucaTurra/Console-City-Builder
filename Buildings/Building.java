package Buildings;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public abstract class Building {

    // ----------------------------------------------------------------------------------------------------------------
    // BUILDING SIZE
    // ----------------------------------------------------------------------------------------------------------------
    protected int buildingSize = 1;
    public void changeBuildingSize(int mod) {
        buildingSize += mod;
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
