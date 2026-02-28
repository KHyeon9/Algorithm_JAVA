import java.io.*;
import java.util.*;

public class BOJ9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {
            int dataCnt = Integer.parseInt(br.readLine());
            // 6명 이상인 팀을 구별하기 위해 입력값 저장 및 셋팅
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> teamCnt = new HashMap<>();
            int[] teamOrder = new int[dataCnt];
            for (int i = 0; i < dataCnt; i++) {
                int nowTeam = Integer.parseInt(st.nextToken());
                teamOrder[i] = nowTeam;
                teamCnt.put(nowTeam, teamCnt.getOrDefault(nowTeam, 0) + 1);
            }
            // 6명 이상인 팀의 점수 저장
            Map<Integer, ArrayList<Integer>> teamScore = new HashMap<>();
            int nowScore = 1;
            for (int team : teamOrder) {
                // 6명 이상인 팀을 기준으로 점수를 매겨야 하므로 조건식 사용
                if (teamCnt.get(team) == 6) {
                    ArrayList<Integer> nowTeamList = teamScore.getOrDefault(team, new ArrayList<>());
                    nowTeamList.add(nowScore++);
                    teamScore.put(team, nowTeamList);
                }
            }
            // 최소 점수 계산
            int winningTeam = -1;
            int minScore = Integer.MAX_VALUE;
            int minFiveScore = Integer.MAX_VALUE;
            for(int team : teamScore.keySet()) {
                List<Integer> nowTeamScoreList = teamScore.get(team);
                // 현재 점수 계산
                int caclScore = 0;
                for (int i = 0; i < 4; i++) {
                    caclScore += nowTeamScoreList.get(i);
                }
                // 최소값이 같은 경우 계산을 위한 값 저장
                int fiveScore = nowTeamScoreList.get(4);
                // 최소값보다 작은 경우
                if (minScore > caclScore) {
                    minFiveScore = fiveScore;
                    minScore = caclScore;
                    winningTeam = team;
                } else if (minScore == caclScore && minFiveScore > fiveScore) {
                    // 최소값과 같고 5번째 값도 작은 경우
                    winningTeam = team;
                    minFiveScore = fiveScore;
                }
            }
            System.out.println(winningTeam);
        }
        br.close();
    }
}
