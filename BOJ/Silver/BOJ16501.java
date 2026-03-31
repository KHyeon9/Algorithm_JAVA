import java.io.*;
import java.util.*;

public class BOJ16501 {
    static boolean[] visited = new boolean[8];
    static double[] teamScore = new double[8];
    static double[] tempTeam = new double[8];
    static double answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 팀 실력 점수 받기
        for (int i = 0; i < 8; i++) {
            teamScore[i] = Double.parseDouble(st.nextToken());
        }
        // 백트래킹으로 모든 경우의 수 계산
        backtracking(0);
        // 소수점 계산
        String answerStr = String.format("%.2f", answer);
        if (answerStr.charAt(answerStr.length() - 1) == '0') {
            answerStr = answerStr.substring(0, answerStr.length() - 1);
        }
        System.out.println(answerStr);
    }

    private static void backtracking(int depth) {
        if (depth == 8) {
            // 각 팀의 평균 계산
            double team1 = (tempTeam[0] + tempTeam[1]) / 2.0;
            double team2 = (tempTeam[2] + tempTeam[3]) / 2.0;
            double team3 = (tempTeam[4] + tempTeam[5]) / 2.0;
            double team4 = (tempTeam[6] + tempTeam[7]) / 2.0;
            // 만족도 계산
            double happy1 = 1 - (Math.abs(team1 - team2) / 10.0);
            double happy2 = 1 - (Math.abs(team3 - team4) / 10.0);
            // 현재 최대 만족도 계산
            answer = Math.max(answer, Math.min(happy1, happy2));
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempTeam[depth] = teamScore[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
