package dfsAndBfs;

import java.util.ArrayList;
import java.util.Scanner;

public class exVirus {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited;
    public static int virusComNum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int connect = scanner.nextInt();

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> graphItem = new ArrayList<>();
            graph.add(graphItem);
        }
        for (int j = 0; j < connect; j++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();

            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        bfs(1);
        System.out.println(virusComNum);
    }

    public static void bfs(int init) {
        visited[init] = true;
        System.out.printf("%d번 컴퓨터 바이러스 감염\n", init);
        if (init != 1) {
            virusComNum++;
        }

        for (int item : graph.get(init)) {
            if (!visited[item]) {
                bfs(item);
            }
        }
    }
}
