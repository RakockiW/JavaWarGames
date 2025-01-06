package actions;

import army.Army;
import army.General;
import army.Soldier;

public class BuySoldierOrder implements Order{
    
    private General general;
    private Army army;
    private Soldier soldier;

    public BuySoldierOrder(General general, Soldier soldier) {
        this.general = general;
        this.army = general.getArmy();
        this.soldier = soldier;
    }
    @Override
    public void execute() {
        int price = soldier.getRank() * 10;
        if (price > general.getGold()) {
            return;
        } else {
            general.payGold(price);
            army.addSoldier(soldier);
        }
    }
}