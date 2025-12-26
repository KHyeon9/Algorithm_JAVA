import java.util.Scanner;

public class BOJ13909 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        // 1부터 n까지 제곱수의 갯수를 구하는 문제
        System.out.println((int) Math.sqrt(n));
    }
}
