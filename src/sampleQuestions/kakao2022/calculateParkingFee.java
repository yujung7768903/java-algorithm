package sampleQuestions.kakao2022;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class calculateParkingFee {
    public static Map<String, LocalTime> tempMap = new HashMap<>();
    public static Map<String, Long> totalTimeMap = new HashMap<>();
    public static int defaultTime, defaultFee, unitTime, unitFee;

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees, records);
    }

    public static int[] solution(int[] fees, String[] records) {
        defaultTime = fees[0];
        defaultFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        for (String record : records) {
            String time = record.substring(0, 5);
            String carNum = record.substring(6, 10);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime localTime = LocalTime.parse(time, timeFormatter);
            // 출차시 입차 시간 빼서 시간 누정하여 totalTimeMap에 저장 후 tempMap에서는 삭제
            System.out.println(tempMap.containsKey(carNum));
            if (tempMap.containsKey(carNum)) {
                System.out.println(tempMap.get(carNum).toString());
                System.out.println(localTime);
                Long totalTime = ChronoUnit.MINUTES.between(tempMap.get(carNum), localTime);
                totalTimeMap.put(carNum, totalTimeMap.get(carNum) + totalTime);
                tempMap.remove(carNum);
            } else { // 입차시 tempMap에 저장
                tempMap.put(carNum, localTime);
                System.out.println(tempMap.get(carNum).toString());
            }
            System.out.println("============================");
        }
        System.out.println("누적 시간: " + totalTimeMap);

        // 차량번호를 오름차순으로 정렬
        List<String> keySet = new ArrayList<>(totalTimeMap.keySet());
        System.out.println(keySet.toString());
        int[] answer = new int[keySet.size()];
        for (int i = 0; i < keySet.size(); i++) {
            // 요금 계산해서 answer에 넣기
            answer[i] = calParkingFee(totalTimeMap.get(keySet.get(i)));
        }
        return answer;
    }

    public static int calParkingFee(Long totalTime) {
        return (int) (defaultFee + Math.ceil((totalTime - defaultTime) / unitTime) * unitFee);
    }
}
