import java.util.Scanner;

public class BOJ2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(minSum(n));
    }
    // 최소 분해합 구하기
    private static int minSum(int num) {
        int answer = Integer.MAX_VALUE;

        for (int n = 1; n <= num; n++) {
            // 문자열로 변환해 숫자 돌면서 각 자리수 합
            String numStr = "" + n;
            int sum = 0;
            for (char c : numStr.toCharArray()) {
                sum += c - '0';
            }
            // 현재 수와 각 자리수의 합 계산
            sum += n;
            // 분해합이 입력된 수와 같고 현재 최소값보다 작으면 저장
            if (sum == num && answer > sum) {
                answer = n;
            }
        }
        return answer <= num ? answer : 0;
    }
}
