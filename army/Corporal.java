package army;

public class Corporal extends Soldier {
    
    public Corporal() {
        super(2);
    }
    
    @Override
    public Soldier nextRank() {
        return this;
    }
}
