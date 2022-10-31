package sampleQuestions.kakao2021;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class numStringAndWord {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        splitString("one4seveneight");
    }

    public int solution(String s) {
        int answer = 0;
        return answer;
    }

    public static void splitString(String s) {
        Pattern alpPattern = Pattern.compile("[a-z]+|[0-9]+");
        Matcher alpMatcher = alpPattern.matcher(s);
//        Pattern numPattern = Pattern.compile("[0-9]+");
//        Matcher numMatcher = numPattern.matcher(s);

        while (alpMatcher.find()) {
            String num = alpMatcher.group();
            System.out.println(num);
//            sb.append(num);
//            System.out.println(sb);
        }
//        while (numMatcher.find()) {
//            sb.append(numMatcher.group());
//            System.out.println(sb);
//        }
    }

    public static int findNum(String s) {
        switch (s) {
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
        }
        return 9;
    }

}
