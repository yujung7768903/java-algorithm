// 프로그래머스 2022 KAKAO BLIND RECRUITMENT 파괴되지 않은 건물
// 누적합이용 -> 통과

package sampleQuestions.kakao2022;

public class undestroyedBuilding_2 {
    public static int[][] effectMap;

    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        System.out.println(solution(board, skill));
    }

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        effectMap = new int[board.length + 1][board[0].length + 1];

        // 내구도 변화 누적합으로 저장 - 최대 반복 횟수: 250,000
        for (int[] skillItem : skill) { // skillItem: [type, r1, c1, r2, c2, degree];
            int r1 = skillItem[1];
            int c1 = skillItem[2];
            int r2 = skillItem[3];
            int c2 = skillItem[4];
            int degree = (skillItem[0] == 1) ? skillItem[5] * -1 : skillItem[5];

            effectMap[r1][c1] = effectMap[r1][c1] + degree;
            effectMap[r1][c2 + 1] = effectMap[r1][c2 + 1] - degree;
            effectMap[r2 + 1][c1] = effectMap[r2 + 1][c1] - degree;
            effectMap[r2 + 1][c2 + 1] = effectMap[r2 + 1][c2 + 1] + degree;
        }

        // 가로 누적합 계산 - 최대 반복 횟수: 1,000 x 1,000 = 1,000,000
        for (int x = 0; x < board.length; x++) {
            for (int y = 1; y < board[0].length; y++) {
                // 누적합 계산
                effectMap[x][y] = effectMap[x][y - 1] + effectMap[x][y];
                // 건물의 내구도 계산
            }
        }

        // 세로 누적합 계산 - 최대 반복 횟수: 1,000 x 1,000 = 1,000,000
        for (int c = 0; c < board[0].length; c++) {
            for (int r = 1; r < board.length; r++) {
                effectMap[r][c] = effectMap[r - 1][c] + effectMap[r][c];
            }
            System.out.println();
        }

        // 건물 내구도 계산
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                System.out.print(effectMap[i][j]);
                if (board[i][j] + effectMap[i][j] <= 0) answer++;
            }
            System.out.println();
        }

        return answer;
    }

}
