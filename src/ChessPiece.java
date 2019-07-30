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
    KING,QUEEN,ROCK,BISHOP,KNIGHT,PAWN,OTHER
}
