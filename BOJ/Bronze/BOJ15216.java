import java.util.Scanner;

public class BOJ15216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();

        int[] blocks = new int[n];

        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        // 입력받은 블록에 따른 계산
        int now = w;
        for (int block : blocks) {
            // 현재 층 남은 블록 보다
            // 지금 사용할 블록이 많으면 탈출
            if (now < block || h == 0) {
                break;
            }
            // 현재 가지고 있는 블록만큼 사용
            now -= block;
            if (now == 0) {
                // 현재 층 다 만들면 초기화
                now = w;
                h--;
            }
        }
        System.out.println(h == 0 ? "YES" : "NO");
    }
}
