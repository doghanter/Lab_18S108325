public class Game//一盘棋类游戏
{
    private GameType gameType;//棋局的类型，象棋还是围棋
    private Player player1;//玩家1
    private Player player2;//玩家2
    private Board board;//棋盘


    public GameType getGameType()
    {
        return gameType;
    }

    public void setGameType(GameType gameType)
    {
        this.gameType = gameType;

        if (this.gameType == GameType.CHESS)
        {
            board = new ChessBoard(player1, player2);
        }
        else if(this.gameType == GameType.GO)
        {
            board = new GoBoard(player1, player2);
        }
    }

    public Player getPlayer1()
    {
        return player1;
    }

    public void setPlayer1(String player1)
    {
        this.player1 = new Player();
        this.player1.setName(player1);
    }

    public Player getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(String player2)
    {
        this.player2 = new Player();
        this.player2.setName(player2);
    }

    public Board getBoard()
    {
        return board;
    }
}

enum GameType
{
    CHESS, GO
}
