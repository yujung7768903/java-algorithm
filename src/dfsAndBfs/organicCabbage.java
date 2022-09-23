// 백준 1012번 유기농 배추 - 388ms

package dfsAndBfs;

import java.util.ArrayList;
import java.util.Scanner;

public class organicCabbage {
    public static int[][] map;
    public static boolean[][] visited;
    public static int wormsNum;
    public static int n, m;
    public static ArrayList<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            wormsNum = 0; // 지렁이 개수
            m = scanner.nextInt(); // 가로
            n = scanner.nextInt(); // 세로
            int k = scanner.nextInt(); // 배추 개수
            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                int y = scanner.nextInt();
                int x = scanner.nextInt();
                map[x][y] = 1;
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (map[row][col] == 1 && !visited[row][col]) {
                        dfs(row, col);
                        wormsNum++;
                    }
                }
            }
            resultList.add(wormsNum);
        }
        for (Integer resultItem : resultList) {
            System.out.println(resultItem);
        }
    }

    public static void dfs(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                continue;
            }
            if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }


}
