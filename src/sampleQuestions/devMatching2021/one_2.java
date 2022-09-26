// 2021 Dev-Matching 웹 백엔드 (상반기) - 로또의 최고 순위와 최저 순위
// map을 활용한 알고리즘
// 6번 실행시 평균 소요 시간: 22.16ms

package sampleQuestions.devMatching2021;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class one_2 {
    public static void main(String[] args) {
        LocalDateTime before = LocalDateTime.now();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};
        int[] result = solution(lottos, winNums);
        LocalDateTime after = LocalDateTime.now();
        System.out.println("결과: " + Arrays.toString(result));
        System.out.println("시간: " + ChronoUnit.MILLIS.between(before, after) + "ms");
        System.out.println("==================================");
        lottos = new int[]{0, 0, 0, 0, 0, 0};
        winNums = new int[]{1, 2, 3, 4, 5, 6};
        result = solution(lottos, winNums);
        System.out.println("결과: " + Arrays.toString(result));
        System.out.println("==================================");
    }

    public static int[] solution(int[] lottos, int[] winNums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int sameCnt = 0;
        int zeroCnt = 0;

        for (int lotto_item : lottos) {
            System.out.println("lotto_item: " + lotto_item);
            if (lotto_item == 0) {
                zeroCnt++;
                continue;
            }
            map.put(lotto_item, true);
        }
        for (int winNumsItem : winNums) {
            if (map.containsKey(winNumsItem)) sameCnt++;
        }
        System.out.println("sameCnt: " + sameCnt + ", zeroCnt: " + zeroCnt);
        int min = sameCnt;
        int max = sameCnt + zeroCnt;
        int[] answer = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
        return answer;
    }
}
