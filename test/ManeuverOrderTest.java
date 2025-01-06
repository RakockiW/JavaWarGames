package test;


import org.junit.Test;

import actions.ManeuverOrder;
import army.Army;
import army.General;
import army.Soldier;

import static org.junit.Assert.*;

public class ManeuverOrderTest {

    @Test
    public void testExecute() {
        // Utwórz armię z 2 żołnierzami
        Army army = new Army();
        Soldier soldier1 = new Soldier(1);
        Soldier soldier2 = new Soldier(1);
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);

        // Utwórz generała z 100 monet
        General general = new General("John", 100, army);
        int [] ranksToManeuver = {1};
        // Utwórz polecenie manewru
        ManeuverOrder order = new ManeuverOrder(general, ranksToManeuver);

        // Wykonaj polecenie manewru
        order.execute();

        // Sprawdź, czy doświadczenie żołnierzy zostało zwiększone o 1
        assertEquals(2, soldier1.getExperience());
        assertEquals(2, soldier2.getExperience());

        // Sprawdź, czy kasa generała została zmniejszona o koszt manewru
        assertEquals(80, general.getGold());
    }

    @Test
    public void testExecuteWithNoSoldiers() {
        // Utwórz armię bez żołnierzy
        Army army = new Army();

        // Utwórz generała z 100 monet
        General general = new General("John", 100, army);
        int [] ranksToManeuver = {1};

        // Utwórz polecenie manewru
        ManeuverOrder order = new ManeuverOrder(general, ranksToManeuver);

        // Wykonaj polecenie manewru
        order.execute();

        // Sprawdź, czy kasa generała nie została zmniejszona
        assertEquals(100, general.getGold());
    }

    @Test
    public void testExecuteWithNoMoney() {
        // Utwórz armię z 2 żołnierzami
        Army army = new Army();
        Soldier soldier1 = new Soldier(1);
        Soldier soldier2 = new Soldier(1);
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);

        // Utwórz generała bez monet
        General general = new General("John", 0, army);
        int [] ranksToManeuver = {1};

        // Utwórz polecenie manewru
        ManeuverOrder order = new ManeuverOrder(general, ranksToManeuver);

        // Wykonaj polecenie manewru
        order.execute();

        // Sprawdź, czy doświadczenie żołnierzy nie zostało zwiększone
        assertEquals(1, soldier1.getExperience());
        assertEquals(1, soldier2.getExperience());

    }

    @Test
    public void testExecuteWithDifferentRanks() {
        // Utwórz armię z 3 żołnierzami i różnymi stopniami
        Army army = new Army();
        Soldier soldier1 = new Soldier(1);
        Soldier soldier2 = new Soldier(2);
        Soldier soldier3 = new Soldier(3);
        army.addSoldier(soldier1);
        army.addSoldier(soldier2);
        army.addSoldier(soldier3);

        // Utwórz generała z 100 monet
        General general = new General("John", 100, army);
        int [] ranksToManeuver = {1, 2};
        // Utwórz polecenie manewru
        ManeuverOrder order = new ManeuverOrder(general, ranksToManeuver);

        // Wykonaj polecenie manewru
        order.execute();

        // Sprawdź, czy doświadczenie żołnierzy zostało zwiększone o 1
        assertEquals(2, soldier1.getExperience());
        assertEquals(2, soldier2.getExperience());
        assertEquals(1, soldier3.getExperience());

        // Sprawdź, czy kasa generała została zmniejszona o koszt manewru
        assertEquals(70, general.getGold());
    }
}
