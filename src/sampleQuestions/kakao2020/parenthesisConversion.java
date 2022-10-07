// 2020 KAKAO BLIND RECRUITMENT - 괄호 변환

package sampleQuestions.kakao2020;

public class parenthesisConversion {

    public static void main(String[] args) {
        System.out.println("▶️결과" + solution("(()())()"));
        System.out.println("======================");
        System.out.println("▶️결과" + solution(")("));
        System.out.println("======================");
        System.out.println("▶️결과" + solution("()))((()"));
        System.out.println("======================");
    }
    /*
    1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        4-3. ')'를 다시 붙입니다.
        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        4-5. 생성된 문자열을 반환합니다.
    * */
    public static String solution(String p) {
        if (checkValid(p)) return p;
        String answer = replaceBracket(p);
        return answer;
    }

    public static String replaceBracket(String p) {
        System.out.println("p: " + p);
        if (p == "") {
            return "";
        }
        String[] strSplitList = separateString(p);
        String u = strSplitList[0];
        String v = strSplitList[1];
        System.out.println("u: " + u + ", v: " + v);
        if (checkValid(u)) {
            return u + replaceBracket(v);
        } else {
            StringBuffer sb = new StringBuffer("("); // 4-1
            System.out.println("[4-1단계] " + sb);
            sb.append(replaceBracket(v)); // 4-2
            System.out.println("[4-2단계] " + sb);
            sb.append(")"); // 4-3
            System.out.println("[4-3단계] " + sb);
            String newU = u.substring(1, u.length() - 1); // 4-4
            System.out.println("u의 앞뒤 문자를 제거한 나머지 문자열: " + newU);
            if (newU.isBlank()) {
                return String.valueOf(sb);
            }
            String[] splitNewU = newU.split("");
            for (String str : splitNewU) {
                System.out.println(str);
                System.out.println(str == "(");
                sb.append((str.equals("(")) ? ")" : "(");
            }
            System.out.println("[4-3단계] " + sb);
            return String.valueOf(sb);
        }
    }

    // 문자열을 u와 v로 분리 (()) 0123 ()()
    public static String[] separateString(String p) {
        String[] strSplitList = new String[2];
        int leftNum = 0;
        int rightNum = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') leftNum++;
            else rightNum++;

            if (leftNum == rightNum) {
                return new String[]{p.substring(0, i + 1), p.substring(i + 1)};
            }
        }
        return new String[]{p, ""};
    }

    public static boolean checkValid(String p) {
        int leftNum = 0;
        int rightNum = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') leftNum++;
            else rightNum++;

            if (rightNum > leftNum) {
                System.out.println("checkValid: false");
                return false;
            }
        }
        System.out.println("checkValid: true");
        return true;
    }
}
