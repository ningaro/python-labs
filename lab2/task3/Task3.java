package com.task3;
public class Task3 {
    public static void main (String[] args) {
        setQueen();
    }
    // Расчитываем позиции для королев
    static boolean checkPos(int[] rows, int row, int column) {
        // Проверяем, что бы никто не смог нас атаковать
        for (int i = 0; i < row; i++) {
            if ((rows[i] == column) || (rows[i] - i == column - row) || (rows[i] + i == column + row))
                return false;
        }

        return true;
    }
    static void setQueen() {
        // Начинаем перебор вариантов
        int[] rows = new int[8];
        setQueen(rows, 0);
    }
    static void setQueen(int[] rows, int row) {
        if (row == 8) {
            // Если получилось расставить 8 ферзей, то рисуем шахмотную доску с ними
            drawBoard(rows);
        } else {
            for (int col = 0; col < 8; col++) {
                if (checkPos(rows, row, col)) {
                    rows[row] = col;
                    if (row + 1 < 9) setQueen(rows, row + 1);
                }
            }
        }
    }

    // Рисуем игральную доску с фигурами
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static int varCounter = 1;
    static void drawBoard(int[] queenPos) {
        String rowName = "ABCDEFGH";
        System.out.printf("%sВариант %d%s\n", ANSI_BOLD, varCounter, ANSI_RESET);
        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 9) {
                System.out.print("    ");
                for (int j = 0; j < 8; j++) {
                    System.out.printf(" %s%c%s  ", ANSI_BOLD, rowName.charAt(j), ANSI_RESET);
                }

            } else {
                for (int j = 0; j < 10; j++) {


                    if (j == 0 || j == 9)
                        System.out.printf(" %s%d%s  ", ANSI_BOLD, 9-i, ANSI_RESET);
                    else {
                        String posContent = "    ";
                        if (queenPos[i-1] == j - 1)
                            posContent = " \uD83D\uDC51 ";

                        if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1))
                            System.out.printf("%s%s%s%s",ANSI_WHITE_BACKGROUND, ANSI_RED, posContent, ANSI_RESET);
                        else
                            System.out.printf("%s%s%s%s", ANSI_BLACK_BACKGROUND, ANSI_RED, posContent, ANSI_RESET);
                    }
                }
            }

            System.out.printf("\n");
        }

        varCounter++;
    }
}