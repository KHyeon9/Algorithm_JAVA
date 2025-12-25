import java.util.Scanner;

public class BOJ1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        // 분모
        int denom = b * d;
        // 분자
        int numer = (a * d) + (b * c);
        int gcd = getGcd(denom, numer);

        // 공약수가 있는 경우 필요없는 값이 곱해진 것을 
        // 나누기로 제거
        System.out.println((numer / gcd) + " " + (denom / gcd));
    }

    private static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
}
