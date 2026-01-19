import java.io.*;

public class BOJ18271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        // 이전 각 팀의 점수 히스토리가 필요하므로 저장
        int[][] scoreHistory = new int[n + 1][2];
        int[] teamScore = new int[2];
        for (int i = 1; i <= n; i++) {
            int goalTeam = Integer.parseInt(br.readLine());
            teamScore[goalTeam - 1]++;
            // teamScore로 바로 저장하면 주소 문제 발생 위험으로
            // 각각 따로 저장
            scoreHistory[i][0] = teamScore[0];
            scoreHistory[i][1] = teamScore[1];
        }

        int equal = 1;
        int maxTurnOver = 0;
        for (int i = 1; i <= n; i++) {
            // 2개가 같은 경우 equal 증가
            if (scoreHistory[i][0] == scoreHistory[i][1]) {
                equal++;
            }
            // 현재 골 넣은 팀과 다른 팀 확인
            int nowGoal = scoreHistory[i - 1][0] < scoreHistory[i][0] ? 0 : 1;
            int other = nowGoal == 0 ? 1 : 0;
            // 현재 지고있어서 역전할 수 있는지 확인
            if (scoreHistory[i - 1][nowGoal] < scoreHistory[i - 1][other]) {
                int nowTurnOver = getTurnOverValue(scoreHistory, i, nowGoal);
                maxTurnOver = Math.max(maxTurnOver, nowTurnOver);
            }
        }
        System.out.println(teamScore[0] + " " + teamScore[1]);
        System.out.println(equal);
        System.out.println(maxTurnOver);
    }
    // 최대 역전 골 갯수 구하기
    private static int getTurnOverValue (int[][] scoreHistory, int start, int team1) {
        int answer = 0;
        int team2 = team1 == 0 ? 1 : 0;
        boolean isTurnOver = false;
        
        for (int j = start; j < scoreHistory.length ; j++) {
            // 상대 팀이 골을 넣으면 연속골이 아니므로 탈출
            if (scoreHistory[j][team2] > scoreHistory[j - 1][team2]) {
                break;
            }
            answer = j - start + 1;
            // 연속 골을 넣다가 역전한 경우 최대값 갱신 및 탈출
            if (scoreHistory[j][team1] > scoreHistory[j][team2]) {
                isTurnOver = true;
            }
        }
        return isTurnOver ? answer : 0;
    }
}
