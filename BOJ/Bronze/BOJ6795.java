import java.util.Scanner;

public class BOJ6795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int s = sc.nextInt();

        int nikkyStep = simulation(a, b, s);
        int byronStep = simulation(c, d, s);

        if (nikkyStep > byronStep) {
            System.out.println("Nikky");
        } else if (nikkyStep < byronStep) {
            System.out.println("Byron");
        } else {
            System.out.println("Tied");
        }
    }
    // 위치 계산
    private static int simulation(int front, int back, int total) {
        int pos = 0;
        int cycle = front + back;

        for (int i = 0; i < total; i++) {
            // 앞으로 가는 숫자보다 작으면 앞으로 아니면 뒤로
            pos += i % cycle < front ? 1 : -1;
        }

        return pos;
    }
}
