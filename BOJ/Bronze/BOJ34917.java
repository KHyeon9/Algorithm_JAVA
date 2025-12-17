import java.util.Scanner;

public class BOJ34917 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (isValid(j, k, n)) {
                        sb.append("#");
                    } else {
                        sb.append(".");
                    }
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }
    }
    // 조건 확인
    private static boolean isValid(int row, int col, int n) {
        // 열이 0 or n - 1인 경우
        // 전체 행의 반절 이하인 경우 중에서도 row와 col이 같거나
        // 뒤에서 row - 1만큼 뺀 값만 true
        return (col == 0 || col == n - 1 ||
                (row <= n / 2 && (col == row || col == n - row - 1)));
    }
}
