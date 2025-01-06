package test;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;

import army.Army;
import army.General;
import army.Soldier;
import utils.GeneralStateManager;


public class SavingStateTest {
    
    @Test
    public void testExecute() throws IOException {
        General general = new General("John", 100, new Army());
        general.getArmy().addSoldier(new Soldier(4));
        general.getArmy().addSoldier(new Soldier(1));
        Soldier soldier = new Soldier(1);
        soldier.gainExperience(2);
        general.getArmy().addSoldier(soldier);
        GeneralStateManager.saveGeneralState(general);
        
        General loadedGeneral = GeneralStateManager.loadGeneralState();
        assertEquals(general.getName(), loadedGeneral.getName());
        assertEquals(general.getGold(), loadedGeneral.getGold());
        Army loadedGeneralArmy = loadedGeneral.getArmy();
        assertEquals(general.getArmy().getSoldiers().size(), loadedGeneralArmy.getSoldiers().size());
        for (int i = 0; i < general.getArmy().getSoldiers().size(); i++) {
            Soldier soldier1 = general.getArmy().getSoldiers().get(i);
            Soldier soldier2 = loadedGeneralArmy.getSoldiers().get(i);
            assertEquals(soldier1.getStrength(), soldier2.getStrength());
        }
    }
}