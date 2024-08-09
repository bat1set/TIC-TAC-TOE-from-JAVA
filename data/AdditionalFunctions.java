package game.data;

public class AdditionalFunctions {
    public void ClearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
