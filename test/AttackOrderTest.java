package test;

import org.junit.Test;

import static org.junit.Assert.*;

import army.Army;
import army.General;
import army.Soldier;
import actions.AttackOrder;

public class AttackOrderTest {
    
    @Test
    public void testExecute() {
        // Utwórz dwie armie
        Army army1 = new Army();
        Army army2 = new Army();

        Soldier soldier1 = new Soldier(2);
        Soldier soldier2 = new Soldier(1);
        army1.addSoldier(soldier1);
        army2.addSoldier(soldier2);
        
        // Utwórz 2 generałów
        General general1 = new General("John",100, army1);
        General general2 = new General("Jack", 100, army2);
        
        // Utwórz polecenie ataku
        AttackOrder order = new AttackOrder(general1, general2);
        
        // Wykonaj polecenie ataku
        order.execute();
        
        // Sprawdź, czy został wybrany zwycięzca i czy został nagrodzony
        assertEquals(110, general1.getGold());
        assertEquals(90, general2.getGold());
    }
    
    @Test
    public void testExecuteWithEqualStrength() {
        // Utwórz dwie armie z równą siłą
        Army army1 = new Army();
        Army army2 = new Army();
        
        Soldier soldier1 = new Soldier(1);
        Soldier soldier2 = new Soldier(1);
        army1.addSoldier(soldier1);
        army2.addSoldier(soldier2);
        
        // Utwórz 2 generałów
        General general1 = new General("John", 100, army1);
        General general2 = new General("Jack", 100, army2);
        
        // Utwórz polecenie ataku
        AttackOrder order = new AttackOrder(general1, general2);
        
        // Wykonaj polecenie ataku
        order.execute();
        
        // Sprawdź, czy został wybrany zwycięzca i czy został nagrodzony
        assertEquals(100, general1.getGold());
        assertEquals(100, general2.getGold());
        assertEquals(general1.getArmy().getSoldiers().size(), 0);
        assertEquals(general2.getArmy().getSoldiers().size(), 0);
    }
    
    @Test
    public void testExecuteWithNoSoldiers() {
        // Utwórz dwie armie bez żołnierzy
        Army army1 = new Army();
        Army army2 = new Army();
        
        // Utwórz 2 generałów
        General general1 = new General("John", 100, army1);
        General general2 = new General("Jack", 100, army2);
        
        // Utwórz polecenie ataku
        AttackOrder order = new AttackOrder(general1, general2);
        
        // Wykonaj polecenie ataku
        order.execute();
        
        // Sprawdź, czy został wybrany zwycięzca i czy został nagrodzony
        assertEquals(110, general1.getGold());
        assertEquals(90, general2.getGold());
    }
    
    @Test
    public void testExecuteWithNoMoney() {
        // Utwórz dwie armie
        Army army1 = new Army();
        Army army2 = new Army();

        Soldier soldier1 = new Soldier(1);
        Soldier soldier2 = new Soldier(2);
        army1.addSoldier(soldier1);
        army2.addSoldier(soldier2);
        
        // Utwórz 2 generałów z 0 monet
        General general1 = new General("John", 0, army1);
        General general2 = new General("Jack", 0, army2);
        
        // Utwórz polecenie ataku
        AttackOrder order = new AttackOrder(general1, general2);
        
        // Wykonaj polecenie ataku
        order.execute();
        
        // Sprawdź, czy został wybrany zwycięzca i czy został nagrodzony
        assertEquals(0, general1.getGold());
        assertEquals(0, general2.getGold());
    }
}

