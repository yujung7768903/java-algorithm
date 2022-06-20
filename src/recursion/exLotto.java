package recursion;

import java.util.Scanner;

public class exLotto {

    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n == 0)
                break;

            arr = new int[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            combination(arr, visited, 0, 6);
            System.out.println();
        }
    }

    public static void combination(int[] arr, boolean[] visited, int index, int r) { //index: 현재 인덱스, r: 뽑야야하는 숫자
        if (r == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (index == arr.length)
            return;
        else {
            // 현재 숫자를 선택한 경우
            visited[index] = true;
            combination(arr, visited, index + 1, r - 1);
            // 현재 숫자를 선택하지 않은 경우
            visited[index] = false;
            combination(arr, visited, index + 1, r);
        }
    }
}
