import java.util.Scanner;

public class BOJ34891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextInt();
        double m = sc.nextInt();

        System.out.println((int) (Math.ceil(n / m)));
    }
}
