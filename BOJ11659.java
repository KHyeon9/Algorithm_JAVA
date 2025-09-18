import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ11659 {
    public static void main(String[] args) {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] sumList = new long[N + 1];
        // 구간 합 리스트 만들기
        for (int i = 1; i < N + 1; i++) {
            long num = sc.nextLong();
            sumList[i] = sumList[i - 1] + num;
        }
        // 입력 받기 및 출력
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sumList[end] - sumList[start - 1]);
        }
    }
}
