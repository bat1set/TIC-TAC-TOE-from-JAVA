package game.data;

import java.util.Scanner;

public class Start_game {

    public Start_game() {
        System.out.println("Добро пожаловать в игру \"Крестики-нолики\"");
    }

    public void Start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Выберете тип игры (1 - человек против человека, 2 - человек против компьютера): ");
            int type = sc.nextInt();
            if (type == 1) {
                Game_players game = new Game_players();
                game.Start();
            } else if (type == 2) {
                Game_bot game = new Game_bot();
            }
        }

    }
}
