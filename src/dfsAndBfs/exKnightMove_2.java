package dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exKnightMove_2 {
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
            startPos[0] = scanner.nextInt();
            startPos[1] = scanner.nextInt();
            int[] endPos = new int[2];
            endPos[0] = scanner.nextInt();
            endPos[1] = scanner.nextInt();

            if (startPos[0] == endPos[0] && startPos[1] == endPos[1]) {
                moveNum = 0;
            } else {
                bfs(startPos, endPos);
            }
            resultList[i] = moveNum;
        }
        for (int resultListItem : resultList) {
            System.out.println(resultListItem);
        }
    }

    public static void bfs(int[] startPos, int[] endPos) {
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        Queue<Queue<int[]>> que = new LinkedList<>();
        visited[startPos[0]][startPos[1]] = true;
        Queue<int[]> queItem = new LinkedList<>();
        queItem.offer(startPos);
        que.offer(queItem);

        while (!que.isEmpty()) {
            Queue<int[]> presentQue = que.poll();
            Queue<int[]> nextQue = new LinkedList<>();

            while (!presentQue.isEmpty()) {
                int[] presentItem = presentQue.poll();
//                System.out.printf("presentItem: %d, %d\n", presentItem[0], presentItem[1]);

                for (int i = 0; i < 8; i++) {
                    int x = presentItem[0] + dx[i];
                    int y = presentItem[1] + dy[i];

                    if (x == endPos[0] && y == endPos[1]) {
                        moveNum++;
                        return;
                    }

                    if (x < 0 || x >= n || y < 0 || y >= n) {
                        continue;
                    }

                    if (!visited[x][y]) {
//                        System.out.printf("(%d, %d) 방문함\n", x, y);
                        visited[x][y] = true;
                        int[] newItem = {x, y};
                        nextQue.offer(newItem);
                    }
                }
            }
            moveNum++;

//            System.out.println("이동 횟수: " + moveNum);

            que.offer(nextQue);
        }
    }
}
