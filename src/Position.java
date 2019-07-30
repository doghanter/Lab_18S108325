public class Position
{
    private int X;
    private int Y;
    private Piece piece;

    public void setX(int x)
    {
        X = x;
    }

    public void setY(int y)
    {
        Y = y;
    }

    public Piece getPiece()
    {
        return piece;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }

    public void removePiece()
    {
        piece = null;
    }
}
