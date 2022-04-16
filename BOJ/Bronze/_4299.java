import java.util.Scanner;

public class _4299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int scoreSum = sc.nextInt();
        int scoreMinus = sc.nextInt();
        int team1 = scoreSum + scoreMinus;
        int team2 = scoreSum - scoreMinus;

        if (team1 % 2 != 0 && team2 % 2 != 0) {
            System.out.println(-1);
        } else {
            if (team1 / 2 >= 0 && team2 / 2 >= 0) {
                System.out.println(team1 / 2 + " " + team2 / 2);
            } else {
                System.out.println(-1);
            }
        }
    }
}
