package army;


import java.util.ArrayList;


public class Army {

    private ArrayList<Soldier> soldiers;

    public Army() {
        this.soldiers = new ArrayList<Soldier>();
    }

    public int getStrength() {
        int strength = 0;
        for (Soldier soldier : soldiers) {
            strength += soldier.getStrength();
        }
        return strength;
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public void removeSoldier(Soldier soldier) {
        soldiers.remove(soldier);
    }

    public void removeDeadSoldiers() {
        soldiers.removeIf(soldier -> soldier.isDead());
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }


}
