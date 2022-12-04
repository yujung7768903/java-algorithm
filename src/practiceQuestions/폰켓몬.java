package practiceQuestions;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {
    public static void main(String[] args) {
    }

    public static int solution(int[] nums) {
        Map<Integer, Integer> monMap = new HashMap<>();
        for (int num : nums) {
            monMap.put(num, (monMap.containsKey(num)) ? monMap.get(num) + 1 : 1);
        }
        if (monMap.size() >= nums.length / 2) return nums.length / 2;

        return monMap.size();
    }
}
