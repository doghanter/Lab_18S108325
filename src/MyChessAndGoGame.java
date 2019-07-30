import java.util.ArrayList;
import java.util.Scanner;

public class MyChessAndGoGame
{
    private static Game game;
    private static Action action;

    public static void main(String[] args)
    {
        game = new Game();
        action = new Action();
        System.out.println("Please enter game type:");
        Scanner scanner = new Scanner(System.in);
        String gameType = scanner.nextLine();

        System.out.println("Enter name for player 1:");
        String player1 = scanner.nextLine();
        game.setPlayer1(player1);
        System.out.println("Enter name for player 2:");
        String player2 = scanner.nextLine();
        game.setPlayer2(player2);

        if (gameType.equals("chess"))
        {
            game.setGameType(GameType.CHESS);
        }
        else if (gameType.equals("go"))
        {
            game.setGameType(GameType.GO);
        }

        MAINLOOP:
        while (true)
        {
            System.out.println("Player1:");
            String move1str = scanner.nextLine();
            String[] move1 = move1str.split(" ");

            switch (move1[0])
            {
                case "put":
                    if (game.getGameType() == GameType.CHESS)
                    {
                        if (move1.length != 4)
                        {
                            System.out.println("error.");
                            break;
                        }
                        int x;
                        int y;
                        try
                        {
                            x = Integer.parseInt(move1[2]);
                            y = Integer.parseInt(move1[3]);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error.");
                            break;
                        }
                        switch (move1[1])
                        {
                            case "KING":
                                action.Put(game, game.getPlayer1(), ChessPieceType.KING, x, y);
                                game.getPlayer1().RecordStep("put KING at ("+x+","+y+").");
                                break;
                            case "QUEEN":
                                action.Put(game, game.getPlayer1(), ChessPieceType.QUEEN, x, y);
                                game.getPlayer1().RecordStep("put QUEEN at ("+x+","+y+").");
                                break;
                            case "ROCK":
                                action.Put(game, game.getPlayer1(), ChessPieceType.ROCK, x, y);
                                game.getPlayer1().RecordStep("put ROCK at ("+x+","+y+").");
                                break;
                            case "BISHOP":
                                action.Put(game, game.getPlayer1(), ChessPieceType.BISHOP, x, y);
                                game.getPlayer1().RecordStep("put BISHOP at ("+x+","+y+").");
                                break;
                            case "KNIGHT":
                                action.Put(game, game.getPlayer1(), ChessPieceType.KNIGHT, x, y);
                                game.getPlayer1().RecordStep("put KNIGHT at ("+x+","+y+").");
                                break;
                            case "PAWN":
                                action.Put(game, game.getPlayer1(), ChessPieceType.PAWN, x, y);
                                game.getPlayer1().RecordStep("put PAWN at ("+x+","+y+").");
                                break;
                            default:
                                System.out.println("error.");
                        }
                    }
                    else if (game.getGameType() == GameType.GO)
                    {
                        if (move1.length != 3)
                        {
                            System.out.println("error.");
                            break;
                        }
                        int x;
                        int y;
                        try
                        {
                            x = Integer.parseInt(move1[1]);
                            y = Integer.parseInt(move1[2]);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error.");
                            break;
                        }
                        action.Put(game, game.getPlayer1(), ChessPieceType.OTHER, x, y);
                        game.getPlayer1().RecordStep("put at ("+x+","+y+").");
                    }
                    break;
                case "move":
                    if (game.getGameType() == GameType.GO)
                    {
                        System.out.println("error.");
                        break;
                    }
                    if (move1.length != 5)
                    {
                        System.out.println("error.");
                        break;
                    }
                    int x1;
                    int y1;
                    int x2;
                    int y2;
                    try
                    {
                        x1 = Integer.parseInt(move1[1]);
                        y1 = Integer.parseInt(move1[2]);
                        x2 = Integer.parseInt(move1[3]);
                        y2 = Integer.parseInt(move1[4]);
                    }
                    catch (Exception e)
                    {
                        System.out.println("error.");
                        break;
                    }
                    action.Move(game, game.getPlayer1(), x1, y1, x2, y2);
                    game.getPlayer1().RecordStep("move from ("+x1+","+y1+") to ("+x2+","+y2+").");
                    break;

                case "remove":
                    if (game.getGameType() == GameType.CHESS)
                    {
                        if (move1.length != 5)
                        {
                            System.out.println("error.");
                            break;
                        }
                        try
                        {
                            x1 = Integer.parseInt(move1[1]);
                            y1 = Integer.parseInt(move1[2]);
                            x2 = Integer.parseInt(move1[3]);
                            y2 = Integer.parseInt(move1[4]);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error.");
                            break;
                        }
                        action.RemoveChess(game, game.getPlayer1(), x1, y1, x2, y2);
                        game.getPlayer1().RecordStep("use ("+x1+","+y1+") to replace ("+x2+","+y2+").");
                    }
                    else if (game.getGameType() == GameType.GO)
                    {
                        if (move1.length != 3)
                        {
                            System.out.println("error.");
                            break;
                        }
                        int x;
                        int y;
                        try
                        {
                            x = Integer.parseInt(move1[1]);
                            y = Integer.parseInt(move1[2]);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error.");
                            break;
                        }
                        action.RemoveGo(game, game.getPlayer1(), x, y);
                        game.getPlayer1().RecordStep("remove("+x+","+y+").");
                    }
                    break;
                case "look":
                    if (move1.length != 3)
                    {
                        System.out.println("error.");
                        break;
                    }
                    int x;
                    int y;
                    try
                    {
                        x = Integer.parseInt(move1[1]);
                        y = Integer.parseInt(move1[2]);
                    }
                    catch (Exception e)
                    {
                        System.out.println("error.");
                        break;
                    }
                    action.Look(game, x, y);
                    game.getPlayer1().RecordStep("look ("+x+","+y+").");
                    break;
                case "count":
                    action.Count(game);
                    game.getPlayer1().RecordStep("count the pieces.");
                    break;
                case "end":
                    game.getPlayer1().RecordStep("stop the game.");
                    break MAINLOOP;
                case "pass":
                    game.getPlayer1().RecordStep("give up.");
                    break;
                default:
                    System.out.println("error.");
                    break;
            }

            System.out.println("Player2:");
            String move2str = scanner.nextLine();

            String[] move2 = move2str.split(" ");

            switch (move2[0])
            {
                case "put":
                    if (game.getGameType() == GameType.CHESS)
                    {
                        if (move2.length != 4)
                        {
                            System.out.println("error.");
                            break;
                        }
                        int x;
                        int y;
                        try
                        {
                            x = Integer.parseInt(move2[2]);
                            y = Integer.parseInt(move2[3]);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error.");
                            break;
                        }
                        switch (move2[1])
                        {
                            case "KING":
                                action.Put(game, game.getPlayer2(), ChessPieceType.KING, x, y);
                                game.getPlayer2().RecordStep("put KING at ("+x+","+y+").");
                                break;
                            case "QUEEN":
                                action.Put(game, game.getPlayer2(), ChessPieceType.QUEEN, x, y);
                                game.getPlayer2().RecordStep("put QUEEN at ("+x+","+y+").");
                                break;
                            case "ROCK":
                                action.Put(game, game.getPlayer2(), ChessPieceType.ROCK, x, y);
                                game.getPlayer2().RecordStep("put ROCK at ("+x+","+y+").");
                                break;
                            case "BISHOP":
                                action.Put(game, game.getPlayer2(), ChessPieceType.BISHOP, x, y);
                                game.getPlayer2().RecordStep("put BISHOP at ("+x+","+y+").");
                                break;
                            case "KNIGHT":
                                action.Put(game, game.getPlayer2(), ChessPieceType.KNIGHT, x, y);
                                game.getPlayer2().RecordStep("put KNIGHT at ("+x+","+y+").");
                                break;
                            case "PAWN":
                                action.Put(game, game.getPlayer2(), ChessPieceType.PAWN, x, y);
                                game.getPlayer2().RecordStep("put PAWN at ("+x+","+y+").");
                                break;
                            default:
                                System.out.println("error.");
                        }
                    }
                    else if (game.getGameType() == GameType.GO)
                    {
                        if (move2.length != 3)
                        {
                            System.out.println("error.");
                            break;
                        }
                        int x;
                        int y;
                        try
                        {
                            x = Integer.parseInt(move2[1]);
                            y = Integer.parseInt(move2[2]);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error.");
                            break;
                        }
                        action.Put(game, game.getPlayer2(), ChessPieceType.OTHER, x, y);
                        game.getPlayer2().RecordStep("put at ("+x+","+y+").");
                    }
                    break;
                case "move":
                    if (game.getGameType() == GameType.GO)
                    {
                        System.out.println("error.");
                        break;
                    }
                    if (move2.length != 5)
                    {
                        System.out.println("error.");
                        break;
                    }
                    int x1;
                    int y1;
                    int x2;
                    int y2;
                    try
                    {
                        x1 = Integer.parseInt(move2[1]);
                        y1 = Integer.parseInt(move2[2]);
                        x2 = Integer.parseInt(move2[3]);
                        y2 = Integer.parseInt(move2[4]);
                    }
                    catch (Exception e)
                    {
                        System.out.println("error.");
                        break;
                    }
                    action.Move(game, game.getPlayer2(), x1, y1, x2, y2);
                    game.getPlayer2().RecordStep("move from ("+x1+","+y1+") to ("+x2+","+y2+").");
                    break;

                case "remove":
                    if (game.getGameType() == GameType.CHESS)
                    {
                        if (move2.length != 5)
                        {
                            System.out.println("error.");
                            break;
                        }
                        try
                        {
                            x1 = Integer.parseInt(move2[1]);
                            y1 = Integer.parseInt(move2[2]);
                            x2 = Integer.parseInt(move2[3]);
                            y2 = Integer.parseInt(move2[4]);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error.");
                            break;
                        }
                        action.RemoveChess(game, game.getPlayer2(), x1, y1, x2, y2);
                        game.getPlayer2().RecordStep("use ("+x1+","+y1+") to replace ("+x2+","+y2+").");
                    }
                    else if (game.getGameType() == GameType.GO)
                    {
                        if (move2.length != 3)
                        {
                            System.out.println("error.");
                            break;
                        }
                        int x;
                        int y;
                        try
                        {
                            x = Integer.parseInt(move2[1]);
                            y = Integer.parseInt(move2[2]);
                        }
                        catch (Exception e)
                        {
                            System.out.println("error.");
                            break;
                        }
                        action.RemoveGo(game, game.getPlayer2(), x, y);
                        game.getPlayer2().RecordStep("remove ("+x+","+y+").");
                    }
                    break;
                case "look":
                    if (move2.length != 3)
                    {
                        System.out.println("error.");
                        break;
                    }
                    int x;
                    int y;
                    try
                    {
                        x = Integer.parseInt(move2[1]);
                        y = Integer.parseInt(move2[2]);
                    }
                    catch (Exception e)
                    {
                        System.out.println("error.");
                        break;
                    }
                    action.Look(game, x, y);
                    game.getPlayer2().RecordStep("look ("+x+","+y+").");
                    break;
                case "count":
                    action.Count(game);
                    game.getPlayer2().RecordStep("count the pieces.");
                    break;
                case "end":
                    game.getPlayer2().RecordStep("stop the game.");
                    break MAINLOOP;
                case "pass":
                    game.getPlayer2().RecordStep("give up.");
                    break;
                default:
                    System.out.println("error.");
                    break;
            }
        }
        ArrayList<String> player1Moves=game.getPlayer1().getMoves();
        ArrayList<String> player2Moves=game.getPlayer2().getMoves();

        System.out.println();
        System.out.println("Game over!");
        System.out.println();
        for(String s :player1Moves)
        {
            System.out.println("Player1 "+s);
        }
        System.out.println();
        for(String s :player2Moves)
        {
            System.out.println("Player2 "+s);
        }
    }
}
