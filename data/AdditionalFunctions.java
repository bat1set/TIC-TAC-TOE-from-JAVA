package game.data;
import java.io.*;

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

    public Boolean GetValueFromConfig(String key) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("game/Config.conf")) {
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: game/Config.conf");
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(key)) {
                    return Boolean.parseBoolean(line.split("=")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

}
