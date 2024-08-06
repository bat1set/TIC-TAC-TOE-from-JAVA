package game.data;

import java.util.Scanner;

public class Game_players {

    public Game_players() {
        System.out.println("Выбран режим для двух игроков");
        System.out.println("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]");
    }

    public void Start() {
        Scanner sc = new Scanner(System.in);
        Global_data GD = new Global_data();
        Additional_functions AF = new Additional_functions();
        Game_winer GW = new Game_winer();

        boolean winner = false;
        boolean game = true;
        boolean player = true;

        byte number_of_moves = 0;

        System.out.println("Нажмите Enter, чтобы продолжить");
        sc.nextLine();

        while (game) {
            AF.clearConsole();
            GD.out_memory();
            if (player) {
                System.out.println("Ход крестиков");

                System.out.print("Выберите столбец: ");
                int column = sc.nextInt();

                System.out.print("выберите строку: ");
                int line = sc.nextInt();

                GD.memory_set(line, column, (byte) 1);

                number_of_moves++;
                if (number_of_moves >= 5) {
                    winner = GW.checking_for_a_win_cros(GD.get_memory());
                    if (winner) {
                        AF.clearConsole();
                        GD.out_memory();
                        System.out.println("Победа крестиков");
                        System.out.println("Нажмите Enter, чтобы выйти");
                        sc.nextLine();
                        game = false;
                    }

                }

                player = false;

            } else {
                System.out.println("Ход ноликов");
                System.out.print("Выберите столбец: ");

                int column = sc.nextInt();
                System.out.print("выберите строку: ");

                int line = sc.nextInt();
                GD.memory_set(line, column, (byte) 2);
                number_of_moves++;

                if (number_of_moves >= 5) {
                    winner = GW.checking_for_a_win_circle(GD.get_memory());
                    if (winner) {
                        AF.clearConsole();
                        GD.out_memory();
                        System.out.println("Победа ноликов");
                        System.out.println("Нажмите Enter, чтобы выйти");
                        sc.nextLine();
                        game = false;
                    }
                }

                player = true;
            }
        }


    }

}
