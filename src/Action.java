public class Action
{
    public void Show(Game game)//打印棋盘
    {
        Board board = game.getBoard();
        Position[][] positions = board.positions;
        System.out.println("当前棋盘状况：");
        if (board instanceof ChessBoard)
        {
            for (int i = 7; i >= 0; i--)
            {
                for (int j = 0; j < 8; j++)
                {
                    ChessPiece chessPiece = (ChessPiece) (positions[j][i].getPiece());
                    if (chessPiece == null)
                    {
                        System.out.print("--  ");

                    }
                    else
                    {
                        if (chessPiece.getBelong().equals(game.getPlayer1()))
                        {
                            switch (chessPiece.getType())
                            {
                                case KING:
                                    System.out.print("WK  ");
                                    break;
                                case QUEEN:
                                    System.out.print("WQ  ");
                                    break;
                                case ROCK:
                                    System.out.print("WR  ");
                                    break;
                                case BISHOP:
                                    System.out.print("WB  ");
                                    break;
                                case KNIGHT:
                                    System.out.print("WN  ");
                                    break;
                                case PAWN:
                                    System.out.print("WP  ");
                                    break;
                            }
                        }
                        else if (chessPiece.getBelong().equals(game.getPlayer2()))
                        {
                            switch (chessPiece.getType())
                            {
                                case KING:
                                    System.out.print("BK  ");
                                    break;
                                case QUEEN:
                                    System.out.print("BQ  ");
                                    break;
                                case ROCK:
                                    System.out.print("BR  ");
                                    break;
                                case BISHOP:
                                    System.out.print("BB  ");
                                    break;
                                case KNIGHT:
                                    System.out.print("BN  ");
                                    break;
                                case PAWN:
                                    System.out.print("BP  ");
                                    break;
                            }
                        }
                    }
                }
                System.out.println();
                System.out.println();
            }
        }
        else if (board instanceof GoBoard)
        {
            for (int i = 18; i >= 0; i--)
            {
                for (int j = 0; j < 19; j++)
                {
                    Piece piece = positions[j][i].getPiece();
                    if (piece == null)
                    {
                        System.out.print("- ");

                    }
                    else
                    {
                        if (piece.getBelong().equals(game.getPlayer1()))
                        {
                            System.out.print("W ");
                        }
                        else if (piece.getBelong().equals(game.getPlayer2()))
                        {
                            System.out.print("B ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    //放棋，参数为：当前棋局、棋手、棋子类型、
    public void Put(Game game, Player player, ChessPieceType type, int x, int y)
    {
        Board board = game.getBoard();
        GameType gameType = game.getGameType();
        Position[][] positions = board.positions;
        if (gameType == GameType.CHESS)
        {
            if (x < 0 || x > 7)
            {
                System.out.println("横坐标不合法");
                return;
            }
            if (y < 0 || y > 7)
            {
                System.out.println("纵坐标不合法");
                return;
            }
            if (positions[x][y].getPiece() != null)
            {
                System.out.println("指定位置已有棋子");
                return;
            }
            ChessPiece chessPiece = new ChessPiece();
            chessPiece.setBelong(player);
            chessPiece.setType(type);
            positions[x][y].setPiece(chessPiece);
        }
        else if (gameType == GameType.GO)
        {
            if (x < 0 || x > 18)
            {
                System.out.println("横坐标不合法");
                return;
            }
            if (y < 0 || y > 18)
            {
                System.out.println("纵坐标不合法");
                return;
            }
            if (positions[x][y].getPiece() != null)
            {
                System.out.println("指定位置已有棋子");
                return;
            }
            Piece piece = new Piece();
            piece.setBelong(player);
            positions[x][y].setPiece(piece);
        }
    }


    public void Move(Game game, Player player, int x1, int y1, int x2, int y2)
    {
        Board board = game.getBoard();
        GameType gameType = game.getGameType();
        Position[][] positions = board.positions;
        if (gameType == GameType.CHESS)
        {
            if (x1 < 0 || x1 > 7)
            {
                System.out.println("初始位置横坐标不合法");
                return;
            }
            if (y1 < 0 || y1 > 7)
            {
                System.out.println("初始位置纵坐标不合法");
                return;
            }
            if (x2 < 0 || x2 > 7)
            {
                System.out.println("目的位置横坐标不合法");
                return;
            }
            if (y2 < 0 || y2 > 7)
            {
                System.out.println("目的位置纵坐标不合法");
                return;
            }
            if (x1 == x2 && y1 == y2)
            {
                System.out.println("两个位置相同");
                return;
            }
            if (positions[x1][y1].getPiece() == null)
            {
                System.out.println("初始位置没有棋子");
                return;
            }
            if (positions[x2][y2].getPiece() != null)
            {
                System.out.println("目的位置已有棋子");
                return;
            }
            if (!(positions[x1][y1].getPiece().getBelong().equals(player)))
            {
                System.out.println("初始位置的棋子并非本棋手所有");
                return;
            }

            positions[x2][y2].setPiece(positions[x1][y1].getPiece());
            positions[x1][y1].removePiece();
        }
        else if (gameType == GameType.GO)
        {
            if (x1 < 0 || x1 > 18)
            {
                System.out.println("初始位置横坐标不合法");
                return;
            }
            if (y1 < 0 || y1 > 18)
            {
                System.out.println("初始位置纵坐标不合法");
                return;
            }
            if (x2 < 0 || x2 > 18)
            {
                System.out.println("目的位置横坐标不合法");
                return;
            }
            if (y2 < 0 || y2 > 18)
            {
                System.out.println("目的位置纵坐标不合法");
                return;
            }
            if (x1 == x2 && y1 == y2)
            {
                System.out.println("两个位置相同");
                return;
            }
            if (positions[x1][y1].getPiece() == null)
            {
                System.out.println("初始位置没有棋子");
                return;
            }
            if (positions[x2][y2].getPiece() != null)
            {
                System.out.println("目的位置已有棋子");
                return;
            }
            if (!(positions[x1][y1].getPiece().getBelong().equals(player)))
            {
                System.out.println("初始位置的棋子并非本棋手所有");
                return;
            }

            positions[x2][y2].setPiece(positions[x1][y1].getPiece());
            positions[x1][y1].removePiece();
        }
    }

    //提子，参数为：当前棋局、棋手、横坐标、纵坐标
    public void RemoveGo(Game game, Player player, int x, int y)
    {
        Board board = game.getBoard();
        Position[][] positions = board.positions;

        if (x < 0 || x > 18)
        {
            System.out.println("横坐标不合法");
            return;
        }
        if (y < 0 || y > 18)
        {
            System.out.println("纵坐标不合法");
            return;
        }
        if (positions[x][y].getPiece() == null)
        {
            System.out.println("指定位置没有棋子");
            return;
        }
        if (positions[x][y].getPiece().getBelong().equals(player))
        {
            System.out.println("所提棋子不是对方棋子");
            return;
        }
        positions[x][y].removePiece();
    }

    //吃子，参数为：当前棋局、棋手、横坐标1、纵坐标1、横坐标2、纵坐标2
    public void RemoveChess(Game game, Player player, int x1, int y1, int x2, int y2)
    {
        Board board = game.getBoard();
        Position[][] positions = board.positions;

        if (x1 < 0 || x1 > 7)
        {
            System.out.println("横坐标1不合法");
            return;
        }
        if (y1 < 0 || y1 > 7)
        {
            System.out.println("纵坐标1不合法");
            return;
        }
        if (x2 < 0 || x2 > 7)
        {
            System.out.println("横坐标2不合法");
            return;
        }
        if (y2 < 0 || y2 > 7)
        {
            System.out.println("纵坐标2不合法");
            return;
        }

        if (positions[x1][y1].getPiece() == null)
        {
            System.out.println("第一个位置上没有棋子");
            return;
        }
        if (positions[x2][y2].getPiece() == null)
        {
            System.out.println("第二个位置上没有棋子");
            return;
        }
        if (x1 == x2 && y1 == y2)
        {
            System.out.println("两个位置相同");
            return;
        }
        if (!(positions[x1][y1].getPiece().getBelong().equals(player)))
        {
            System.out.println("第一个位置上的棋子不是自己的棋子");
            return;
        }
        if (positions[x2][y2].getPiece().getBelong().equals(player))
        {
            System.out.println("第二个位置上的棋子不是对方的棋子");
            return;
        }
        positions[x2][y2].setPiece(positions[x1][y1].getPiece());
        positions[x1][y1].removePiece();
    }


    //查看某个位置的占用情况，参数为：当前棋局、横坐标、纵坐标
    public void Look(Game game, int x, int y)
    {
        Board board = game.getBoard();
        GameType gameType = game.getGameType();
        Position[][] positions = board.positions;

        if (gameType == GameType.CHESS)
        {
            if (x < 0 || x > 7)
            {
                System.out.println("横坐标不合法");
                return;
            }
            if (y < 0 || y > 7)
            {
                System.out.println("纵坐标不合法");
                return;
            }
            if (positions[x][y].getPiece() == null)
            {
                System.out.println("指定位置空闲");
                return;
            }
            if (positions[x][y].getPiece().getBelong().equals(game.getPlayer1()))
            {
                ChessPiece chessPiece = (ChessPiece) (positions[x][y].getPiece());
                switch (chessPiece.getType())
                {
                    case KING:
                        System.out.println("指定位置被棋手1的KING占用");
                        break;
                    case QUEEN:
                        System.out.println("指定位置被棋手1的QUEEN占用");
                        break;
                    case ROCK:
                        System.out.println("指定位置被棋手1的ROCK占用");
                        break;
                    case BISHOP:
                        System.out.println("指定位置被棋手1的BISHOP占用");
                        break;
                    case KNIGHT:
                        System.out.println("指定位置被棋手1的KNIGHT占用");
                        break;
                    case PAWN:
                        System.out.println("指定位置被棋手1的PAWN占用");
                        break;
                }
            }
            else if (positions[x][y].getPiece().getBelong().equals(game.getPlayer2()))
            {
                ChessPiece chessPiece = (ChessPiece) (positions[x][y].getPiece());
                switch (chessPiece.getType())
                {
                    case KING:
                        System.out.println("指定位置被棋手2的KING占用");
                        break;
                    case QUEEN:
                        System.out.println("指定位置被棋手2的QUEEN占用");
                        break;
                    case ROCK:
                        System.out.println("指定位置被棋手2的ROCK占用");
                        break;
                    case BISHOP:
                        System.out.println("指定位置被棋手2的BISHOP占用");
                        break;
                    case KNIGHT:
                        System.out.println("指定位置被棋手2的KNIGHT占用");
                        break;
                    case PAWN:
                        System.out.println("指定位置被棋手2的PAWN占用");
                        break;
                }
            }
        }
        else if (gameType == GameType.GO)
        {
            if (x < 0 || x > 18)
            {
                System.out.println("横坐标不合法");
                return;
            }
            if (y < 0 || y > 18)
            {
                System.out.println("纵坐标不合法");
                return;
            }
            if (positions[x][y].getPiece() == null)
            {
                System.out.println("指定位置空闲");
                return;
            }
            if (positions[x][y].getPiece().getBelong().equals(game.getPlayer1()))
            {
                System.out.println("指定位置被棋手1的棋子占用");
            }
            else if (positions[x][y].getPiece().getBelong().equals(game.getPlayer2()))
            {
                System.out.println("指定位置被棋手2的棋子占用");
            }
        }
    }

    public void Count(Game game)
    {
        Board board = game.getBoard();
        GameType gameType = game.getGameType();
        Position[][] positions = board.positions;

        int player1Count = 0;
        int player2Count = 0;

        if (gameType == GameType.CHESS)
        {
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    if (positions[i][j].getPiece() == null)
                    {
                        continue;
                    }
                    if (positions[i][j].getPiece().getBelong().equals(game.getPlayer1()))
                    {
                        player1Count++;
                    }
                    if (positions[i][j].getPiece().getBelong().equals(game.getPlayer2()))
                    {
                        player2Count++;
                    }
                }
            }
        }
        else if (gameType == GameType.GO)
        {
            for (int i = 0; i < 19; i++)
            {
                for (int j = 0; j < 19; j++)
                {
                    if (positions[i][j].getPiece() == null)
                    {
                        continue;
                    }
                    if (positions[i][j].getPiece().getBelong().equals(game.getPlayer1()))
                    {
                        player1Count++;
                    }
                    if (positions[i][j].getPiece().getBelong().equals(game.getPlayer2()))
                    {
                        player2Count++;
                    }
                }
            }
        }
        System.out.println("棋手1的棋子数为" + player1Count + "，棋手2的棋子数为" + player2Count + "。");
    }
}
