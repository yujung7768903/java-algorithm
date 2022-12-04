package practiceQuestions;

public class numExpression {
    public static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        for (int i = 1; i <= n; i++) {
            findComb(n, i);
        }

        return answer;
    }

    public static void findComb(int n, int start) {
        int sum = 0;
        while (sum <= n) {
            if (sum == n){
                answer++;
                break;
            }
            System.out.println("i: " + start);
            sum += start;
            System.out.println("sum: " + sum);
            start++;
        }
    }

}
