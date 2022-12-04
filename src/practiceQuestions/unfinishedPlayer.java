package practiceQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class unfinishedPlayer {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"mariana", "mariana", "mariana", "mariana", "josh"}, new String[]{"mariana", "mariana", "mariana", "mariana"}));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionMap = new HashMap<>();
        String answer = "";
        for (String str : completion) {
            completionMap.put(str, (completionMap.containsKey(str)) ? (completionMap.get(str) + 1) : 1);
        }

        for (String str : participant) {
            if (!completionMap.containsKey(str) || completionMap.get(str) == 0) {
                answer = str;
                break;
            } else {
                completionMap.replace(str, completionMap.get(str) - 1);
            }
        }
        return answer;
    }
}
