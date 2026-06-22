public class LeetCode258 {
    public static int addDigits(int num) {
        // 문자열로 변환
        String numStr = String.valueOf(num);
        // 길이가 1일 때까지 반복
        while (numStr.length() != 1) {
            // 각 자리수를 더한 수 만들기
            int temp = 0;
            for (char ch : numStr.toCharArray()) {
                temp += ch - '0';
            }
            // 값 변경
            numStr = String.valueOf(temp);
        }
        return Integer.parseInt(numStr);
    }
}
