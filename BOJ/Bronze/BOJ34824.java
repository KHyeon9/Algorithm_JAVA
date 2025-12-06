import java.util.Scanner;

public class BOJ34824 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int koIdx = -1;
        int yonIdx = -1;

        for (int i = 0; i < n; i++) {
            String univ = sc.next();

            if (univ.equals("yonsei")) {
                yonIdx = i;
            } else if (univ.equals("korea")) {
                koIdx = i;
            }
        }

        System.out.println(yonIdx < koIdx ? "Yonsei Won!" : "Yonsei Lost...");
    }
}
