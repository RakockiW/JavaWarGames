package army;

public class Major extends Soldier {
    
    public Major() {
        super(4);
    }

    @Override
    public Soldier nextRank() {
        return this;
    }

}
