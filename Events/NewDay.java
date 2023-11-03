package Events;

import Buildings.Building;
import CustomErrors.RandomEvetOutOfRange;
import Settlements.Settlement;
import lombok.NonNull;

public class NewDay {

    public static void newDay(@NonNull Settlement settlement) {
        System.out.println("Day: " + GamesEnd.newDayCounter());
        if (GamesEnd.checkGameEnd()) GamesEnd.gamesEnd(settlement);
        settlement.getSettlementModifiers().forEach((k, v) -> v.dailyTurnCount(settlement));
        try {
            RandomEventCaller.callRandomEvent(settlement);
        } catch (RandomEvetOutOfRange e) {
            throw new RuntimeException(e);
        }
        checkAvailableWorkers(settlement);
        DailyResourcesManagement.settlementDailyProduction(settlement);
        DailyResourcesManagement.settlementDailyUpkeep(settlement);
    }

    public static int checkAvailableWorkers(@NonNull Settlement settlement) {
        int availableWorkers = settlement.getSettlementPopulation();
        for (Building building : settlement.getSettlementBuildings()) {
            if (availableWorkers < building.getWorkersNeeded()) {
                building.changeProductionModifier(-1);
            } else {
                availableWorkers -= building.getWorkersNeeded();
            }
        }
        return availableWorkers;
    }
}