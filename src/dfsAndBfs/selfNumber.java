// 백준 4673 셀프 넘버

package dfsAndBfs;

public class selfNumber {
    public static boolean[] hasCons = new boolean[10000];

    public static void main(String[] args) {
        for (int i = 1; i < 10000; i++) {
            int dn = d(i);

            if (dn < 10000) {
                hasCons[dn] = true;
            }
        }

        for (int j = 1; j < 10000; j++) {
            if (!hasCons[j]) {
                System.out.println(j);
            }
        }
    }

    public static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }

        return sum;
    }
}
