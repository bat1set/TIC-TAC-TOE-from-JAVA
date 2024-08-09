package game;

import game.data.AdditionalFunctions;

import game.data.StartGame;
class Main {
    public static void main(String[] args) {
        StartGame game_start = new StartGame();
        AdditionalFunctions AD = new AdditionalFunctions();
        AD.ClearConsole();
        game_start.Start();
    }
}