// 백준 2667번 단지번호붙이기

package dfsAndBfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class complexesNumbering {
    public static ArrayList<Integer> resultList = new ArrayList<>();
    public static int[][] map;
    public static boolean[][] visited;
    public static int n;
    public static int cnt, houseCnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    cnt++;
                    houseCnt = 0;
                    dfs(x, y);
                    resultList.add(houseCnt);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(resultList);
        for (Integer resultItem : resultList) {
            System.out.println(resultItem);
        }
    }

    public static void dfs(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        visited[x][y] = true;
        houseCnt++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                continue;
            }
            if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }
}
