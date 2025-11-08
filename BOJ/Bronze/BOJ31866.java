import java.util.Scanner;

public class BOJ31866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jun = sc.nextInt();
        int ik = sc.nextInt();

        System.out.println(whoWins(jun, ik));
    }

    public static String whoWins(int h1, int h2) {
        boolean junValid = checkFinger(h1);
        boolean ikValid = checkFinger(h2);

        // 둘다 이상한 것을 낸 경우
        if (junValid && ikValid) return "=";
        // 한쪽만 무효인 경우
        if (junValid) return "<";
        if (ikValid) return ">";
        // 같은걸 낸 경우
        if (h1 == h2) return "=";

        return rockPaperScissors(h1, h2) ? ">" : "<";
    }
    // 주먹이나 가위 혹은 보가 아닌 경우 판별
    public static boolean checkFinger(int finger) {
        return !(finger == 0 || finger == 2 || finger == 5);
    }
    // 가위바위보 결과 반환
    public static boolean rockPaperScissors(int h1, int h2) {
        if (h1 == 0 && h2 == 2) return true;
        if (h1 == 2 && h2 == 5) return true;
        if (h1 == 5 && h2 == 0) return true;
        return false;
    }
}
