import java.util.Scanner;

public class BOJ34665 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(a.equals(b) ? 0 : 1550);
    }
}
