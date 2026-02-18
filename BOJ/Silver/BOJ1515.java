import java.util.*;

public class BOJ1515 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] nums = sc.next().toCharArray();
        // 계산
        int answer = 1, idx = 0;
        while (true) {
            String now = String.valueOf(answer);
            // 현재 숫자에 해당 숫자가 포함되는지 확인
            for (int i = 0; i < now.length(); i++) {
                // 범위를 넘기지 않고 보함하면 다음 숫자 비교
                if (idx < nums.length && now.charAt(i) == nums[idx]) {
                    idx++;
                }
            }
            // 범위 벗어나면 탈출
            if (idx >= nums.length) break;
            // 다음 숫자로 증가
            answer++;
        }
        System.out.println(answer);
    }
}
