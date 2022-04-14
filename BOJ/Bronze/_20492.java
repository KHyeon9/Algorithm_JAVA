import java.util.Scanner;

public class _20492 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int money = scanner.nextInt();
        int r1 = (int) (money - (money * 0.22));
        int r2 = (int) (money * 0.8 + ((money * 0.2) - (money * 0.2) * 0.22));


        System.out.println(String.format("%d %d", r1, r2));
    }
}
