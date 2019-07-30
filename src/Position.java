public class Position//棋盘上的位置
{
    private int X;//格子的横坐标
    private int Y;//格子的纵坐标
    private Piece piece;//这个位置上放置的棋子

    public int getX()
    {
        return X;
    }

    public void setX(int x)
    {
        X = x;
    }

    public int getY()
    {
        return Y;
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

    public void removePiece()//清除此位置的棋子
    {
        piece = null;
    }

    public boolean isEmpty()//判断此位置是否没有棋子
    {
        if (piece == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
