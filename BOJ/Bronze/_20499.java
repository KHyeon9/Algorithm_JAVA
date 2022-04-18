import java.util.Scanner;

public class _20499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] kda = sc.nextLine().split("/");
        int result = Integer.parseInt(kda[0]) + Integer.parseInt(kda[2]);
        int d = Integer.parseInt(kda[1]);
        if (result < d || d == 0) {
            System.out.println("hasu");
        } else {
            System.out.println("gosu");
        }

    }
}
