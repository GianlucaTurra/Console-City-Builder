package Settlements.modifiers;

import lombok.Getter;

public abstract class SettlementModifier {

    protected int turnCounter;

    public SettlementModifier(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public abstract void dailyTurnCount();
    public abstract boolean checkExpiration();
    public abstract void changeTurnCounter(int turnCounter);
}
