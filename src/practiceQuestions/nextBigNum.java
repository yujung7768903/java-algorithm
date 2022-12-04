package practiceQuestions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nextBigNum {

    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        String binaryStr = Integer.toBinaryString(n);
        Pattern pattern = Pattern.compile("1");
        Matcher matcher = pattern.matcher(binaryStr);
        long oneNum = matcher.results().count();
        int answer = n + 1;

        while (true) {
            if (pattern.matcher(Integer.toBinaryString(answer)).results().count() == oneNum) {
                break;
            }
            answer++;
        }

        return answer;
    }

}
