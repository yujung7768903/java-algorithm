package practiceQuestions;

import java.util.Arrays;

public class 전화번호목록 {
    public static void main(String[] args) {
        String[] strs = {"123", "12", "119", "97674223", "1195524421"};
        Arrays.sort(strs);
        Arrays.stream(strs).forEach(System.out::println);
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
}
