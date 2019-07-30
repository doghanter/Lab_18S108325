public class ChessBoard extends Board
{
    public ChessBoard(Player player1, Player player2)
    {
        positions = new Position[8][8];
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                Position p = new Position();
                p.setX(i);
                p.setY(j);
                positions[i][j] = p;
            }
        }

        //player1在下方，执白棋，player2在上方，执黑棋
        //数组的第一维是横坐标，第二维是纵坐标
        //初始化棋盘
        Position position;
        ChessPiece chessPiece;

        //放最下面一行
        chessPiece = new ChessPiece();
        chessPiece.setBelong(player1);
        chessPiece.setType(ChessPieceType.ROCK);
        position = new Position();
        position.setX(0);
        position.setY(0);
        position.setPiece(chessPiece);
        positions[0][0] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player1);
        chessPiece.setType(ChessPieceType.KNIGHT);
        position = new Position();
        position.setX(1);
        position.setY(0);
        position.setPiece(chessPiece);
        positions[1][0] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player1);
        chessPiece.setType(ChessPieceType.BISHOP);
        position = new Position();
        position.setX(2);
        position.setY(0);
        position.setPiece(chessPiece);
        positions[2][0] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player1);
        chessPiece.setType(ChessPieceType.QUEEN);
        position = new Position();
        position.setX(3);
        position.setY(0);
        position.setPiece(chessPiece);
        positions[3][0] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player1);
        chessPiece.setType(ChessPieceType.KING);
        position = new Position();
        position.setX(4);
        position.setY(0);
        position.setPiece(chessPiece);
        positions[4][0] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player1);
        chessPiece.setType(ChessPieceType.BISHOP);
        position = new Position();
        position.setX(5);
        position.setY(0);
        position.setPiece(chessPiece);
        positions[5][0] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player1);
        chessPiece.setType(ChessPieceType.KNIGHT);
        position = new Position();
        position.setX(6);
        position.setY(0);
        position.setPiece(chessPiece);
        positions[6][0] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player1);
        chessPiece.setType(ChessPieceType.ROCK);
        position = new Position();
        position.setX(7);
        position.setY(0);
        position.setPiece(chessPiece);
        positions[7][0] = position;

        //放最上面一行
        chessPiece = new ChessPiece();
        chessPiece.setBelong(player2);
        chessPiece.setType(ChessPieceType.ROCK);
        position = new Position();
        position.setX(0);
        position.setY(7);
        position.setPiece(chessPiece);
        positions[0][7] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player2);
        chessPiece.setType(ChessPieceType.KNIGHT);
        position = new Position();
        position.setX(1);
        position.setY(7);
        position.setPiece(chessPiece);
        positions[1][7] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player2);
        chessPiece.setType(ChessPieceType.BISHOP);
        position = new Position();
        position.setX(2);
        position.setY(7);
        position.setPiece(chessPiece);
        positions[2][7] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player2);
        chessPiece.setType(ChessPieceType.QUEEN);
        position = new Position();
        position.setX(3);
        position.setY(7);
        position.setPiece(chessPiece);
        positions[3][7] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player2);
        chessPiece.setType(ChessPieceType.KING);
        position = new Position();
        position.setX(4);
        position.setY(7);
        position.setPiece(chessPiece);
        positions[4][7] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player2);
        chessPiece.setType(ChessPieceType.BISHOP);
        position = new Position();
        position.setX(5);
        position.setY(7);
        position.setPiece(chessPiece);
        positions[5][7] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player2);
        chessPiece.setType(ChessPieceType.KNIGHT);
        position = new Position();
        position.setX(6);
        position.setY(7);
        position.setPiece(chessPiece);
        positions[6][7] = position;

        chessPiece = new ChessPiece();
        chessPiece.setBelong(player2);
        chessPiece.setType(ChessPieceType.ROCK);
        position = new Position();
        position.setX(7);
        position.setY(7);
        position.setPiece(chessPiece);
        positions[7][7] = position;

        //放第二行
        for (int i = 0; i < 8; i++)
        {
            chessPiece = new ChessPiece();
            chessPiece.setBelong(player1);
            chessPiece.setType(ChessPieceType.PAWN);
            position = new Position();
            position.setX(i);
            position.setY(1);
            position.setPiece(chessPiece);
            positions[i][1] = position;
        }

        //放倒数第二行
        for (int i = 0; i < 8; i++)
        {
            chessPiece = new ChessPiece();
            chessPiece.setBelong(player2);
            chessPiece.setType(ChessPieceType.PAWN);
            position = new Position();
            position.setX(i);
            position.setY(6);
            position.setPiece(chessPiece);
            positions[i][6] = position;
        }

    }
}
