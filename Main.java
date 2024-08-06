package game;

import game.data.Additional_functions;
import game.data.Start_game;

class Main {
    public static void main(String[] args) {
        Start_game game_start = new Start_game();
        Additional_functions AD = new Additional_functions();
        AD.clearConsole();
        game_start.Start();
    }
}