package actions;

import army.Army;
import army.General;
import army.Soldier;

public class ManeuverOrder implements Order {
    
    private General general;
    private Army army;
    private int[] ranksToManeuver;

    public ManeuverOrder(General general, int[] ranksToManeuver) {
        this.general = general;
        this.army = general.getArmy();
        this.ranksToManeuver = ranksToManeuver;
    }

    @Override
    public void execute() {
        for (Soldier soldier : army.getSoldiers()) {
            if (soldier.getRank() >= ranksToManeuver[0] && soldier.getRank() <= ranksToManeuver[ranksToManeuver.length-1]) {
                int price = soldier.getRank() * 10;
                if (price > general.getGold()) {
                    return;
                } else {
                    general.payGold(price);
                    soldier = soldier.gainExperience(1);
            }
            }
        }
    }
}
