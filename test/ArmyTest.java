package test;

import org.junit.Test;
import static org.junit.Assert.*;
import army.Army;
import army.Soldier;

public class ArmyTest {

    @Test
    public void testAddSoldier() {
        Army army = new Army();
        Soldier soldier = new Soldier(1);
        army.addSoldier(soldier);
        assertEquals(1, army.getSoldiers().size());
    }

    @Test
    public void testRemoveSoldier() {
        Army army = new Army();
        Soldier soldier = new Soldier(1);
        army.addSoldier(soldier);
        army.removeSoldier(soldier);
        assertEquals(0, army.getSoldiers().size());
    }

    @Test
    public void testRemoveDeadSoldiers() {
        Army army = new Army();
        Soldier soldier1 = new Soldier(1);
        Soldier soldier2 = new Soldier(1);
        soldier1.loseExperience();  // Assuming this would make the soldier dead
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);
        army.removeDeadSoldiers();
        assertEquals(1, army.getSoldiers().size());
    }

    @Test
    public void testGetStrength() {
        Army army = new Army();
        Soldier soldier1 = new Soldier(1);
        Soldier soldier2 = new Soldier(2);
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);
        int expectedStrength = soldier1.getStrength() + soldier2.getStrength();
        assertEquals(expectedStrength, army.getStrength());
    }
}

