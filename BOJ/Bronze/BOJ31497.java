import java.util.Scanner;

public class BOJ31497 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        String result = "";
        // 모든 사람 순회하면서 물어보기
        for (int i = 0; i < n; i++) {
            System.out.println("? " + names[i]);
            // 인터렉티브 문제이므로 상대방에게 값을 넘겨줌
            System.out.flush();
            // 생일이 맞는지 상대방이 알려줌
            int answer1 = sc.nextInt();
            if (answer1 == 1) {
                // 1이 나왔으면 진짜인지 확인하기 위해 한 번 더 질문
                System.out.println("? " + names[i]);
                System.out.flush();
                // 생일이 맞는지 다시 물어본 것의 대답
                int answer2 = sc.nextInt();
                if (answer2 == 1) {
                    // 2번 질문이 1이면 생일자
                    result = names[i];
                    break;
                }
            }
        }
        // 만약 위에서 못 찾았다면 다시 확인 (전부 0이 나온 경우)
        for (int i = 0; i < n; i++) {
            System.out.println("? " + names[i]);
            System.out.flush();
            // 다시 질문
            int res = sc.nextInt();
            if (res == 1) {
                result = names[i];
                break;
            }
        }

        System.out.println("! " + result);
        System.out.flush();
    }
}
