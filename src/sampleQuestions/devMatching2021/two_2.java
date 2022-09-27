// 2021 Dev-Matching 웹 백엔드 (상반기) - 행렬 테두리 회전하기
// 테스트 코드 1번만 성공

package sampleQuestions.devMatching2021;

import java.util.Arrays;

public class two_2 {
    public static int[][] map;

    public static void main(String[] args) {
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] result = solution(6, 6, queries);
        System.out.println("result: " + Arrays.toString(result));
        System.out.println("==================================");
        queries = new int[][]{{2, 2, 3, 6}};
        result = solution(3, 6, queries);
        System.out.println("result: " + Arrays.toString(result));
        System.out.println("==================================");
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = (i * columns) + (j + 1);
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("==========================");

        int[] answer = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            answer[j] = rotate(query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < columns; y++) {
                    System.out.print(map[x][y]);
                }
                System.out.println();
            }
            System.out.println("===========================");
        }


        return answer;
    }

    public static int rotate(int startX, int startY, int endX, int endY) {
        System.out.println("startX: " + startX + ", startY: " + startY + ", endX: " + endX + ", endY: " + endY);

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int tmp = map[startX][startY];
        int minNum = map[startX][startY];
        int presentNum = map[startX + 1][startY]; // 이동할 숫자
        System.out.println("presentNum: " + presentNum);

        for (int a = startY; a < endY; a++) {
            tmp = map[startX][a];
            minNum = (tmp < minNum) ? tmp : minNum;
            map[startX][a] = presentNum; // 시계방향을 기준으로 회전시켜 숫자 변경
            presentNum = tmp;
            System.out.println("presentNum: " + presentNum);
        }
        for (int b = startX; b < endX; b++) {
            tmp = map[b][endY];
            minNum = (tmp < minNum) ? tmp : minNum;
            map[b][endY] = presentNum;
            presentNum = tmp;
            System.out.println("presentNum: " + presentNum);
        }
        for (int c = endY; c > startY; c--) {
            tmp = map[endX][c];
            map[endX][c] = presentNum;
            presentNum = tmp;
            System.out.println("presentNum: " + presentNum);
        }
        for (int d = endX; d > startX; d--) {
            tmp = map[d][startY];
            map[d][startY] = presentNum;
            presentNum = tmp;
            System.out.println("presentNum: " + presentNum);
        }

        return minNum;
    }
}
