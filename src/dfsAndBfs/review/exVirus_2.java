package dfsAndBfs.review;

import java.util.ArrayList;
import java.util.Scanner;

public class exVirus_2 {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int virusNum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> adNodeList = new ArrayList<>();
            graph.add(adNodeList);
        }
        visited = new boolean[n + 1];

        int p = scanner.nextInt();

        for (int j = 0; j < p; j++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();

            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        if (n > 0) {
            visited[1] = true;
            bfs(1);
        }

        System.out.println(virusNum);
    }

    public static void bfs(int start) {
        for (int adNode : graph.get(start)) {
            if (!visited[adNode]) {
                visited[adNode] = true;
                virusNum++;
                bfs(adNode);
            }
        }
    }
}
