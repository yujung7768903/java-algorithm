// 프로그래머스 2022 KAKAO BLIND RECRUITMENT 파괴되지 않은 건물
// 시간 초과 - 정확성 모두 통과 | 효율성 모두 실패

package sampleQuestions.kakao2022;

public class undestroyedBuilding {
    public static int[][] map;
    public static int answer;

    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        System.out.println(solution(board, skill));
    }

    public static int solution(int[][] board, int[][] skill) {
        answer = board.length * board[0].length;
        map = board;
        // 최대 반복 횟수: 250,000 x 1,000 x 1,000 = 250,000,000,000
        for (int[] skillItem : skill) {
            if (skillItem[0] == 1) { // 적의 공격
                applySkill(skillItem[1], skillItem[2], skillItem[3], skillItem[4], skillItem[5] * -1);
            } else { // 아군 지원
                applySkill(skillItem[1], skillItem[2], skillItem[3], skillItem[4], skillItem[5] * 1);
            }
        }
        return answer;
    }

    public static void applySkill(int r1, int c1, int r2, int c2, int degree) { // degree: 지원일 경우 양수, 공격일 경우 음수
        for (int row = r1; row <= r2; row++) {
            for (int col = c1; col <= c2; col++) {
                if (map[row][col] > 0 && map[row][col] <= degree * -1) { // 건물이 파괴되는 경우 (양수 -> 0이하)
                    answer--;
                    System.out.printf("건물 파괴됨 | %d -> %d | answer: %d \n", map[row][col], map[row][col] + degree, answer);
                } else if (map[row][col] <= 0 && map[row][col] * -1 < degree) { // 건물이 회복되는 경우 (0이하 -> 양수)
                    System.out.printf("건물 회복됨 | %d -> %d | answer: %d \n", map[row][col], map[row][col] + degree, answer);
                    answer++;
                }
                map[row][col] = map[row][col] + degree;
            }
        }
    }
}
