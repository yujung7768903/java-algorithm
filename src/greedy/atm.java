// 백준 11399번 ATM

package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class atm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numArr;
        int result = 0;

        int n = scanner.nextInt();
        numArr = new Integer[n];

        for (int i = 0; i < n; i++) {
            numArr[i] = scanner.nextInt();
        }

        Arrays.sort(numArr);

        for (int j = 0; j < n; j++) {
            result += numArr[j] * (n - j);
        }

        System.out.println(result);
    }
}
