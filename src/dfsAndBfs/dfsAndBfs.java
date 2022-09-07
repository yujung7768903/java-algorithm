// 백준 1260 DFS와 BFS

package dfsAndBfs;

import java.util.*;

public class dfsAndBfs {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] dfsVisited, bfsVisited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 정점의 개수
        int m = scanner.nextInt(); // 간선의 개수
        int v = scanner.nextInt(); // 탐색을 시작할 정점의 번호
        dfsVisited = new boolean[n + 1];
        bfsVisited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int j = 0; j < m; j++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }

    public static void dfs(int start) {
        dfsVisited[start] = true;
        System.out.print(start + " ");

        Collections.sort(graph.get(start));
        for (int node : graph.get(start)) {
            if (!dfsVisited[node]) {
                dfs(node);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        bfsVisited[start] = true;

        while (!queue.isEmpty()) {
            int presetNode = queue.poll();
            System.out.print(presetNode + " ");
            for (int node : graph.get(presetNode)) {
                if (!bfsVisited[node]) {
                    queue.add(node);
                    bfsVisited[node] = true;
                }
            }
        }

    }

//bfs에서 꺼낼 때 visited를 true로 만들면, Queue에 같은 원소가 중복되어 들어갈 수 있음.
//Queue에 넣을 때, visited를 true로 만들어야함

//    public static void bfs(int start) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(start);
//
//        while (!queue.isEmpty()) {
//            int presetNode = queue.poll();
//            System.out.println("presentNode: " + presetNode);
//            bfsVisited[presetNode] = true; // bfs에서 꺼낼 때 visited를 true로 만들면, Queue에 같은 원소가 중복되어 들어갈 수 있음.
//            bfsResult.add(presetNode);
//            for (int node : graph.get(presetNode)) {
//                if (!bfsVisited[node]) {
//                    queue.add(node);
//                }
//            }
//        }
//
//    }

}
