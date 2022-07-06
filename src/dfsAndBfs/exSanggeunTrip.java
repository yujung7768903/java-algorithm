package dfsAndBfs;

import java.util.Scanner;

public class exSanggeunTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int j = 0; j < m; j++) {
                int node1 = scanner.nextInt();
                int node2 = scanner.nextInt();
            }
            result[i] = n - 1;
        }

        for (int item : result) {
            System.out.println(item);
        }
    }
}
