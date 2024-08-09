package game.data;

import java.util.Scanner;

public class StartGame {

    public StartGame() {
        System.out.println("Добро пожаловать в игру \"Крестики-нолики\"");
    }

    public void Start() {
        Scanner sc = new Scanner(System.in);
        AdditionalFunctions AF = new AdditionalFunctions();

        while (true) {
            System.out.print("Выберете тип игры (1 - человек против человека, 2 - человек против компьютера, 3 - выход): ");
            int type = sc.nextInt();
            if (type == 1) {
                GamePlayers game = new GamePlayers();
                game.Start();
            } else if (type == 2) {
                GameBot game = new GameBot();
            } else if (type == 3) {
                AF.ClearConsole();
                System.exit(0);
            }
        }

    }
}
