package Settlements.modifiers;

import Settlements.Settlement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter @EqualsAndHashCode(exclude = {"turnCounter"})
public abstract class SettlementModifier {

    protected int turnCounter;
    protected String modifierName;

    public SettlementModifier(String modifierName) {
        this.modifierName = modifierName;
    }
    public SettlementModifier(int turnCounter, String modifierName) {
        this.turnCounter = turnCounter;
        this.modifierName = modifierName;
    }

    public abstract void dailyTurnCount(Settlement settlement);
    public abstract boolean checkExpiration();
    public abstract void changeTurnCounter(int turnCounter);
    public abstract void revertModifierChanges(Settlement settlement);
}
