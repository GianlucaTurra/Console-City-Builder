package Events;

import CustomErrors.RandomEvetOutOfRange;
import Settlements.Settlement;

public class NewDay {

    public static void newDay(Settlement settlement) {
        try {
            RandomEventCaller.callRandomEvent(settlement);
        } catch (RandomEvetOutOfRange e) {
            throw new RuntimeException(e);
        }
        DailyResourcesManagement.settlementDailyProduction(settlement);
        DailyResourcesManagement.settlementDailyUpkeep(settlement);
    }
}