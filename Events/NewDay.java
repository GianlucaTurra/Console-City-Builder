package Events;

import CustomErrors.RandomEvetOutOfRange;
import Settlements.Settlement;
import lombok.NonNull;

public class NewDay {

    public static void newDay(@NonNull Settlement settlement) {
        settlement.getSettlementModifiers().forEach((k, v) -> v.dailyTurnCount(settlement));
        try {
            RandomEventCaller.callRandomEvent(settlement);
        } catch (RandomEvetOutOfRange e) {
            throw new RuntimeException(e);
        }
        DailyResourcesManagement.settlementDailyProduction(settlement);
        DailyResourcesManagement.settlementDailyUpkeep(settlement);
    }
}