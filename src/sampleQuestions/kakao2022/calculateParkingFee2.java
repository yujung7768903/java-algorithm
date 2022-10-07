// 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산하기

package sampleQuestions.kakao2022;

import java.util.*;

public class calculateParkingFee2 {
    public static Map<String, String> tempMap = new HashMap<>();
    public static Map<String, Integer> totalTimeMap = new HashMap<>();
    public static int defaultTime, defaultFee, unitTime, unitFee;

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        defaultTime = fees[0];
        defaultFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        for (String record : records) {
            String time = record.substring(0, 5);
            String carNum = record.substring(6, 10);
            // 출차시 입차 시간 빼서 시간 누정하여 totalTimeMap에 저장 후 tempMap에서는 삭제
            if (tempMap.containsKey(carNum)) {
                System.out.println("inTime: " + tempMap.get(carNum).toString());
                System.out.println("outTime: " + time);
                System.out.println("현재 누적시간: " + totalTimeMap.get(carNum));
                int parkingTime = calParkingTime(tempMap.get(carNum), time);
                int totalTime = (totalTimeMap.get(carNum) == null) ? parkingTime : totalTimeMap.get(carNum) + parkingTime;
                totalTimeMap.put(carNum, totalTime);
                System.out.println("최종 누적시간: " + totalTimeMap.get(carNum));
                tempMap.remove(carNum);
            } else { // 입차시 tempMap에 저장
                tempMap.put(carNum, time);
                System.out.println(tempMap.get(carNum).toString());
            }
            System.out.println("============================");
        }

        // 입차만 있고 출차 기록이 없다면, 11:59분 추가
        for (String key : tempMap.keySet()) {
            int parkingTime = calParkingTime(tempMap.get(key), "23:59");
            System.out.println("주차 시간: " + parkingTime);
            int totalTime = (totalTimeMap.get(key) == null) ? parkingTime : totalTimeMap.get(key) + parkingTime;
            totalTimeMap.put(key, totalTime);
            System.out.println("누적 시간: " + totalTimeMap);
        }

        // 차량번호를 오름차순으로 정렬
        List<String> keySet = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(keySet);
        System.out.println(keySet.toString());
        int[] answer = new int[keySet.size()];
        for (int i = 0; i < keySet.size(); i++) {
            String carNum = keySet.get(i);
            answer[i] = calParkingFee(totalTimeMap.get(carNum));
        }
        return answer;
    }

    public static int calParkingTime(String inTime, String outTime) {
        String[] intTimeSplit = inTime.split(":");
        String[] outTimeSplit = outTime.split(":");
        int inHour = Integer.parseInt(intTimeSplit[0]);
        int inMin = Integer.parseInt(intTimeSplit[1]);
        int outHour = Integer.parseInt(outTimeSplit[0]);
        int outMin = Integer.parseInt(outTimeSplit[1]);
        return (outHour * 60 + outMin) - (inHour * 60 + inMin);
    }

    public static int calParkingFee(int totalTime) {
        if (totalTime <= defaultTime) {
            return defaultFee;
        } else {
            return (int) (defaultFee + Math.ceil((totalTime - defaultTime) / (double) unitTime) * unitFee);
        }
    }
}
