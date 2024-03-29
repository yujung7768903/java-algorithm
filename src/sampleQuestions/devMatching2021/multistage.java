package sampleQuestions.devMatching2021;

import java.util.*;

public class multistage {

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {1, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> sellResultMap = new HashMap<>(); // key: 판매자, value: 누적 수익 | ex: {young=90, mary=1, tod=0, edward=9, john=0, emily=0, sam=0, jaimie=0}
        Map<String, String> referralMap = new HashMap<>(); // key: 판매자, value: 추천인 | ex: {young=edward, mary=-, tod=jaimie, edward=mary, john=-, emily=mary, sam=edward, jaimie=mary}

        for (int i = 0; i < enroll.length; i++) {
            referralMap.put(enroll[i], referral[i]);
            sellResultMap.put(enroll[i], 0);
        }

        for (int j = 0; j < seller.length; j++) {
            String sellerName = seller[j];
            int[] dividedProfit = divideProfit(amount[j] * 100, sellResultMap.get(sellerName));
            sellResultMap.replace(sellerName, dividedProfit[0]);
            System.out.println("(31)판매자: " + sellerName + ", 누적 수익금: " + sellResultMap.get(sellerName));
            // 배분
            while (!referralMap.get(sellerName).equals("-") && dividedProfit[1] != 0) { // 최초 가입자까지만 반복
                sellerName = referralMap.get(sellerName); // 추천인
                dividedProfit = divideProfit(dividedProfit[1], sellResultMap.get(sellerName));
                sellResultMap.replace(sellerName, dividedProfit[0]);
                System.out.println("(37)판매자: " + sellerName + ", 누적 수익금: " + sellResultMap.get(sellerName));
            }
            System.out.println("✨중간점검 ✨: " + sellResultMap.toString());
            System.out.println("====================");
        }
        for (int k = 0; k < enroll.length; k++) {
            answer[k] = sellResultMap.get(enroll[k]);
        }

        return answer;
    }

    /*
    * Parameters
    *   money: 판매 금액 or 배분받은 금액
    *   profit: 현재까지 누적 수익
    * Returns: {누적 수익, 배분금}
    * */
    public static int[] divideProfit(int money, int profit) { // 판매 금액 or 배분받은 금액, 현재까지 누적 수익
        System.out.println("money: " + money + ", profit: " + profit);
        if (money >= 10) {
            int allotment = (int) (money * 0.1); // 배분금
            return new int[]{profit + money - allotment, allotment};
        } else {
            return new int[]{profit + money, 0};
        }
    }

}
