package test;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import army.Army;
import army.Corporal;
import army.General;
import army.Private;
import army.Soldier;
import actions.AttackOrder;

public class AttackOrderTest {
    
    @Test
    public void testExecute() {
        Army army1 = new Army();
        Army army2 = new Army();

        Soldier soldier1 = new Corporal();
        Soldier soldier2 = new Private();
        army1.addSoldier(soldier1);
        army2.addSoldier(soldier2);
        
        General general1 = new General("John",100, army1);
        General general2 = new General("Jack", 100, army2);
        
        AttackOrder order = new AttackOrder(general1, general2);
        
        order.execute();
        
        assertEquals(20, general1.getGold() - general2.getGold());
    }
    
    @Test
    public void testExecuteWithEqualStrength() {
        Army army1 = new Army();
        Army army2 = new Army();
        
        Soldier soldier1 = new Private();
        Soldier soldier2 = new Private();
        army1.addSoldier(soldier1);
        army2.addSoldier(soldier2);
        
        General general1 = new General("John", 100, army1);
        General general2 = new General("Jack", 100, army2);
        
        AttackOrder order = new AttackOrder(general1, general2);
        
        order.execute();

        assertEquals(100, general1.getGold());
        assertEquals(100, general2.getGold());
        assertEquals(general1.getArmy().getSoldiers().size(), 0);
        assertEquals(general2.getArmy().getSoldiers().size(), 0);
        int[][] actualResult = {{general1.getGold(), general1.getArmy().getSoldiers().size()}, {general2.getGold(), general2.getArmy().getSoldiers().size()}};
        int[][] expectedResult = {{100, 0}, {100, 0}};
        assertArrayEquals(actualResult, expectedResult);
    }
    
    @Test
    public void testExecuteWithNoSoldiers() {
        Army army1 = new Army();
        Army army2 = new Army();
        
        General general1 = new General("John", 100, army1);
        General general2 = new General("Jack", 100, army2);
        
        AttackOrder order = new AttackOrder(general1, general2);
        
        order.execute();
        

        assertAll(
        () -> assertEquals(100, general1.getGold()),
        () -> assertEquals(100, general2.getGold())
        );
    }
    
    @Test
    public void testExecuteWithNoMoney() {
        Army army1 = new Army();
        Army army2 = new Army();

        Soldier soldier1 = new Private();
        Soldier soldier2 = new Private();
        army1.addSoldier(soldier1);
        army2.addSoldier(soldier2);
        
        General general1 = new General("John", 0, army1);
        General general2 = new General("Jack", 0, army2);
        
        AttackOrder order = new AttackOrder(general1, general2);
        
        order.execute();

        assertAll(
        () -> assertEquals(0, general1.getGold()),
        () -> assertEquals(0, general2.getGold())
        );
    }
}

