package Settlements.modifiers;

import Settlements.Settlement;
import lombok.NonNull;

public class ReallyGoodHarvestModifier extends SettlementModifier {

    public ReallyGoodHarvestModifier(int turnCounter) {
        super(turnCounter, "Really Good Harvest Modifier");
    }

    @Override
    public void dailyTurnCount(Settlement settlement) {
        turnCounter--;
        if (checkExpiration()) {
            revertModifierChanges(settlement);
            settlement.removeModifierFromSettlement(modifierName);
        }
    }

    @Override
    public boolean checkExpiration() {
        return (turnCounter == 0);
    }

    @Override
    public void changeTurnCounter(int turnCounter) {
        this.turnCounter += turnCounter;
    }

    @Override
    public void revertModifierChanges(@NonNull Settlement settlement) {
        settlement.changeCropFieldsProduction(-0.25);
    }
}
