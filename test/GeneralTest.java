package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import actions.BuySoldierOrder;
import army.Army;
import army.General;
import army.Private;

public class GeneralTest {
    
    @Test
    public void testGetArmy() {
        Army army = new Army();
        General general = new General("John", 100, army);
        
        assertEquals(army, general.getArmy());
    }
    
    @Test
    public void testGetGold() {
        General general = new General("John", 100, new Army());
        
        assertEquals(100, general.getGold());
    }
    
    @Test
    public void testAddGold() {
        General general = new General("John", 100, new Army());
        
        general.addGold(50);
        
        assertEquals(150, general.getGold());
    }
    
    @Test
    public void testPayGold() {
        General general = new General("John", 100, new Army());
        
        general.payGold(50);
        
        assertEquals(50, general.getGold());
    }
    
    @Test
    public void testExecuteOrders() {
        General general = new General("John", 100, new Army());
        BuySoldierOrder order = new BuySoldierOrder(general, new Private());
        general.addOrder(order);
        
        general.executeOrders();
        
        assertEquals(1, general.getArmy().getSoldiers().size());
    }
    
    @Test
    public void testAddOrder() {
        General general = new General("John", 100, new Army());
        BuySoldierOrder order = new BuySoldierOrder(general, new Private());
        general.addOrder(order);
        
        assertEquals(1, general.getOrders().size());
    }
    
    @Test
    public void testRemoveOrder() {
        General general = new General("John", 100, new Army());
        BuySoldierOrder order = new BuySoldierOrder(general, new Private());
        general.addOrder(order);
        general.removeOrder(order);
        
        assertEquals(0, general.getOrders().size());
    }
    
}

