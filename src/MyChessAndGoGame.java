import java.util.ArrayList;
import java.util.Scanner;

public class MyChessAndGoGame
{
    private static Game game;
    private static Action action;

    public static void main(String[] args)
    {
        //输入棋局类型
        game = new Game();
        action = new Action();
        System.out.println("请输入要创建的棋局类型，chess代表国际象棋，go代表围棋。");
        Scanner scanner = new Scanner(System.in);
        String gameType = scanner.nextLine();
        if (gameType.equals("chess"))
        {
            System.out.println("已经选择创建一盘国际象棋。");
        }
        else if (gameType.equals("go"))
        {
            System.out.println("已经选择创建一盘围棋。");
        }
        else
        {
            System.out.println("棋局类型输入错误，程序即将退出。");
            System.exit(1);
        }

        //输入两个玩家的名字
        System.out.println("请输入第一个玩家的名字。");
        String player1 = scanner.nextLine();
        game.setPlayer1(player1);
        System.out.println("请输入第二个玩家的名字。");
        String player2 = scanner.nextLine();
        game.setPlayer2(player2);

        //创建棋局
        if (gameType.equals("chess"))
        {
            game.setGameType(GameType.CHESS);
        }
        else if (gameType.equals("go"))
        {
            game.setGameType(GameType.GO);
        }
        action.Show(game);
        System.out.println();
        System.out.println("动作说明：put表示放棋，move表示移动棋子，remove表示提子或吃子，look表示查询位置的占用情况，count表示计算两个玩家分别在棋盘上的棋子总数，end表示结束，pass表示跳过");
        System.out.println("put命令格式为（围棋中不指定棋子类型）：put [棋子类型] [横坐标] [纵坐标]");
        System.out.println("move命令格式为：move [初始位置横坐标] [初始位置纵坐标] [目的位置横坐标] [目的位置纵坐标]");
        System.out.println("remove命令（提子）格式为：remove [横坐标] [纵坐标]");
        System.out.println("remove命令（吃子）格式为：remove [横坐标1] [纵坐标1] [横坐标2] [纵坐标2]");
        System.out.println("look命令格式为：look [横坐标] [纵坐标]");
        System.out.println("count命令、end命令和pass命令没有参数");
        System.out.println();

        //玩家双方交替采取行动
        MAINLOOP:
        while (true)
        {
            System.out.println("请玩家1输入下一步的动作");
            String move1str = scanner.nextLine();
            String[] move1 = move1str.split(" ");

            switch (move1[0])
            {
                case "show"://打印棋盘，用于调试
                    action.Show(game);
                    break;
                case "put":
                    if (game.getGameType() == GameType.CHESS)
                    {
                        if (move1.length != 4)
                        {
                            System.out.println("参数个数错误，应为4个。");
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
                            System.out.println("横坐标或纵坐标不是数字。");
                            break;
                        }
                        switch (move1[1])
                        {
                            case "KING":
                                action.Put(game, game.getPlayer1(), ChessPieceType.KING, x, y);
                                game.getPlayer1().RecordStep("在("+x+","+y+")处放置KING棋子。");
                                break;
                            case "QUEEN":
                                action.Put(game, game.getPlayer1(), ChessPieceType.QUEEN, x, y);
                                game.getPlayer1().RecordStep("在("+x+","+y+")处放置QUEEN棋子。");
                                break;
                            case "ROCK":
                                action.Put(game, game.getPlayer1(), ChessPieceType.ROCK, x, y);
                                game.getPlayer1().RecordStep("在("+x+","+y+")处放置ROCK棋子。");
                                break;
                            case "BISHOP":
                                action.Put(game, game.getPlayer1(), ChessPieceType.BISHOP, x, y);
                                game.getPlayer1().RecordStep("在("+x+","+y+")处放置BISHOP棋子。");
                                break;
                            case "KNIGHT":
                                action.Put(game, game.getPlayer1(), ChessPieceType.KNIGHT, x, y);
                                game.getPlayer1().RecordStep("在("+x+","+y+")处放置KNIGHT棋子。");
                                break;
                            case "PAWN":
                                action.Put(game, game.getPlayer1(), ChessPieceType.PAWN, x, y);
                                game.getPlayer1().RecordStep("在("+x+","+y+")处放置PAWN棋子。");
                                break;
                            default:
                                System.out.println("棋子类型错误。");
                        }
                    }
                    else if (game.getGameType() == GameType.GO)
                    {
                        if (move1.length != 3)
                        {
                            System.out.println("参数个数错误，应为3个。");
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
                            System.out.println("横坐标或纵坐标不是数字。");
                            break;
                        }
                        action.Put(game, game.getPlayer1(), ChessPieceType.OTHER, x, y);
                        game.getPlayer1().RecordStep("在("+x+","+y+")处放置棋子。");
                    }
                    action.Show(game);
                    break;
                case "move":
                    if (game.getGameType() == GameType.GO)
                    {
                        System.out.println("围棋不允许移动棋子");
                        break;
                    }
                    if (move1.length != 5)
                    {
                        System.out.println("参数个数错误，应为5个。");
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
                        System.out.println("横坐标或纵坐标不是数字。");
                        break;
                    }
                    action.Move(game, game.getPlayer1(), x1, y1, x2, y2);
                    game.getPlayer1().RecordStep("将一个棋子从("+x1+","+y1+")移动到("+x2+","+y2+")。");
                    action.Show(game);
                    break;

                case "remove":
                    if (game.getGameType() == GameType.CHESS)
                    {
                        if (move1.length != 5)
                        {
                            System.out.println("参数个数错误，应为5个。");
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
                            System.out.println("横坐标或纵坐标不是数字。");
                            break;
                        }
                        action.RemoveChess(game, game.getPlayer1(), x1, y1, x2, y2);
                        game.getPlayer1().RecordStep("用("+x1+","+y1+")的棋子吃掉了("+x2+","+y2+")的棋子。");
                    }
                    else if (game.getGameType() == GameType.GO)
                    {
                        if (move1.length != 3)
                        {
                            System.out.println("参数个数错误，应为3个。");
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
                            System.out.println("横坐标或纵坐标不是数字。");
                            break;
                        }
                        action.RemoveGo(game, game.getPlayer1(), x, y);
                        game.getPlayer1().RecordStep("提子("+x+","+y+")。");
                    }
                    action.Show(game);
                    break;
                case "look":
                    if (move1.length != 3)
                    {
                        System.out.println("参数个数错误，应为3个。");
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
                        System.out.println("横坐标或纵坐标不是数字。");
                        break;
                    }
                    action.Look(game, x, y);
                    game.getPlayer1().RecordStep("查看了("+x+","+y+")的情况。");
                    break;
                case "count":
                    action.Count(game);
                    game.getPlayer1().RecordStep("计算了棋子总数。");
                    break;
                case "end":
                    game.getPlayer1().RecordStep("结束了游戏。");
                    break MAINLOOP;
                case "pass":
                    game.getPlayer1().RecordStep("放弃了本次采取行动的权利。");
                    break;
                default:
                    System.out.println("无效命令。");
                    break;
            }

            System.out.println("请玩家2输入下一步的动作");
            String move2str = scanner.nextLine();

            String[] move2 = move2str.split(" ");

            switch (move2[0])
            {
                case "show"://打印棋盘，用于调试
                    action.Show(game);
                    break;
                case "put":
                    if (game.getGameType() == GameType.CHESS)
                    {
                        if (move2.length != 4)
                        {
                            System.out.println("参数个数错误，应为4个。");
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
                            System.out.println("横坐标或纵坐标不是数字。");
                            break;
                        }
                        switch (move2[1])
                        {
                            case "KING":
                                action.Put(game, game.getPlayer2(), ChessPieceType.KING, x, y);
                                game.getPlayer2().RecordStep("在("+x+","+y+")处放置KING棋子。");
                                break;
                            case "QUEEN":
                                action.Put(game, game.getPlayer2(), ChessPieceType.QUEEN, x, y);
                                game.getPlayer2().RecordStep("在("+x+","+y+")处放置QUEEN棋子。");
                                break;
                            case "ROCK":
                                action.Put(game, game.getPlayer2(), ChessPieceType.ROCK, x, y);
                                game.getPlayer2().RecordStep("在("+x+","+y+")处放置ROCK棋子。");
                                break;
                            case "BISHOP":
                                action.Put(game, game.getPlayer2(), ChessPieceType.BISHOP, x, y);
                                game.getPlayer2().RecordStep("在("+x+","+y+")处放置BISHOP棋子。");
                                break;
                            case "KNIGHT":
                                action.Put(game, game.getPlayer2(), ChessPieceType.KNIGHT, x, y);
                                game.getPlayer2().RecordStep("在("+x+","+y+")处放置KNIGHT棋子。");
                                break;
                            case "PAWN":
                                action.Put(game, game.getPlayer2(), ChessPieceType.PAWN, x, y);
                                game.getPlayer2().RecordStep("在("+x+","+y+")处放置PAWN棋子。");
                                break;
                            default:
                                System.out.println("棋子类型错误。");
                        }
                    }
                    else if (game.getGameType() == GameType.GO)
                    {
                        if (move2.length != 3)
                        {
                            System.out.println("参数个数错误，应为3个。");
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
                            System.out.println("横坐标或纵坐标不是数字。");
                            break;
                        }
                        action.Put(game, game.getPlayer2(), ChessPieceType.OTHER, x, y);
                        game.getPlayer2().RecordStep("在("+x+","+y+")处放置棋子。");
                    }
                    action.Show(game);
                    break;
                case "move":
                    if (game.getGameType() == GameType.GO)
                    {
                        System.out.println("围棋不允许移动棋子");
                        break;
                    }
                    if (move2.length != 5)
                    {
                        System.out.println("参数个数错误，应为5个。");
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
                        System.out.println("横坐标或纵坐标不是数字。");
                        break;
                    }
                    action.Move(game, game.getPlayer2(), x1, y1, x2, y2);
                    game.getPlayer2().RecordStep("将一个棋子从("+x1+","+y1+")移动到("+x2+","+y2+")。");
                    action.Show(game);
                    break;

                case "remove":
                    if (game.getGameType() == GameType.CHESS)
                    {
                        if (move2.length != 5)
                        {
                            System.out.println("参数个数错误，应为5个。");
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
                            System.out.println("横坐标或纵坐标不是数字。");
                            break;
                        }
                        action.RemoveChess(game, game.getPlayer2(), x1, y1, x2, y2);
                        game.getPlayer2().RecordStep("用("+x1+","+y1+")的棋子吃掉了("+x2+","+y2+")的棋子。");
                    }
                    else if (game.getGameType() == GameType.GO)
                    {
                        if (move2.length != 3)
                        {
                            System.out.println("参数个数错误，应为3个。");
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
                            System.out.println("横坐标或纵坐标不是数字。");
                            break;
                        }
                        action.RemoveGo(game, game.getPlayer2(), x, y);
                        game.getPlayer2().RecordStep("提子("+x+","+y+")。");
                    }
                    action.Show(game);
                    break;
                case "look":
                    if (move2.length != 3)
                    {
                        System.out.println("参数个数错误，应为3个。");
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
                        System.out.println("横坐标或纵坐标不是数字。");
                        break;
                    }
                    action.Look(game, x, y);
                    game.getPlayer2().RecordStep("查看了("+x+","+y+")的情况。");
                    break;
                case "count":
                    action.Count(game);
                    game.getPlayer2().RecordStep("计算了棋子总数。");
                    break;
                case "end":
                    game.getPlayer2().RecordStep("结束了游戏。");
                    break MAINLOOP;
                case "pass":
                    game.getPlayer2().RecordStep("放弃了本次采取行动的权利。");
                    break;
                default:
                    System.out.println("无效命令。");
                    break;
            }
        }
        ArrayList<String> player1Moves=game.getPlayer1().getMoves();
        ArrayList<String> player2Moves=game.getPlayer2().getMoves();

        System.out.println();
        System.out.println("游戏已结束，走棋历史如下：");
        System.out.println();
        for(String s :player1Moves)
        {
            System.out.println("棋手1"+s);
        }
        System.out.println();
        for(String s :player2Moves)
        {
            System.out.println("棋手2"+s);
        }
    }
}
