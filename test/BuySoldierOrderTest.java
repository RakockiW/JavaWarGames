package test;

import org.junit.Test;

import actions.BuySoldierOrder;
import army.Army;
import army.General;
import army.Private;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuySoldierOrderTest {
    
    @Test
    public void testExecute() {
        Army army = new Army();
        
        General general = new General("John", 100, army);
        
        BuySoldierOrder order = new BuySoldierOrder(general, new Private());
        
        order.execute();
        
        assertAll(
        () -> assertEquals(90, general.getGold()),
        () -> assertEquals(1, army.getSoldiers().size())
        );
        
    }
    
    @Test
    public void testExecuteWithNoMoney() {
        Army army = new Army();
        
        General general = new General("John", 0, army);
        
        BuySoldierOrder order = new BuySoldierOrder(general, new Private());
        
        order.execute();
        
        assertAll(
            () -> assertEquals(0, general.getGold()),
            () -> assertEquals(0, army.getSoldiers().size())
        );
    }
    
}

