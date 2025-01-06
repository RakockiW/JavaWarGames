package test;

import org.junit.Test;

import actions.BuySoldierOrder;
import army.Army;
import army.General;
import army.Soldier;

import static org.junit.Assert.*;

public class BuySoldierOrderTest {
    
    @Test
    public void testExecute() {
        // Utwórz armię
        Army army = new Army();
        
        // Utwórz generała z 100 monet
        General general = new General("John", 100, army);
        
        // Utwórz polecenie kupna
        BuySoldierOrder order = new BuySoldierOrder(general, new Soldier(1));
        
        // Wykonaj polecenie
        order.execute();
        
        // Sprawdź, czy kasa generała została zmniejszona o koszt kupna
        assertEquals(90, general.getGold());
        
        // Sprawdź, czy armia została powiększona o 1 żołnierza
        assertEquals(1, army.getSoldiers().size());
    }
    
    @Test
    public void testExecuteWithNoMoney() {
        // Utwórz armię
        Army army = new Army();
        
        // Utwórz generała bez monet
        General general = new General("John", 0, army);
        
        // Utwórz polecenie kupna
        BuySoldierOrder order = new BuySoldierOrder(general, new Soldier(1));
        
        // Wykonaj polecenie
        order.execute();
        
        // Sprawdź, czy kasa generała nie została zmniejszona
        assertEquals(0, general.getGold());
        
        // Sprawdź, czy armia nie została powiększona
        assertEquals(0, army.getSoldiers().size());
    }
    
}

