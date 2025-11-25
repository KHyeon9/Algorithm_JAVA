import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ18766 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();

            String[] before = new String[n];
            String[] after = new String[n];

            for (int j = 0; j < n; j++) before[j] = sc.next();
            for (int j = 0; j < n; j++) after[j] = sc.next();
            // 2개의 배열 정렬
            Arrays.sort(before);
            Arrays.sort(after);
            // 정렬한 배열이 같으면 치터가 아님
            System.out.println(Arrays.equals(before, after) ? "NOT CHEATER" : "CHEATER");
        }
        sc.close();
    }

}
