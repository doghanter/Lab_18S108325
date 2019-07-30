import java.util.ArrayList;

public class Player
{
    private String name;//玩家的名字
    private ArrayList<String> moves;//玩家的走棋步骤

    public String getName()
    {
        return name;
    }

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
