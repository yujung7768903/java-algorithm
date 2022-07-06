package dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

public class exBfs {
    public static boolean[] visited = new boolean[9];
    public static int[][] graph = {{}, {2, 3, 8}, {1, 7}, {1, 4, 5}, {3, 5}, {3, 4}, {7}, {2, 6, 8}, {1, 7}};

    public static void main(String[] args) {
        bfs(1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.println(x);
            for (int i = 0; i < graph[x].length; i++) {
                int index = graph[x][i];
                if (!visited[index]) {
                    q.offer(index);
                    visited[index] = true;
                }
            }
        }
    }
}
