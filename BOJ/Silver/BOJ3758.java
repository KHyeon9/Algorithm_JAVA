import java.io.*;
import java.util.*;

public class BOJ3758 {
    static class TeamInfo {
        int id;
        int[] problemScore;
        int totalScore = 0;
        int submitCnt = 0;
        int lastSubmitTime = 0;

        public TeamInfo (int id, int problemCnt) {
            this.id = id;
            this.problemScore = new int[problemCnt + 1];
        }
        // 점수 업데이트 메소드
        public void updateScore(int problemNum, int score, int time) {
            // 계산에 필요한 입력 횟수와 마지막 입력 시간 계싼
            this.submitCnt++;
            this.lastSubmitTime = time;
            // 저장된 값과 비교
            int storeProblemScore = problemScore[problemNum];
            if (storeProblemScore < score) {
                // 저장된 점수보다 큰경우 교체 및 총 점수 계산
                this.totalScore -= storeProblemScore;
                problemScore[problemNum] = score;
                this.totalScore += score;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamCnt = Integer.parseInt(st.nextToken());
            int problemCnt = Integer.parseInt(st.nextToken());
            int myTeamId = Integer.parseInt(st.nextToken());
            int logCnt = Integer.parseInt(st.nextToken());
            // 팀 정보 배열과 각 배열에 문제 배열 셋팅
            TeamInfo[] teamInfos = new TeamInfo[teamCnt + 1];
            for (int id = 1; id <= teamCnt; id++) {
                teamInfos[id] = new TeamInfo(id, problemCnt);
            }
            // 문제 제출한 팀과 문제 정보 받기
            for (int time = 0; time < logCnt; time++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int nowProblemNum = Integer.parseInt(st.nextToken());
                int getScore = Integer.parseInt(st.nextToken());

                teamInfos[id].updateScore(nowProblemNum, getScore, time);
            }
            // 순위 계산을 위한 정렬 (범위를 1부터 해야하므로 중간에 범위 지정)
            Arrays.sort(teamInfos, 1, teamCnt + 1, (o1, o2) -> {
                // 비교 원소의 총 점수가 같은 경우
                if (o1.totalScore == o2.totalScore) {
                    // 입력 횟수가 같은 경우
                    if (o1.submitCnt == o2.submitCnt) {
                        // 빠른 입력 시건 순으로 정렬
                        return o1.lastSubmitTime - o2.lastSubmitTime;
                    }
                    // 더 적은 입력 횟수 순으로 정렬
                    return o1.submitCnt - o2.submitCnt;
                }
                // 총 점수가 큰 순서로 정렬
                return o2.totalScore - o1.totalScore;
            });
            // 순위 구하기 및 출력
            for (int rank = 1; rank <= teamCnt; rank++) {
                if (teamInfos[rank].id == myTeamId) {
                    System.out.println(rank);
                    break;
                }
            }
        }
        br.close();
    }
}
