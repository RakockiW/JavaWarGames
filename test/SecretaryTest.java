package test;

import org.junit.Test;

import actions.ManeuverOrder;
import actions.BuySoldierOrder; 

import static org.junit.Assert.*;
import reports.Secretary;
import army.Army;
import army.General;
import army.Soldier;
import java.util.List;

public class SecretaryTest {

    @Test
    public void testGenerateReport() {
        Army army1 = new Army();
        Army army2 = new Army();
        
        army1.addSoldier(new Soldier(1));
        army1.addSoldier(new Soldier(2));

        General general1 = new General("John", 100, army1);
        General general2 = new General("Jack", 100, army2);

        ManeuverOrder order1 = new ManeuverOrder(general1, new int[] {1, 2});
        BuySoldierOrder order2 = new BuySoldierOrder(general2, new Soldier(1));
        general1.addOrder(order1);
        general2.addOrder(order2);

        Secretary secretary = new Secretary(general1, general2);
        secretary.generateReport();
        
        List<String> reports = secretary.getReports();
        
        assertTrue(reports.contains("Armia 1:\n  - Liczba żołnierzy: 2\n"));
        assertTrue(reports.contains("Stopień Szeregowy w armii: 1\n"));
        assertTrue(reports.contains("Stopień Kapral w armii: 1\n"));
        assertTrue(reports.contains("Stopień Kapitan w armii: 0\n"));
        assertTrue(reports.contains("Stopień Major w armii: 0\n"));
        assertTrue(reports.contains("Generał John zarządza manewry!\n"));

        assertTrue(reports.contains("Armia 2:\n  - Liczba żołnierzy: 0\n"));
        assertTrue(reports.contains("Stopień Szeregowy w armii: 0\n"));
        assertTrue(reports.contains("Stopień Kapral w armii: 0\n"));
        assertTrue(reports.contains("Stopień Kapitan w armii: 0\n"));
        assertTrue(reports.contains("Stopień Major w armii: 0\n"));
        assertTrue(reports.contains("Generał Jack kupuje żołnierzy!\n"));
    }

    @Test
    public void testGetRanksReport() {
        Army army1 = new Army();
        Army army2 = new Army();
        
        army1.addSoldier(new Soldier(1));
        army1.addSoldier(new Soldier(2));

        General general1 = new General("John", 100, army1);
        General general2 = new General("Jack", 100, army2);
        
        Secretary secretary = new Secretary(general1, general2);
        String ranksReport = secretary.getRanksReport(army1);
        
        assertTrue(ranksReport.contains("Stopień Szeregowy w armii: 1\n"));
        assertTrue(ranksReport.contains("Stopień Kapral w armii: 1\n"));
    }


}
