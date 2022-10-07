package devMatching2022;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class one {
    public static String result;

    public static void main(String[] args) {
        String[] registered_list = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
        System.out.println("결과: " + solution(registered_list, "ace15"));
        System.out.println("================================");
        registered_list = new String[]{"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        System.out.println("결과: " + solution(registered_list, "cow"));
        System.out.println("================================");
    }

    // 1.new_id가 registered_list에 포함되어 있지 않다면, new_id를 추천하고 종료
    // 2. new_id가 registered_list에 포함되어 있다면,
    // 2-1 new_id를 두 개의 문자열 s와 N으로 분리
    // 2-2 문자열 N을 10진수 숫자로 변환한 값 -> n
    // (단, N이 비어있는 null 문자열이라면, n은 0이 된다.)
    // 2-3 n에 1을 더한 값(n + 1)을 문자열로 변환한 값을 n1이라고 한다.
    // 2-4 new_id를 s+n1로 변경하고 1로 돌아간다.

    public static String solution(String[] registered_list, String new_id) {
        System.out.println("new_id: " + new_id);
        result = new_id;
        // 2. new_id가 registered_list에 포함되어 있다면,
        if (Arrays.asList(registered_list).contains(new_id)) {
            String[] splitId = splitString(new_id);
            String s = splitId[0];
            String n = splitId[1];
            int intN = (n == null) ? 0 : Integer.parseInt(n);
            int n1 = intN + 1;
            System.out.println("n1: " + n1);
            solution(registered_list, s + n1);
        }
        // 1.new_id가 registered_list에 포함되어 있지 않다면, new_id를 추천하고 종료
        return result;
    }

    public static String[] splitString(String s) {
        String[] result = new String[2];
        Pattern alpPattern = Pattern.compile("[a-z]+");
        Matcher alpMatcher = alpPattern.matcher(s);
        Pattern numPattern = Pattern.compile("[0-9]+");
        Matcher numMatcher = numPattern.matcher(s);

        while (alpMatcher.find()) {
            result[0] = alpMatcher.group();
            System.out.println(result[0]);
        }
        while (numMatcher.find()) {
            result[1] = numMatcher.group();
            System.out.println(result[1]);
        }

        return result;
    }

}
