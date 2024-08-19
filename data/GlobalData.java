package game.data;

import java.util.Scanner;

public class GlobalData {

    private final char[][] DataMemory = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public void MemorySetGUI(int index_line, int column, byte player) {

        if (index_line < 0 || index_line >= 3 || column < 0 || column >= 3) {
            throw new IllegalArgumentException("Неверные координаты.");
        }

        if (DataMemory[index_line][column] == ' ') {
            char mark = (player == 1) ? 'X' : 'O';
            DataMemory[index_line][column] = mark;
        } else {
            throw new IllegalArgumentException("Клетка занята.");
        }
    }

    public void MemorySet(int index_line, int column, boolean player) {
        --index_line;
        --column;

        Scanner sc = new Scanner(System.in);

        try {
            if (index_line < 0 || index_line >= 3 || column < 0 || column >= 3) {
                throw new IllegalArgumentException("Неверные координаты. Попробуйте снова.");
            }

            if (player) {
                char cross = 'X';
                if (DataMemory[index_line][column] == ' ') {
                    DataMemory[index_line][column] = cross;
                } else {
                    System.out.println("Клетка занята, поставьте крестик в другую клетку");
                    System.out.print("Выберите столбец: ");
                    int column_ = sc.nextInt();

                    System.out.print("Выберите строку: ");
                    int line_ = sc.nextInt();

                    MemorySet(line_, column_, player);
                }
            } else {
                char circle = 'O';
                if (DataMemory[index_line][column] == ' ') {
                    DataMemory[index_line][column] = circle;
                } else {
                    System.out.println("Клетка занята, поставьте нолик в другую клетку");
                    System.out.print("Выберите столбец: ");
                    int column_ = sc.nextInt();

                    System.out.print("Выберите строку: ");
                    int line_ = sc.nextInt();

                    MemorySet(line_, column_, player);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.print("Выберите столбец: ");
            int column_ = sc.nextInt();

            System.out.print("Выберите строку: ");
            int line_ = sc.nextInt();

            MemorySet(line_, column_, player);
        } catch (Exception e) {
            System.out.println("Неверные данные. Попробуйте снова.");
            System.out.print("Выберите столбец: ");
            int column_ = sc.nextInt();

            System.out.print("Выберите строку: ");
            int line_ = sc.nextInt();

            MemorySet(line_, column_, player);
        }

    }

    public void OutMemory() {

        if (DataMemory == null) {
            System.out.println("data_memory is null");
            return;
        }

        for (char[] chars : DataMemory) {
            for (char aChar : chars) {
                if (aChar == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + aChar + "]");
                }
            }
            System.out.println();
        }
    }

    public void ResetMemory() {
        DataMemory[0][0] = ' ';
        DataMemory[0][1] = ' ';
        DataMemory[0][2] = ' ';
        DataMemory[1][0] = ' ';
        DataMemory[1][1] = ' ';
        DataMemory[1][2] = ' ';
        DataMemory[2][0] = ' ';
        DataMemory[2][1] = ' ';
        DataMemory[2][2] = ' ';
    }

    public char[][] GetMemory() {
        return DataMemory;
    }
}

