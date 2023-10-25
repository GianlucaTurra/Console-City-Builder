package Events;

import Buildings.CropField;
import Settlements.Village;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

public class RandomEvents {
    public static void tarrasqueAttack(@NonNull Village village) {
        village.reducePopulation(0.95);
    }

    public static void monstersAttack(@NonNull Village village) {
        village.reducePopulation(0.5);
    }

    public static void goblinRaid(@NonNull Village village) {
        village.reducePopulation(0.1);
        village.getResourceMap().replaceAll((k, v) -> v * 0.8);
    }

    public static void flooding(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(-0.75);
        village.reducePopulation(0.25);
        village.getResourceMap().replaceAll((k, v) -> v * 0.90);
    }

    public static void reallyBadHarvest(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(-0.25);
    }

    public static void badHarvest(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(-0.1);
    }

    public static void goodHarvest(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(0.1);
    }

    public static void reallyGoodHarvest(@NonNull Village village) {
        village.changeVillageCropFieldsProduction(0.25);
    }
}
