package Events;

import Buildings.Building;
import Settlements.Settlement;
import lombok.NonNull;

import java.util.Map;

public class DailyResourcesManagement {

    protected static void buildingDailyUpkeep(@NonNull Settlement settlement, Building building) {
        Map<String, Double> settlementResources = settlement.getResourceMap();
        settlementResources.forEach((k, v) -> settlementResources.put(k, v - building.getDailyUpkeep().get(k)));
    }

    protected static void settlementDailyUpkeep(@NonNull Settlement settlement) {
        settlement.getSettlementBuildings().forEach(building -> buildingDailyUpkeep(settlement, building));
    }

    protected static void buildingDailyProduction(@NonNull Settlement settlement, Building building) {
        Map<String, Double> settlementResources = settlement.getResourceMap();
        settlementResources.forEach((k, v) -> settlementResources.put(k, v + building.getDailyProduction().get(k)));
    }

    protected static void settlementDailyProduction(@NonNull Settlement settlement) {
        settlement.getSettlementBuildings().forEach(building -> buildingDailyProduction(settlement, building));
        Map<String, Double> settlementResources = settlement.getResourceMap();
        settlementResources.forEach((k, v) -> settlementResources.put(k, v + settlement.getDailyProduction().get(k)));
    }

}
