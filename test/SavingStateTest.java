package test;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import army.Army;
import army.General;
import army.Major;
import army.Private;
import army.Soldier;
import utils.GeneralStateManager;


public class SavingStateTest {

    private String readTextFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
    
    @Test
    public void testSaveGeneralState() throws IOException {

        
        General general = new General("John", 100, new Army());
        general.getArmy().addSoldier(new Major());
        general.getArmy().addSoldier(new Private());
        Soldier soldier = new Private();
        soldier.gainExperience(2);
        general.getArmy().addSoldier(soldier);
        GeneralStateManager.saveGeneralState(general, "general1.txt");
        
        assertEquals(
            "Name: John\n" +
            "Gold: 100\n" +
            "Army: \n" +
            "  - 4 1\n" +
            "  - 1 1\n" +
            "  - 1 3\n",
            readTextFile("general1.txt")
        );
    }

    @Test
    public void testLoadGeneralState() throws IOException {
        General loadedGeneral = GeneralStateManager.loadGeneralState("general1.txt");
        General expectedGeneral = new General("John", 100, new Army());
        expectedGeneral.getArmy().addSoldier(new Major());
        expectedGeneral.getArmy().addSoldier(new Private());
        Soldier expectedSoldier = new Private();
        expectedSoldier.gainExperience(2);
        expectedGeneral.getArmy().addSoldier(expectedSoldier);

        Army loadedGeneralArmy = loadedGeneral.getArmy();
        Army expectedGeneralArmy = expectedGeneral.getArmy();

        assertAll(
            () -> assertEquals(expectedGeneral.getName(), loadedGeneral.getName()),
            () -> assertEquals(expectedGeneral.getGold(), loadedGeneral.getGold()),
            () -> assertEquals(expectedGeneralArmy.getSoldiers().size(), loadedGeneralArmy.getSoldiers().size()),
            () -> {
                for (int i = 0; i < expectedGeneralArmy.getSoldiers().size(); i++) {
                    Soldier expectedSoldier1 = expectedGeneralArmy.getSoldiers().get(i);
                    Soldier actualSoldier2 = loadedGeneralArmy.getSoldiers().get(i);
                    assertAll(
                        () -> assertEquals(expectedSoldier1.getStrength(), actualSoldier2.getStrength()),
                        () -> assertEquals(expectedSoldier1.getRank(), actualSoldier2.getRank()),
                        () -> assertEquals(expectedSoldier1.getExperience(), actualSoldier2.getExperience())
                    );
                }
            }
        );
    }
}
