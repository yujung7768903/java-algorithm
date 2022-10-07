// 2021 Dev-Matching 웹 백엔드 (상반기) - 행렬 테두리 회전하기
// 테스트 코드 1번만 성공 : minNum = (tmp < minNum) ? tmp : minNum; <- 이 줄이 빠진 게 원인이었음

package sampleQuestions.devMatching2021;

import java.util.Arrays;

public class two {
    public static int[][] map;

    public static void main(String[] args) {
        int[][] queries = {{1, 1, 2, 2}, {2, 3, 3, 4}, {1, 2, 3, 4}, {1, 1, 3, 4}, {2, 2, 3, 5}};
        int[] result = solution(3, 5, queries);
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

        int minNum = map[startX + 1][startY];
        int presentNum = minNum; // 이동할 숫자
        System.out.println("presentNum: " + presentNum);

        int tmp;
        for (int a = startY; a < endY; a++) { // 위
            tmp = map[startX][a];
            minNum = (tmp < minNum) ? tmp : minNum;
            map[startX][a] = presentNum; // 시계방향을 기준으로 회전시켜 숫자 변경
            presentNum = tmp;
            System.out.println("presentNum: " + presentNum);
        }
        for (int b = startX; b < endX; b++) { // 오른쪽
            tmp = map[b][endY];
            minNum = (tmp < minNum) ? tmp : minNum;
            map[b][endY] = presentNum;
            presentNum = tmp;
            System.out.println("presentNum: " + presentNum);
        }
        for (int c = endY; c > startY; c--) { // 아래
            tmp = map[endX][c];
            minNum = (tmp < minNum) ? tmp : minNum;
            map[endX][c] = presentNum;
            presentNum = tmp;
            System.out.println("presentNum: " + presentNum);
        }
        for (int d = endX; d > startX; d--) { // 왼쪽
            tmp = map[d][startY];
            minNum = (tmp < minNum) ? tmp : minNum;
            map[d][startY] = presentNum;
            presentNum = tmp;
            System.out.println("presentNum: " + presentNum);
        }

        return minNum;
    }
}
