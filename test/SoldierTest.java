package test;

import org.junit.Test;

import static org.junit.Assert.*;

import army.Private;
import army.Soldier;

public class SoldierTest {
    
    @Test
    public void testGetStrength() {
        Soldier soldier = new Private();
        assertEquals(1, soldier.getStrength());
    }
    
    @Test
    public void testGetRank() {
        Soldier soldier = new Private();
        assertEquals(1, soldier.getRank());
    }
    
    @Test
    public void testGetExperience() {
        Soldier soldier = new Private();
        assertEquals(1, soldier.getExperience());
    }
    
    @Test
    public void testGainExperience() {
        Soldier soldier = new Private();
        soldier.gainExperience(1);
        assertEquals(2, soldier.getExperience());
    }
    
    @Test
    public void testLoseExperience() {
        Soldier soldier = new Private();
        soldier.loseExperience();
        assertEquals(0, soldier.getExperience());
    }
    
    @Test
    public void testPromote() {
        Soldier soldier = new Private();
        soldier = soldier.gainExperience(4);
        assertEquals("Corporal", soldier.getClass().getSimpleName());
    }
    
    @Test
    public void testIsDead() {
        Soldier soldier = new Private();
        soldier.loseExperience();
        assertTrue(soldier.isDead());
    }
}

