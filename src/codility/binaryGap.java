package codility;

import java.util.ArrayList;
import java.util.Collections;

public class binaryGap {
    public static void main(String[] args) {
        System.out.println(solution(32));
    }

    public static int solution(int N) {
        // write your code in Java SE 11
        ArrayList<Integer> gapList = new ArrayList<>();
        int indexOfLast1 = -1;
        String binaryN = Integer.toBinaryString(N);

        System.out.println(binaryN);
        for (int i = 0; i < binaryN.length(); i++) {
            System.out.println("i: " + i);
            if (binaryN.charAt(i) == '1') {
                if (indexOfLast1 >= 0) {
                    gapList.add(i - indexOfLast1 - 1);
                    System.out.println("indexOfLast1: " + indexOfLast1);
                    System.out.println(gapList.toString());
                }
                indexOfLast1 = i;
            }
        }

        if (!gapList.isEmpty()) {
            return Collections.max(gapList);
        } else {
            return 0;
        }
    }
}
