// 백준 2178 미로 탐색 - 시간 초과

package dfsAndBfs;

import java.util.Scanner;

public class mazeExploration {
    public static int[][] graph;
    public static int resultCnt = 0;
    public static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        dfs(0, 0, 0);

        System.out.println("\n 결과: " + resultCnt);
    }

    public static void dfs(int x, int y, int cnt) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        graph[x][y] = 2;
        cnt++;

        if (x == n - 1 && y == m - 1 && (resultCnt == 0 || cnt < resultCnt)) {
            System.out.println("============ 결과 변경 ===============");
            System.out.println("x: " + x + " | y: " + y + " | cnt: " + cnt);
            System.out.println("====================================");
            resultCnt = cnt;
        }

        System.out.println("x: " + x + " | y: " + y + " | cnt: " + cnt);
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && graph[newX][newY] == 1) {
                dfs(newX, newY, cnt);
                graph[newX][newY] = 1;
            }
        }
    }

}
