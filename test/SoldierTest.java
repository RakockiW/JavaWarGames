package test;

import org.junit.Test;

import static org.junit.Assert.*;
import army.Soldier;

public class SoldierTest {
    
    @Test
    public void testGetStrength() {
        Soldier soldier = new Soldier(1);
        assertEquals(1, soldier.getStrength());
    }
    
    @Test
    public void testGetRank() {
        Soldier soldier = new Soldier(1);
        assertEquals(1, soldier.getRank());
    }
    
    @Test
    public void testGetExperience() {
        Soldier soldier = new Soldier(1);
        assertEquals(1, soldier.getExperience());
    }
    
    @Test
    public void testGainExperience() {
        Soldier soldier = new Soldier(1);
        soldier.gainExperience(1);
        assertEquals(2, soldier.getExperience());
    }
    
    @Test
    public void testLoseExperience() {
        Soldier soldier = new Soldier(1);
        soldier.loseExperience();
        assertEquals(0, soldier.getExperience());
    }
    
    @Test
    public void testPromote() {
        Soldier soldier = new Soldier(1);
        for (int i = 0; i < 4; i++) {
            soldier.gainExperience(1);
        }
        assertEquals(2, soldier.getRank());
    }
    
    @Test
    public void testIsDead() {
        Soldier soldier = new Soldier(1);
        assertFalse(soldier.isDead());
        soldier.loseExperience();
        assertTrue(soldier.isDead());
    }
}

