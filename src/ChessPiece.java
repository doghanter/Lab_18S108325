public class ChessPiece extends Piece
{
    private ChessPieceType type;

    public ChessPieceType getType()
    {
        return type;
    }

    public void setType(ChessPieceType type)
    {
        this.type = type;
    }
}

enum ChessPieceType
{
    //王，后，车，象，马，兵，围棋棋子
    KING,QUEEN,ROCK,BISHOP,KNIGHT,PAWN,OTHER
}
