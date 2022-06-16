package recursion;

import java.util.Scanner;

public class exFibonacciNumber5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] fibonacci = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if (i == 0)
                fibonacci[i] = 0;
            else if (i == 1)
                fibonacci[i] = 1;
            else {
                fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
            }
        }
        System.out.println(fibonacci[n]);
    }
}
