package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class exStar {
    public static String[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int size = 4 * (n - 1) + 1;
        board = new String[size][size];

        for (int min = 0; min <= (size / 2); min += 2) {
            int max = size - min - 1; // 최대 인덱스 값
            System.out.printf("min: %d, max: %d\n", min, max);
            if (min == max) {
                board[min][max] = "*";
                System.out.println(Arrays.deepToString(board));
            }
            else
                drawStar(min, max);
        }

        for (String[] str:board) {
            System.out.println(String.join("", str));
        }
    }

    public static void drawStar(int min, int max) {
        for (int x = min; x <= max; x++) {
            for (int y = min; y <= max; y++) {
                if (x == min || x == max || y == min || y == max)
                    board[x][y] = "*";
                else
                    board[x][y] = " ";
            }
        }
        System.out.println(Arrays.deepToString(board));
    }
}
