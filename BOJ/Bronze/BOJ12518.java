import java.util.Scanner;

public class BOJ12518 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int t = 1; t <= n; t++) {
            String name = sc.next();
            System.out.println(String.format("Case #%d: %s is ruled by %s.", t, name, solution(name)));
        }
    }

    public static String solution(String name) {
        String last = name.substring(name.length() - 1).toLowerCase();
        // y이면 혼란
        if (last.equals("y")) return "nobody";
        // 모음이면 여왕
        if ("aeiou".contains(last)) return "a queen";
        // 둘다 아니면 킹
        return "a king";
    }
}
