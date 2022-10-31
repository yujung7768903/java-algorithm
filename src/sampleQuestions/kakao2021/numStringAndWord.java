package sampleQuestions.kakao2021;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class numStringAndWord {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {
        String[] strNumList = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < strNumList.length; i++) {
            s = s.replace(strNumList[i], Integer.toString(i));
        }

        int answer = Integer.parseInt(s);
        return answer;
    }
}
