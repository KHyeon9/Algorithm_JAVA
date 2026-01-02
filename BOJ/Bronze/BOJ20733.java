import java.util.*;

public class BOJ20733 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        // 문자열 길이 구하기
        int divLength = str.length() / 3;
        // 3 덩이로 문자열 나누기
        String first = str.substring(0, divLength);
        String second = str.substring(divLength, divLength * 2);
        String third = str.substring(divLength * 2);
        // 각 위치 문자 비교
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < divLength; i++) {
            char firstChar = first.charAt(i);
            char secondChar = second.charAt(i);
            char thirdChar = third.charAt(i);

            if (firstChar == secondChar || firstChar == thirdChar) {
                // 첫번째와 두번째 혹은 첫번째와 세번째 같은 경우
                answer.append(firstChar);
            } else {
                // 두 조건이 아닌 경우
                answer.append(secondChar);
            }
        }

        System.out.println(answer);


    }
}
