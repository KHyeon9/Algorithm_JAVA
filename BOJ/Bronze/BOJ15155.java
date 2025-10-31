import java.util.Scanner;

public class BOJ15155 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nowPage = k;
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            int page = sc.nextInt();
            // 현제 남은 페이지 크거나 같은 경우
            if (page <= nowPage) {
                nowPage -= page;
            } else {
                // 페이지가 적게 남으면 증가 및 페이지 빼주기
                cnt++;
                nowPage = k - page;
            }
        }
        System.out.println(cnt);
    }
}
