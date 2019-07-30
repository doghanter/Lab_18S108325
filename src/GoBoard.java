public class GoBoard extends Board
{
    public GoBoard(Player player1, Player player2)
    {
        positions = new Position[19][19];
        for (int i = 0; i < 19; i++)
        {
            for (int j = 0; j < 19; j++)
            {
                Position p = new Position();
                p.setX(i);
                p.setY(j);
                positions[i][j] = p;
            }
        }
    }

}
