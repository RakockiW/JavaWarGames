package army;



public abstract class Soldier {

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

    public abstract Soldier nextRank();

    public Soldier gainExperience(int experience) {
        this.experience += experience;
        if (this.experience == this.rank * 5 && this.rank < 4) {
            return nextRank();
        }
        return this;
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