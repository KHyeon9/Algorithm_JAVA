import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ34797 {
    // 사용할 map들 static으로 전역에서 사용가능하도록 선언
    static Map<Character, Double> gradeMap = new HashMap<>();
    static Map<Character, Double> tierMap = new HashMap<>();

    static {
        gradeMap.put('A', 4.0);
        gradeMap.put('B', 3.0);
        gradeMap.put('C', 2.0);
        gradeMap.put('D', 1.0);
        gradeMap.put('E', 0.0);

        tierMap.put('1', 0.05);
        tierMap.put('2', 0.025);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        double bonus = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char grade = s.charAt(0);
            double tier = s.charAt(1);
            // 기본 점수 합
            total += gradeMap.get(grade);
            // 보너스
            if (grade == 'A' || grade == 'B' || grade == 'C') {
                if (tier == '1') bonus += 0.05;
                else if (tier == '2') bonus += 0.025;
            }
        }

        System.out.println(total / n + bonus);
    }
}
