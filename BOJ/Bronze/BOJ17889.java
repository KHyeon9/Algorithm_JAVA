import java.util.*;

public class BOJ17889 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nowYear = sc.nextInt();
        int baseYear = 2018;
        int baseMonth = 4;
        // 기본 시작점에서 26개월씩 증가하며 계산
        while (baseYear < nowYear) {
            baseMonth += 26;
            // 기본 월이 12이하일 경우까지 계산
            while (baseMonth > 12) {
                baseMonth -= 12;
                baseYear++;
            }
        }
        System.out.println(baseYear == nowYear ? "yes" : "no");
        sc.close();
    }
}
