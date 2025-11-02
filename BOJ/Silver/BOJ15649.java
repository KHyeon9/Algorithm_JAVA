import java.util.Scanner;

public class BOJ15649 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        backtracking(0);
    }

    public static void backtracking(int length) {
         if (length == M) {
             // 수열 출력
             printArray();
             return;
         }
         // 갈 수 있는 모든 선택지
         for (int i = 0; i < N; i++) {
             if (!visited[i]) {
                 visited[i] = true;
                 arr[length] = i;
                 backtracking(length + 1);
                 visited[i] = false;
             }
         }
    }

    private static void printArray() {
        for (int i = 0; i < M; i++) {
            System.out.print(arr[i] + 1 + " ");
        }
    }
}
