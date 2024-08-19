package game.data;

import java.util.Scanner;

public class GamePlayers {

    public GamePlayers() {
        System.out.println("Выбран режим для двух игроков");
        System.out.println("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]");
    }

    public void Start() {
        Scanner sc = new Scanner(System.in);
        GlobalData GD = new GlobalData();
        AdditionalFunctions AF = new AdditionalFunctions();


        boolean game = true;
        boolean player = true;


        System.out.println("Нажмите Enter, чтобы продолжить");
        sc.nextLine();

        while (game) {
            AF.ClearConsole();
            GD.OutMemory();

            int line;
            int coloumn;

            if (player) {
                draw(true);
                coloumn = coloumns();
                line = lines();
                GD.MemorySet(line, coloumn, true);
                AF.ClearConsole();
                GD.OutMemory();
                if (SWinner(GD.GetMemory(), 'X')) {
                    game = false;
                } else if (SDraw(GD.GetMemory())) {
                    game = false;
                }

                player = false;
            } else {
                draw(false);
                coloumn = coloumns();
                line = lines();
                GD.MemorySet(line, coloumn, false);
                AF.ClearConsole();
                GD.OutMemory();
                if (SWinner(GD.GetMemory(), 'O')) {
                    game = false;
                } else if (SDraw(GD.GetMemory())) {
                    game = false;
                }
                player = true;
            }

        }
    }

    private int coloumns() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Выберите столбец: ");
        return sc.nextInt();
    }

    private int lines() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Выберите строку: ");
        return sc.nextInt();
    }

    private void draw(boolean player) {

        if (player) {
            System.out.println("Ход крестиков");
        } else {
            System.out.println("Ход ноликов");
        }

    }

    private boolean SWinner(char[][] board, char player) {
        if (GameWinner.checkWinner(board, player)) {

            if (player == 'X') {
                System.out.println("Победа крестиков");
            } else {
                System.out.println("Победа ноликов");
            }

            return true;
        }
        return false;
    }

    private boolean SDraw(char[][] board) {
        if (GameWinner.checkDraw(board)) {

            System.out.println("Ничья");
            return true;
        }
        return false;
    }

}
