package game;


import game.data.AdditionalFunctions;
import game.data.StartGame;
import game.GUI.*;

class Main {


    public static void main(String[] args) {
        AdditionalFunctions AD = new AdditionalFunctions();

        if (!AD.GetValueFromConfig("GUI")) {
            StartGame GameStart = new StartGame();

            AD.ClearConsole();
            GameStart.Start();
        } else {
            new StartGUI();
        }

    }

}