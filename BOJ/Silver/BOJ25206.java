import java.util.Scanner;

public class BOJ25206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalScore = 0;
        double total = 0;

        for (int i = 0; i < 20; i++) {
            String name = sc.next();
            double score = sc.nextDouble();
            String grade = sc.next();
            // P인 경우 제외
            if (grade.equals("P")) {
                continue;
            }
            // 학점에 따른 점수 가져와서 계산
            double gradeScore = getGradeScore(grade);
            double calc = score * gradeScore;

            totalScore += score;
            total += calc;
        }

        System.out.println(String.format("%.6f", total / totalScore));
    }

    private static double getGradeScore(String grade) {
        switch (grade) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            default: return 0.0;
        }
    }
}
