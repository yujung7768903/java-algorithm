package practiceQuestions;

public class FibonacciNum {
    public static int[] fibonacciArr;

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println("=======================");
        System.out.println(solution(5));
        System.out.println("=======================");
        System.out.println(solution(10));
    }

    public static int solution(int n) {
        fibonacciArr = new int[n + 1];
        fibonacciArr[0] = 0;
        fibonacciArr[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacciArr[i] = ((fibonacciArr[i - 1] % 1234567) + (fibonacciArr[i - 2]) % 1234567) % 1234567;
        }
        return fibonacciArr[n];
    }

}
