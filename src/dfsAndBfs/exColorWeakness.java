package dfsAndBfs;

import java.util.Scanner;

public class exColorWeakness {
    public static Character[][] board, weakBoard;
    public static boolean[][] visited;
    public static int n, partNum, weakPartNum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        board = new Character[n][n];
        weakBoard = new Character[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
                weakBoard[i][j] = row.charAt(j);
                if (weakBoard[i][j] == 'G') {
                    weakBoard[i][j] = 'R';
                }
            }
        }

        // 적록색약이 아닌 사람
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y]) {
                    dfs(x, y, board);
                    partNum++;
                }
            }
        }

        // 방문 여부 초기화
        visited = new boolean[n][n];

        // 적록 색약인 사람
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y]) {
                    dfs(x, y, weakBoard);
                    weakPartNum++;
                }
            }
        }



        System.out.printf("%d %d", partNum, weakPartNum);
    }

    public static void dfs(int row, int col, Character[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            if ( 0 <= x && x < n && 0 <= y && y < n && !visited[x][y] && board[row][col] == board[x][y]) {
                dfs(x, y, board);
            }
        }
    }
}
