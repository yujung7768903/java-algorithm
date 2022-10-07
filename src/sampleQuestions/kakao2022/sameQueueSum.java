package sampleQuestions.kakao2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class sameQueueSum {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1}));
    }

    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<Integer>();
        Queue<Integer> que2 = new LinkedList<Integer>();
        Arrays.stream(queue1).forEach(num1 -> que1.add(num1));
        Arrays.stream(queue2).forEach(num2 -> que2.add(num2));
        int queSum1 = Arrays.stream(queue1).sum();
        int queSum2 = Arrays.stream(queue2).sum();
        int total = queSum1 + queSum2;
        int answer = 0;

        while (true) {
            int lastNum = (queSum1 < queSum2) ? que2.poll() : que1.poll();
            if (lastNum > (total / 2)) {
                answer = -1;
                break;
            }
            if (queSum1 < queSum2) {
                que1.add(lastNum);
                queSum1 += lastNum;
                queSum2 -= lastNum;
                answer++;
                System.out.println("queSum1: " + queSum1 + ", queSum2: " + queSum2);
                System.out.println("answer: " + answer);
                System.out.println(que1.toString());
                System.out.println(que2.toString());
            } else if (queSum1 > queSum2) {
                que2.add(lastNum);
                queSum2 += lastNum;
                queSum1 -= lastNum;
                answer++;
                System.out.println("queSum1: " + queSum1 + ", queSum2: " + queSum2);
                System.out.println("answer: " + answer);
                System.out.println(que1.toString());
                System.out.println(que2.toString());
            }
            if (queSum1 == queSum2) {
                break;
            }
            System.out.println("===================");
        }
        return answer;
    }
}
