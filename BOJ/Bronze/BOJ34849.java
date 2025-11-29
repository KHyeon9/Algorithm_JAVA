import java.util.Scanner;

public class BOJ34849 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n <= 10000 ? "Accepted" : "Time limit exceeded");
    }
}
