import java.util.Scanner;

public class BOJ34750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        System.out.println(solution(money));
    }

    static String solution(int money) {
        double el1 = money;
        double el2 = money;
        // 돈에 따른 조건문
        if (money >= 1000000) {
            el1 *= 0.2;
            el2 *= 0.8;
        } else if (money >= 500000) {
            el1 *= 0.15;
            el2 *= 0.85;
        } else if (money >= 100000) {
            el1 *= 0.1;
            el2 *= 0.9;
        } else {
            el1 *= 0.05;
            el2 *= 0.95;
        }
        return (int) el1 + " " + (int) el2;
    }
}
