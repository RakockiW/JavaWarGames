package test;

import org.junit.Test;

import actions.ManeuverOrder;
import actions.BuySoldierOrder; 

import static org.junit.Assert.*;
import reports.Secretary;
import army.Army;
import army.Corporal;
import army.General;
import army.Private;

import java.util.ArrayList;
import java.util.List;

public class SecretaryTest {

    @Test
    public void testGenerateReport() {
        Army army1 = new Army();
        Army army2 = new Army();
        
        army1.addSoldier(new Private());
        army1.addSoldier(new Corporal());

        General general1 = new General("John", 100, army1);
        General general2 = new General("Jack", 100, army2);

        ManeuverOrder order1 = new ManeuverOrder(general1, new int[] {1, 2});
        BuySoldierOrder order2 = new BuySoldierOrder(general2, new Private());
        general1.addOrder(order1);
        general2.addOrder(order2);

        Secretary secretary = new Secretary(general1, general2);
        secretary.generateReport();
        
        List<String> reports = secretary.getReports();

        List<String> expectedReports = new ArrayList<String>();

        expectedReports.add("Raport dotyczący armii:\n");
        expectedReports.add("Armia 1:\n  - Liczba żołnierzy: 2\n");
        expectedReports.add("Stopień Szeregowy w armii: 1\n");
        expectedReports.add("Stopień Kapral w armii: 1\n");
        expectedReports.add("Stopień Kapitan w armii: 0\n");
        expectedReports.add("Stopień Major w armii: 0\n");
        expectedReports.add("Generał John zarządza manewry!\n");
        expectedReports.add("Armia 2:\n  - Liczba żołnierzy: 0\n");
        expectedReports.add("Stopień Szeregowy w armii: 0\n");
        expectedReports.add("Stopień Kapral w armii: 0\n");
        expectedReports.add("Stopień Kapitan w armii: 0\n");
        expectedReports.add("Stopień Major w armii: 0\n");
        expectedReports.add("Generał Jack kupuje żołnierzy!\n");
        
        assertArrayEquals(expectedReports.toArray(), reports.toArray());
    }

}
