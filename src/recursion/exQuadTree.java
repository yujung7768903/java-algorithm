package recursion;

import java.util.Scanner;

public class exQuadTree {
    public static int[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }

        String result = partition(0, 0, n);
        System.out.println(result);
    }

    public static String partition(int row, int col, int size) {
        if (checkSameNumber(row, col, size)) {
            return String.valueOf(board[row][col]);
        }else {
            int newSize = size / 2;

            String part1 = partition(row, col, newSize);
            String part2 = partition(row, col + newSize, newSize);
            String part3 = partition(row + newSize, col, newSize);
            String part4 = partition(row + newSize, col + newSize, newSize);

            return "(" + part1 + part2 + part3 + part4 + ")";
        }
    }

    public static boolean checkSameNumber(int row, int col, int size) {
        for (int x = row; x < row + size; x++) {
            for (int y = col; y < col + size; y++) {
                if (board[x][y] != board[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
