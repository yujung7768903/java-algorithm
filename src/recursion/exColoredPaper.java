package recursion;

import java.util.Scanner;

public class exColoredPaper {
    public static int white = 0;
    public static int blue = 0;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        partition(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {
        if (checkColor(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    public static boolean checkColor(int row, int col, int size) {
        int presentColor = board[row][col];

        for (int x = row; x < row + size; x++) {
            for (int y = col; y < col + size; y++) {
                if (board[x][y] != presentColor) {
                    return false;
                }
            }
        }

        return true;
    }
}
