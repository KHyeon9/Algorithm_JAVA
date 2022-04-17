import java.util.Scanner;

public class _8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String ox = sc.next();
            int score = 0;
            int cnt = 0;

            for (int j = 0; j < ox.length(); j++){
                cnt += 1;
                if (ox.charAt(j) == 'O') {
                    score += cnt;
                } else {
                    cnt = 0;
                }
            }

            System.out.println(score);
        }

    }
}
