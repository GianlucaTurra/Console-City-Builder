package Settlements.modifiers;

import Settlements.Settlement;
import lombok.NonNull;

public class ReallyBadHarvestModifier extends SettlementModifier {

    public ReallyBadHarvestModifier() {
        super("Really Bad Harvest");
    }

    public ReallyBadHarvestModifier(int turnCounter) {
        super(turnCounter, "Really Bad Harvest");
    }

    @Override
    public void dailyTurnCount(Settlement settlement) {
        turnCounter--;
        if (checkExpiration()) {
            settlement.removeModifierFromSettlement(modifierName);
            revertModifierChanges(settlement);
        }
    }

    @Override
    public boolean checkExpiration() {
        return turnCounter == 0;
    }

    @Override
    public void changeTurnCounter(int turnCounter) {
        this.turnCounter += turnCounter;
    }

    @Override
    public void revertModifierChanges(@NonNull Settlement settlement) {
        settlement.changeCropFieldsProduction(0.25);
    }
}
