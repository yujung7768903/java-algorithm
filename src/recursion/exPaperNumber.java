package recursion;

import java.util.Scanner;

public class exPaperNumber {
    public static int[][] board;
    public static int minusNum = 0;
    public static int zeroNum = 0;
    public static int plusNum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        partition(0, 0, n); // row: 시작행, col: 시작열, size: 종이 사이즈

        System.out.println(minusNum);
        System.out.println(zeroNum);
        System.out.println(plusNum);
    }

    public static void partition(int row, int col, int size) {
        if (checkSameNumber(row, col, size)) {
            if (board[row][col] == -1)
                minusNum++;
            else if (board[row][col] == 0)
                zeroNum++;
            else
                plusNum++;
        }
        else {
            // 종이 9개로 자르기
            for (int x = row; x <= (row + (size * 2/3)); x += (size * 1/3)) {
                for (int y = col; y <= (col + (size * 2/3)); y += (size * 1/3)) {
                    partition(x, y, size * 1/3);
                }
            }
        }
    }

    public static boolean checkSameNumber(int row, int col, int size) {
        for (int x = row; x < row + size; x++) {
            for (int y = col; y < col + size; y++) {
                if (board[row][col] != board[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }
}

