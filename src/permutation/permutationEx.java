package permutation;

import java.util.Arrays;
import java.util.Scanner;

/*
순열 예시 (중복 허용X)
1~n의 숫자 배열 중 r개를 뽑는 경우
 */
public class permutationEx {
    public static int[] arr; // result to print
    public static boolean[] visited;
    public static int n;
    public static int r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        r = scanner.nextInt();

        arr = new int[r];
        visited = new boolean[n + 1];

        permutation(0);
    }

    public static void permutation(int cnt) {
        if (cnt == r) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                arr[cnt] = i;
                visited[i] = true;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
