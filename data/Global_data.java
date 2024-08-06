package game.data;

import java.util.Arrays;
import java.util.Scanner;

public class Global_data {

    private final char[][][] data_memory = {{{}, {}, {}},
            {{}, {}, {}},
            {{}, {}, {}}};

    public void memory_set(int index_line, int column, byte player) {
        --index_line;
        --column;

        Scanner sc = new Scanner(System.in);

        if (player == 1) {
            char cross = 'X';
            if (data_memory[index_line][column].length == 0) {
                data_memory[index_line][column] = new char[]{cross};
            } else {
                System.out.println("Клетка занята, поставть крестик в другую клетку");
                System.out.print("Выберите столбец: ");
                int column_ = sc.nextInt();

                System.out.print("выберите строку: ");
                int line_ = sc.nextInt();

                memory_set(line_, column_, player);
            }

        } else if (player == 2) {
            char circle = 'O';
            if (data_memory[index_line][column].length == 0) {
                data_memory[index_line][column] = new char[]{circle};
            } else {
                System.out.println("Клетка занята, поставть нолик в другую клетку");
                System.out.print("Выберите столбец: ");
                int column_ = sc.nextInt();

                System.out.print("выберите строку: ");
                int line_ = sc.nextInt();

                memory_set(line_, column_, player);
            }
        }
    }

    public void out_memory() {

        if (data_memory == null) {
            System.out.println("data_memory is null");
            return;
        }

        for (char[][] chars : data_memory) {
            for (char[] aChar : chars) {
                if (aChar.length == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print(Arrays.toString(aChar));
                }
            }
            System.out.println();
        }
    }

    public char[][][] get_memory() {
        return data_memory;
    }
}

