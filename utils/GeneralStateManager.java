package utils;

import java.io.FileWriter;
import java.io.IOException;

import army.Army;
import army.General;
import army.Soldier;

import java.io.FileReader;
import java.io.BufferedReader;

public class GeneralStateManager {
    
    public static void saveGeneralState(General general) throws IOException {
        FileWriter writer = new FileWriter("save.txt");
        writer.write("Name: " + general.getName() + "\n");
        writer.write("Gold: " + general.getGold() + "\n");
        writer.write("Army: \n");
        for (Soldier soldier : general.getArmy().getSoldiers()) {
            writer.write("  - " + soldier.getRank() + " " + soldier.getExperience() + "\n");
        }
        writer.close();
    }
    
    public static General loadGeneralState() throws IOException {
        
        FileReader reader = new FileReader("save.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        boolean armySection = false;

        String name = "";
        int gold = 0;
        Army army = new Army();

        while ((line = bufferedReader.readLine()) != null) {
            if (line.startsWith("Name: ")) {
                name = line.substring(6);
            } else if (line.startsWith("Gold: ")) {
                gold = Integer.parseInt(line.substring(6));
            } else if (line.equals("Army: ")) {
                armySection = true;
            } else if (armySection && line.startsWith("  - ")) {
                String[] parts = line.substring(4).split(" ");
                Soldier soldier = new Soldier(Integer.parseInt(parts[0]));
                int experience = Integer.parseInt(parts[1]) - 1;
                soldier.gainExperience(experience);
                
                army.addSoldier(soldier);
            } 
        }

        General general = new General(name, gold, army);

        bufferedReader.close();
        
        return general;
    }
}