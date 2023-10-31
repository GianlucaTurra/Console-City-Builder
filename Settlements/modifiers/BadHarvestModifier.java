package Settlements.modifiers;

import lombok.Getter;

@Getter
public class BadHarvestModifier extends SettlementModifier{

    public BadHarvestModifier(int turnCounter) {
        super(turnCounter);
    }

    @Override
    public void dailyTurnCount() {
        turnCounter--;
    }

    @Override
    public boolean checkExpiration() {
        return turnCounter == 0;
    }

    @Override
    public void changeTurnCounter(int turnCounter) {
        this.turnCounter += turnCounter;
    }
}
