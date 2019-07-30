public class Action
{
    public void Put(Game game, Player player, ChessPieceType type, int x, int y)
    {
        Board board = game.getBoard();
        GameType gameType = game.getGameType();
        Position[][] positions = board.positions;
        if (gameType == GameType.CHESS)
        {
            if (x < 0 || x > 7)
            {
                System.out.println("error.");
                return;
            }
            if (y < 0 || y > 7)
            {
                System.out.println("error.");
                return;
            }
            if (positions[x][y].getPiece() != null)
            {
                System.out.println("error.");
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
                System.out.println("error.");
                return;
            }
            if (y < 0 || y > 18)
            {
                System.out.println("error.");
                return;
            }
            if (positions[x][y].getPiece() != null)
            {
                System.out.println("error.");
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
                System.out.println("error.");
                return;
            }
            if (y1 < 0 || y1 > 7)
            {
                System.out.println("error.");
                return;
            }
            if (x2 < 0 || x2 > 7)
            {
                System.out.println("error.");
                return;
            }
            if (y2 < 0 || y2 > 7)
            {
                System.out.println("error.");
                return;
            }
            if (x1 == x2 && y1 == y2)
            {
                System.out.println("error.");
                return;
            }
            if (positions[x1][y1].getPiece() == null)
            {
                System.out.println("error.");
                return;
            }
            if (positions[x2][y2].getPiece() != null)
            {
                System.out.println("error.");
                return;
            }
            if (!(positions[x1][y1].getPiece().getBelong().equals(player)))
            {
                System.out.println("error.");
                return;
            }

            positions[x2][y2].setPiece(positions[x1][y1].getPiece());
            positions[x1][y1].removePiece();
        }
        else if (gameType == GameType.GO)
        {
            if (x1 < 0 || x1 > 18)
            {
                System.out.println("error.");
                return;
            }
            if (y1 < 0 || y1 > 18)
            {
                System.out.println("error.");
                return;
            }
            if (x2 < 0 || x2 > 18)
            {
                System.out.println("error.");
                return;
            }
            if (y2 < 0 || y2 > 18)
            {
                System.out.println("error.");
                return;
            }
            if (x1 == x2 && y1 == y2)
            {
                System.out.println("error.");
                return;
            }
            if (positions[x1][y1].getPiece() == null)
            {
                System.out.println("error.");
                return;
            }
            if (positions[x2][y2].getPiece() != null)
            {
                System.out.println("error.");
                return;
            }
            if (!(positions[x1][y1].getPiece().getBelong().equals(player)))
            {
                System.out.println("error.");
                return;
            }

            positions[x2][y2].setPiece(positions[x1][y1].getPiece());
            positions[x1][y1].removePiece();
        }
    }

    public void RemoveGo(Game game, Player player, int x, int y)
    {
        Board board = game.getBoard();
        Position[][] positions = board.positions;

        if (x < 0 || x > 18)
        {
            System.out.println("error.");
            return;
        }
        if (y < 0 || y > 18)
        {
            System.out.println("error.");
            return;
        }
        if (positions[x][y].getPiece() == null)
        {
            System.out.println("error.");
            return;
        }
        if (positions[x][y].getPiece().getBelong().equals(player))
        {
            System.out.println("error.");
            return;
        }
        positions[x][y].removePiece();
    }

    public void RemoveChess(Game game, Player player, int x1, int y1, int x2, int y2)
    {
        Board board = game.getBoard();
        Position[][] positions = board.positions;

        if (x1 < 0 || x1 > 7)
        {
            System.out.println("error.");
            return;
        }
        if (y1 < 0 || y1 > 7)
        {
            System.out.println("error.");
            return;
        }
        if (x2 < 0 || x2 > 7)
        {
            System.out.println("error.");
            return;
        }
        if (y2 < 0 || y2 > 7)
        {
            System.out.println("error.");
            return;
        }

        if (positions[x1][y1].getPiece() == null)
        {
            System.out.println("error.");
            return;
        }
        if (positions[x2][y2].getPiece() == null)
        {
            System.out.println("error.");
            return;
        }
        if (x1 == x2 && y1 == y2)
        {
            System.out.println("error.");
            return;
        }
        if (!(positions[x1][y1].getPiece().getBelong().equals(player)))
        {
            System.out.println("error.");
            return;
        }
        if (positions[x2][y2].getPiece().getBelong().equals(player))
        {
            System.out.println("error.");
            return;
        }
        positions[x2][y2].setPiece(positions[x1][y1].getPiece());
        positions[x1][y1].removePiece();
    }

    public void Look(Game game, int x, int y)
    {
        Board board = game.getBoard();
        GameType gameType = game.getGameType();
        Position[][] positions = board.positions;

        if (gameType == GameType.CHESS)
        {
            if (x < 0 || x > 7)
            {
                System.out.println("error.");
                return;
            }
            if (y < 0 || y > 7)
            {
                System.out.println("error.");
                return;
            }
            if (positions[x][y].getPiece() == null)
            {
                System.out.println("No piece.");
                return;
            }
            if (positions[x][y].getPiece().getBelong().equals(game.getPlayer1()))
            {
                ChessPiece chessPiece = (ChessPiece) (positions[x][y].getPiece());
                switch (chessPiece.getType())
                {
                    case KING:
                        System.out.println("Player1 KING.");
                        break;
                    case QUEEN:
                        System.out.println("Player1 QUEEN.");
                        break;
                    case ROCK:
                        System.out.println("Player1 ROCK.");
                        break;
                    case BISHOP:
                        System.out.println("Player1 BISHOP.");
                        break;
                    case KNIGHT:
                        System.out.println("Player1 KNIGHT.");
                        break;
                    case PAWN:
                        System.out.println("Player1 PAWN.");
                        break;
                }
            }
            else if (positions[x][y].getPiece().getBelong().equals(game.getPlayer2()))
            {
                ChessPiece chessPiece = (ChessPiece) (positions[x][y].getPiece());
                switch (chessPiece.getType())
                {
                    case KING:
                        System.out.println("Player2 KING.");
                        break;
                    case QUEEN:
                        System.out.println("Player2 QUEEN");
                        break;
                    case ROCK:
                        System.out.println("Player2 ROCK");
                        break;
                    case BISHOP:
                        System.out.println("Player2 BISHOP");
                        break;
                    case KNIGHT:
                        System.out.println("Player2 KNIGHT");
                        break;
                    case PAWN:
                        System.out.println("Player2 PAWN");
                        break;
                }
            }
        }
        else if (gameType == GameType.GO)
        {
            if (x < 0 || x > 18)
            {
                System.out.println("error.");
                return;
            }
            if (y < 0 || y > 18)
            {
                System.out.println("error.");
                return;
            }
            if (positions[x][y].getPiece() == null)
            {
                System.out.println("No piece.");
                return;
            }
            if (positions[x][y].getPiece().getBelong().equals(game.getPlayer1()))
            {
                System.out.println("Player1");
            }
            else if (positions[x][y].getPiece().getBelong().equals(game.getPlayer2()))
            {
                System.out.println("Player2");
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
        System.out.println("Player1:" + player1Count + ", Player2: " + player2Count + ".");
    }
}
