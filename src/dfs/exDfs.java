package dfs;

import java.util.ArrayList;

public class exDfs {
    public static boolean[] visited = new boolean[9];
    public static int[][] graph = {{}, {2, 3, 8}, {1, 7}, {1, 4, 5}, {3, 5}, {3, 4}, {7}, {2, 6, 8}, {1, 7}};

    public static void main(String[] args) {
        dfs(1);
    }

    public static void dfs(int x) {
        System.out.print(x + " ");
        visited[x] = true;
        for (int i = 0; i < graph[x].length; i++) {
            int item = graph[x][i];
            if (!visited[item]) {
                dfs(item);
            }
        }
    }
}
