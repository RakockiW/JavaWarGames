package army;

public class Captain extends Soldier {
    
    public Captain() {
        super(3);
    }

    @Override
    public Soldier nextRank() {
        return new Major();
    }
}


