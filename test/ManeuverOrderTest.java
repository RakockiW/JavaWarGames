package test;


import org.junit.Test;

import actions.ManeuverOrder;
import army.Army;
import army.Captain;
import army.Corporal;
import army.General;
import army.Private;
import army.Soldier;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ManeuverOrderTest {

    @Test
    public void testExecute() {
        Army army = new Army();
        Soldier soldier1 = new Private();
        Soldier soldier2 = new Private();
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);

        General general = new General("John", 100, army);
        int [] ranksToManeuver = {1};
        ManeuverOrder order = new ManeuverOrder(general, ranksToManeuver);

        order.execute();

        assertAll(
            () -> assertEquals(2, soldier1.getExperience()),
            () -> assertEquals(2, soldier2.getExperience()),
            () -> assertEquals(80, general.getGold())
        );

        
    }

    @Test
    public void testExecuteWithNoSoldiers() {

        Army army = new Army();


        General general = new General("John", 100, army);
        int [] ranksToManeuver = {1};

        ManeuverOrder order = new ManeuverOrder(general, ranksToManeuver);

        order.execute();

        assertEquals(100, general.getGold());
    }

    @Test
    public void testExecuteWithNoMoney() {

        Army army = new Army();
        Soldier soldier1 = new Private();
        Soldier soldier2 = new Private();
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);


        General general = new General("John", 0, army);
        int [] ranksToManeuver = {1};


        ManeuverOrder order = new ManeuverOrder(general, ranksToManeuver);

 
        order.execute();

        assertEquals(1, soldier1.getExperience());
        assertEquals(1, soldier2.getExperience());

    }

    @Test
    public void testExecuteWithDifferentRanks() {
        Army army = new Army();
        Soldier soldier1 = new Private();
        Soldier soldier2 = new Corporal();
        Soldier soldier3 = new Captain();
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);
        army.addSoldier(soldier3);

        General general = new General("John", 100, army);
        int [] ranksToManeuver = {1, 2};

        ManeuverOrder order = new ManeuverOrder(general, ranksToManeuver);

        order.execute();

        assertAll(
            () -> assertEquals(2, soldier1.getExperience()),
            () -> assertEquals(2, soldier2.getExperience()),
            () -> assertEquals(1, soldier3.getExperience()),
            () -> assertEquals(70, general.getGold())
        );
    }
}
