public class Piece//棋子，可以直接表示围棋棋子
{
    private Player belong;//棋子所属的玩家

    public Player getBelong()
    {
        return belong;
    }

    public void setBelong(Player belong)
    {
        this.belong = belong;
    }
}
