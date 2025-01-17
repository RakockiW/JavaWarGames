package army;

public class Private extends Soldier {
    
    
    public Private() {
        super(1);
    }
    
    @Override
    public Soldier nextRank() {
        return new Corporal();
    }
}
