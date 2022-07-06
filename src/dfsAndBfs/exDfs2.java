package dfsAndBfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class exDfs2 {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited;
    public static ArrayList<Integer> result = new ArrayList<>(); // 탐색 노드
    public static int[] visitOrder; // 노드별 방문 순서

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 정점의 수
        int m = scanner.nextInt(); // 간선의 수
        int r = scanner.nextInt(); // 시작 정점
        visited = new boolean[n + 1];
        visitOrder = new int[n];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int j = 0; j < m; j ++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 노드 순회
        dfs(r);

        // 방문 순서대로 노드 정리
        int order = 1;
        for (int node : result) {
            visitOrder[node - 1] = order;
            order++;
        }

        // 결과 출력
        for (int visitOrderItem : visitOrder) {
            System.out.println(visitOrderItem);
        }
    }

    public static void dfs(int r) {
        visited[r] = true;
        result.add(r);
        Collections.sort(graph.get(r), Collections.reverseOrder());
        for (int node : graph.get(r)) {
            if (!visited[node])
                dfs(node);
        }
    }
}
