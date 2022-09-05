// 백 2839번 설탕 배달

package greedy;

import java.util.Scanner;

public class sugarDelivery {
    public static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int result = calMinNum();
        System.out.println(result);
    }

    public static int calMinNum() {
        if (n % 5 == 0) {
            return n / 5;
        }

        int max = n / 5;
        for (int i = max; i >= 0; i--) {
            int rest = n - (5 * i);
            if (rest % 3 == 0) {
                System.out.println("5의 개수: " + i + ", 3의 개수: " + rest / 3);
                return i + (rest / 3);
            }
        }

        return -1;
    }
}
