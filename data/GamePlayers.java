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

        boolean winner = false;
        boolean game = true;
        boolean player = true;

        byte number_of_moves = 0;

        System.out.println("Нажмите Enter, чтобы продолжить");
        sc.nextLine();

        while (game) {
            AF.ClearConsole();
            GD.OutMemory();
            if (player) {
                System.out.println("Ход крестиков");

                System.out.print("Выберите столбец: ");
                int column = sc.nextInt();

                System.out.print("Выберите строку: ");
                int line = sc.nextInt();

                GD.MemorySet(line, column, (byte) 1);

                number_of_moves++;
                if (number_of_moves >= 5) {
                    winner = GameWinner.checkWinner(GD.GetMemory(), 'X');
                    if (winner) {
                        AF.ClearConsole();
                        GD.OutMemory();
                        System.out.println("Победа крестиков");
                        sc.nextLine();
                        AF.ClearConsole();
                        game = false;
                    }
                }

                player = false;

            } else {
                System.out.println("Ход ноликов");
                System.out.print("Выберите столбец: ");

                int column = sc.nextInt();
                System.out.print("Выберите строку: ");

                int line = sc.nextInt();
                GD.MemorySet(line, column, (byte) 2);
                number_of_moves++;

                if (number_of_moves >= 5) {
                    winner = GameWinner.checkWinner(GD.GetMemory(), 'O');
                    if (winner) {
                        AF.ClearConsole();
                        GD.OutMemory();
                        System.out.println("Победа ноликов");
                        sc.nextLine();
                        game = false;
                    }
                }
                player = true;
            }
        }
    }

}
