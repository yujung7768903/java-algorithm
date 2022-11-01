package practiceQuestions;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class minAndMax {

    public static void main(String[] args) {
        LocalDateTime before = LocalDateTime.now();
        System.out.println("before time: " + before);
        System.out.println(solution("1 2 3 4"));
        LocalDateTime after = LocalDateTime.now();
        System.out.println("after time: " + after);
        System.out.println("total time: " + ChronoUnit.SECONDS.between(before, after) + "s");
        System.out.println("total time: " + ChronoUnit.MILLIS.between(before, after) + "ms");
        System.out.println("total time: " + ChronoUnit.MICROS.between(before, after) + "µs");
        System.out.println("==========================");
        before = LocalDateTime.now();
        System.out.println("before time: " + before);
        System.out.println(solution2("1 2 3 4"));
        after = LocalDateTime.now();
        System.out.println("after time: " + after);
        System.out.println("total time: " + ChronoUnit.SECONDS.between(before, after) + "s");
        System.out.println("total time: " + ChronoUnit.MILLIS.between(before, after) + "ms");
        System.out.println("total time: " + ChronoUnit.MICROS.between(before, after) + "µs");
        System.out.println("==========================");
        before = LocalDateTime.now();
        System.out.println("before time: " + before);
        System.out.println(solution3("1 2 3 4"));
        after = LocalDateTime.now();
        System.out.println("after time: " + after);
        System.out.println("total time: " + ChronoUnit.SECONDS.between(before, after) + "s");
        System.out.println("total time: " + ChronoUnit.MILLIS.between(before, after) + "ms");
        System.out.println("total time: " + ChronoUnit.MICROS.between(before, after) + "µs");
    }

    // 방법1: stream 활용. 소요 시간: 30ms(22774µs)
    public static String solution(String s) {
        int[] splitStr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(splitStr);

        return splitStr[0] + " " + splitStr[splitStr.length - 1];
    }

    // 방법2: 반복문 활용. 소요 시간: 295µs
    public static String solution2(String s) {
        int[] resultArr = new int[2]; // 최솟값, 최댓값
        String[] splitStr = s.split(" ");
        int[] intArr = new int[splitStr.length];
        for (int i = 0; i < splitStr.length; i++) {
            intArr[i] = Integer.parseInt(splitStr[i]);
            if (intArr[i] < resultArr[0] || i == 0)
                resultArr[0] = intArr[i];
            if (intArr[i] > resultArr[1] || i == 0)
                resultArr[1] = intArr[i];
        }

        return resultArr[0] + " " + resultArr[1];
    }

    // 방법3: programmers 다른 사람 풀이. 소요 시간: 361µs
    public static String solution3(String str) {
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
            n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;

    }


}
