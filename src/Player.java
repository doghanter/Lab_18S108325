import java.util.ArrayList;

public class Player
{
    private String name;
    private ArrayList<String> moves;

    public void setName(String name)
    {
        this.name = name;
    }

    public Player()
    {
        moves=new ArrayList<>();
    }

    public void RecordStep(String step)
    {
        moves.add(step);
    }

    public ArrayList<String> getMoves()
    {
        return moves;
    }
}
