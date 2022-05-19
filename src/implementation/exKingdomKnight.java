package implementation;

import java.util.Scanner;

public class exKingdomKnight {

    public static void main(String[] args) {
        int answer = 0;
        Scanner scanner = new Scanner(System.in);
        String knightPos = scanner.nextLine();
        
        int x = knightPos.charAt(1) - '0';
        int y = knightPos.charAt(0) - 'a' + 1;

        int[] dx = {-2, -2, -1, 1, 2, 2, -1, 1};
        int[] dy = {-1, 1, 2, 2, -1, 1, -2, -2};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) answer++;
        }

        System.out.println(answer);
    }
}
