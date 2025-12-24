import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<Integer, Boolean> numMap = new HashMap<>();
        // map에 값이 주어지면 ture를 value로 저장
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            numMap.put(num, true);
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int findNum = sc.nextInt();
            // 값이 있으면 true 없으면 false
            boolean isFind = numMap.getOrDefault(findNum, false);
            System.out.print((isFind ? 1 : 0) + " ");
        }

        sc.close();
    }
}
