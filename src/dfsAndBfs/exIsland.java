package dfsAndBfs;

import java.util.Scanner;

public class exIsland {
    public static int[][] graph;
    public static boolean[][] visited;
    public static int w;
    public static int h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            w = scanner.nextInt();
            h = scanner.nextInt();

            if (w == 0 && h == 0) {
                break;
            }

            int islandNum = 0;

            graph = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    graph[i][j] = scanner.nextInt();
                }
            }

            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if (!visited[row][col] && graph[row][col] == 1) {
                        dfs(row, col);
                        islandNum++;
                    }
                }
            }
            System.out.println(islandNum);
        }

    }

    // 섬인 곳을 돌면서 visited를 true로 만들기
    public static void dfs(int row, int col) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            int x = row + dx[i];
            int y = col + dy[i];

            if (x < 0 || x >= h || y < 0 || y >= w) {
                continue;
            }

            if (!visited[x][y] && graph[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}
