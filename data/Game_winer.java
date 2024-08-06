package game.data;

import java.util.Arrays;

public class Game_winer {
    private final char[][][] win_comb_cros_1 = {{{'X'}, {'X'}, {'X'}},
            {{' '}, {' '}, {' '}},
            {{' '}, {' '}, {' '}}};

    private final char[][][] win_comb_cros_2 = {{{}, {}, {}},
            {{'X'}, {'X'}, {'X'}},
            {{' '}, {' '}, {' '}}};

    private final char[][][] win_comb_cros_3 = {{{' '}, {' '}, {' '}},
            {{' '}, {' '}, {' '}},
            {{'X'}, {'X'}, {'X'}}};

    private final char[][][] win_comb_cros_4 = {{{'X'}, {' '}, {' '}},
            {{'X'}, {' '}, {' '}},
            {{'X'}, {' '}, {' '}}};

    private final char[][][] win_comb_cros_5 = {{{' '}, {'X'}, {' '}},
            {{' '}, {'X'}, {' '}},
            {{' '}, {'X'}, {' '}}};

    private final char[][][] win_comb_cros_6 = {{{' '}, {' '}, {'X'}},
            {{' '}, {' '}, {'X'}},
            {{' '}, {' '}, {'X'}}};

    private final char[][][] win_comb_cros_7 = {{{'X'}, {' '}, {' '}},
            {{' '}, {'X'}, {' '}},
            {{' '}, {' '}, {'X'}}};

    private final char[][][] win_comb_cros_8 = {{{}, {}, {'X'}},
            {{' '}, {'X'}, {' '}},
            {{'X'}, {' '}, {' '}}};

    private final char[][][] win_comb_cros_9 = {{{'X'}, {' '}, {'X'}},
            {{' '}, {'X'}, {' '}},
            {{'X'}, {' '}, {'X'}}};

    private final char[][][] win_comb_circle_1 = {{{'O'}, {'O'}, {'O'}},
            {{' '}, {' '}, {' '}},
            {{' '}, {' '}, {' '}}};

    private final char[][][] win_comb_circle_2 = {{{' '}, {' '}, {' '}},
            {{'O'}, {'O'}, {'O'}},
            {{' '}, {' '}, {' '}}};

    private final char[][][] win_comb_circle_3 = {{{' '}, {' '}, {' '}},
            {{' '}, {' '}, {' '}},
            {{'O'}, {'O'}, {'O'}}};

    private final char[][][] win_comb_circle_4 = {{{'O'}, {' '}, {' '}},
            {{'O'}, {' '}, {' '}},
            {{'O'}, {' '}, {' '}}};

    private final char[][][] win_comb_circle_5 = {{{' '}, {'O'}, {' '}},
            {{' '}, {'O'}, {' '}},
            {{' '}, {'O'}, {' '}}};

    private final char[][][] win_comb_circle_6 = {{{' '}, {' '}, {'O'}},
            {{' '}, {' '}, {'O'}},
            {{' '}, {' '}, {'O'}}};

    private final char[][][] win_comb_circle_7 = {{{'O'}, {' '}, {' '}},
            {{' '}, {'O'}, {' '}},
            {{' '}, {' '}, {'O'}}};

    private final char[][][] win_comb_circle_8 = {{{' '}, {' '}, {'O'}},
            {{' '}, {'O'}, {' '}},
            {{'O'}, {}, {' '}}};

    private final char[][][] win_comb_circle_9 = {{{'O'}, {' '}, {'O'}},
            {{' '}, {'O'}, {' '}},
            {{'O'}, {' '}, {'O'}}};

    private final char[][][][] win_combinations_cros = {win_comb_cros_9, win_comb_cros_1, win_comb_cros_2, win_comb_cros_3,
            win_comb_cros_4, win_comb_cros_5, win_comb_cros_6, win_comb_cros_7, win_comb_cros_8};

    private final char[][][][] win_combinations_circle = {win_comb_circle_9, win_comb_circle_1, win_comb_circle_2,
            win_comb_circle_3, win_comb_circle_4, win_comb_circle_5, win_comb_circle_6, win_comb_circle_7, win_comb_circle_8};


    public boolean checking_for_a_win_cros(char[][][] memory) {
        char[][][] cros_memory = new char[memory.length][memory[0].length][memory[0][0].length];


        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                for (int k = 0; k < memory[i][j].length; k++) {
                    if (memory[i][j][k] == 'O') {
                        cros_memory[i][j][k] = ' '; // заменяем 'O' на пустоту
                    } else if (memory[i][j][k] != 'X') {
                        cros_memory[i][j][k] = ' ';
                    } else {
                        cros_memory[i][j][k] = 'X';
                    }

                }
            }
        }
        clear_uoooo(cros_memory);

        boolean good_end = false;
        for (char[][][] winCombinationsCro : win_combinations_cros) {
            if (Arrays.deepEquals(winCombinationsCro, cros_memory)) {
                good_end = true;
                break;
            }
        }

        return good_end;
    }

    public boolean checking_for_a_win_circle(char[][][] memory) {
        char[][][] circle_memory = new char[memory.length][memory[0].length][memory[0][0].length];


        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                for (int k = 0; k < memory[i][j].length; k++) {
                    if (memory[i][j][k] == 'X') {
                        circle_memory[i][j][k] = ' '; // заменяем 'O' на пустоту
                    } else if (memory[i][j][k] != 'O') {
                        circle_memory[i][j][k] = ' ';
                    } else {
                        circle_memory[i][j][k] = 'O';
                    }

                }
            }
        }
        clear_uoooo(circle_memory);

        boolean good_end = false;
        for (char[][][] winCombinationsCri : win_combinations_circle) {
            if (Arrays.deepEquals(winCombinationsCri, circle_memory)) {
                good_end = true;
                break;
            }
        }

        return good_end;
    }

    private void clear_uoooo(char[][][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    if (arr[i][j][k] == '\u0000') {
                        arr[i][j][k] = ' ';
                    }
                }
            }
        }

    }



}




