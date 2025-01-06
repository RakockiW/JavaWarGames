package actions;

import java.util.Random;

import army.Army;
import army.General;
import army.Soldier;

public class AttackOrder implements Order{
    private General generalAttacking, generalToAttack;
    private Army armyAttacking, armyToAttack;

    public AttackOrder(General generalAttacking, General generalToAttack) {
        this.generalAttacking = generalAttacking;
        this.generalToAttack = generalToAttack;
        this.armyAttacking = generalAttacking.getArmy();
        this.armyToAttack = generalToAttack.getArmy();
    }

    public void win(General winner, General loser) {
        
        double price = loser.getGold() * 0.1;
        winner.addGold((int) price);
        loser.payGold((int) price);
        
        for (Soldier soldier : winner.getArmy().getSoldiers()) {
            soldier.gainExperience(1);
        }

        for (Soldier soldier : loser.getArmy().getSoldiers()) {
            soldier.loseExperience();
        }

        loser.getArmy().removeDeadSoldiers();
    }

    @Override
    public void execute() {
        int armyAttackingStrength = armyAttacking.getStrength();
        int armyToAttackStrength = armyToAttack.getStrength();
        General winner, loser;

        if (armyAttackingStrength > armyToAttackStrength) {
            
            winner = generalAttacking;
            loser = generalToAttack;
            win(winner, loser);

        } else if (armyToAttackStrength > armyAttackingStrength) {

            winner = generalToAttack;
            loser = generalAttacking;
            win(winner, loser);

        } else {

            Random random = new Random();
            int attackingSoldierIndex = random.nextInt(armyAttacking.getSoldiers().size());
            int toAttackSoldierIndex = random.nextInt(armyToAttack.getSoldiers().size());

            armyAttacking.removeSoldier(armyAttacking.getSoldiers().get(attackingSoldierIndex));
            armyToAttack.removeSoldier(armyToAttack.getSoldiers().get(toAttackSoldierIndex));
        }


    }
}
