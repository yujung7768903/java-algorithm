// 백준 1012번 유기농 배추 - 160ms (StringBuffer 사용)

package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class organicCabbage_2 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int wormsNum;
    public static int n, m;
    public static ArrayList<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            wormsNum = 0; // 지렁이 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken()); // 배추 개수
            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
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
