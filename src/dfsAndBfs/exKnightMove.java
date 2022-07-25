package dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exKnightMove {
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] resultList;
    public static int moveNum, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNum = scanner.nextInt();
        resultList = new int[testCaseNum];

        // 테스트
        for (int i = 0; i < testCaseNum; i++) {
            n = scanner.nextInt();

            graph = new int[n][n];
            visited = new boolean[n][n];
            moveNum = 0;

            int[] startPos = new int[2];
            startPos[0] = scanner.nextInt();;
            startPos[1] = scanner.nextInt();
            int[] endPos = new int[2];
            endPos[0] = scanner.nextInt();;
            endPos[1] = scanner.nextInt();

            bfs(startPos, endPos);
            System.out.println("결과: " + moveNum);
            resultList[i] = moveNum;
        }
    }

    public static void bfs(int[] startPos, int[] endPos) {
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        Queue<int[]> que = new LinkedList<>();
        visited[startPos[0]][startPos[1]] = true;
        System.out.printf("(%d, %d) 방문함\n", startPos[0], startPos[1]);
        que.offer(startPos);

        while (!que.isEmpty()) {
            int[] presentItem = que.poll();

            for (int i = 0; i < 8; i++) {
                int x = presentItem[0] + dx[i];
                int y = presentItem[1] + dy[i];

                if (x == endPos[0] && y == endPos[1]) {
                    System.out.println("종료");
                    return;
                }

                if (x < 0 || x >= n || y < 0 || y >= n) {
                    continue;
                }

                if (!visited[x][y]) {
                    System.out.printf("(%d, %d) 방문함\n", x, y);
                    visited[x][y] = true;
                    int[] newItem = {x, y};
                    que.offer(newItem);
                }
            }
            moveNum++;

            System.out.println("이동 횟수: " + moveNum);
        }
    }
}
