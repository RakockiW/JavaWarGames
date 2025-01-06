package army;



public class Soldier {

    private int rank;
    private int experience;

    public Soldier(int rank) {
        this.rank = rank;
        this.experience = 1;
    }

    public int getStrength() {
        return rank * experience;
    }

    public int getRank() {
        return rank;
    }

    public int getExperience() {
        return experience;
    }

    public void gainExperience(int experience) {
        this.experience += experience;
        if (this.experience == this.rank * 5) {
            this.promote();
        }
    }

    public void loseExperience() {
        this.experience--;
    }

    public void promote() {
        this.rank++;
        this.experience = 1;
    }

    public Boolean isDead() {
        if (this.experience == 0) {
            return true;
        }
        return false;
    }

}