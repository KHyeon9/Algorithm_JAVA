import java.util.Scanner;

public class BOJ2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        int[][] apart = new int[15][15];
        for (int i = 0; i < 15; i++) {
            apart[0][i] = i;
        }

        for (int i = 0; i < testCase; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            for (int row = 1; row <= k; row++) {
                for (int col = 1; col <= n; col++) {
                    apart[row][col] = apart[row - 1][col] + apart[row][col - 1];
                }
            }

            System.out.println(apart[k][n]);
        }
    }
}
