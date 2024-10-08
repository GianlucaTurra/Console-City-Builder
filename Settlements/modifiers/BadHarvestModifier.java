package Settlements.modifiers;

import Settlements.Settlement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class BadHarvestModifier extends SettlementModifier{

    public BadHarvestModifier() {
        super("Bad Harvest");
    }
    public BadHarvestModifier(int turnCounter) {
        super(turnCounter, "Bad Harvest");
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
        settlement.changeCropFieldsProduction(0.1);
    }
}
