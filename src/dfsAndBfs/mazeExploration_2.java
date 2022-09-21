// 백준 2178 미로 탐색 - 시간 초과

package dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class mazeExploration_2 {
    public static int[][] graph;
    public static boolean[][] visited;
    public static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(graph[n - 1][m - 1]);
    }

    public static void bfs() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] nowItem = queue.poll();
            int nowX = nowItem[0];
            int nowY = nowItem[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (visited[nextX][nextY] || graph[nextX][nextY] == 0) {
                    continue;
                }
                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                graph[nextX][nextY] = graph[nowX][nowY] + 1;
            }
        }
    }

}
