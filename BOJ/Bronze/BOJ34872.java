import java.util.Scanner;

public class BOJ34872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // 출력
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n * 3; i++) {
            answer.append((i % n) + 1).append(" ");
        }
        System.out.println(answer);
        sc.close();
    }
}
