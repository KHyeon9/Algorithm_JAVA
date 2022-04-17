import java.util.Scanner;

public class _15873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ab = sc.nextInt();
        int a = ab / 10;
        int b = ab % 10;
        if (a > 10){
            a = ab / 100;
            b = ab % 100;
        }
        System.out.println(a + b);

    }
}
