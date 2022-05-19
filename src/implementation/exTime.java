package implementation;

import java.util.Scanner;

public class exTime {
    public static boolean check3(int h, int m, int s) {
        if (Integer.toString(h).contains("3") || Integer.toString(m).contains("3") || Integer.toString(s).contains("3")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;

        for (int hour = 0; hour <= n; hour++) {
            for (int min = 0; min <= 60; min++) {
                for (int sec = 0; sec <= 60; sec++) {
                    if (check3(hour, min, sec)) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
