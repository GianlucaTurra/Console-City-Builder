package Settlements.modifiers;

import Settlements.Settlement;
import lombok.NonNull;

public class FloodingModifier extends SettlementModifier{

    public FloodingModifier() {
        super("Flooding");
    }

    public FloodingModifier(int turnCounter) {
        super(turnCounter, "Flooding");
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
        return (turnCounter == 0);
    }

    @Override
    public void changeTurnCounter(int turnCounter) {
        this.turnCounter += turnCounter;
    }

    @Override
    public void revertModifierChanges(@NonNull Settlement settlement) {
        settlement.changeCropFieldsProduction(0.75);
    }
}
