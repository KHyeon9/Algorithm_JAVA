import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static boolean[] visited;
    static int minGap = Integer.MAX_VALUE;
    static int[][] abilitys;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        // visited 초기화
        visited = new boolean[size];
        // 각각 능력치 초기화
        abilitys = new int[size][size];
        for (int row = 0; row < size; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < size; col++) {
                abilitys[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        // 백트래킹 로직
        minAbilityGap(0, 0, size);

        System.out.println(minGap);
    }

    private static void minAbilityGap(int depth, int start, int size) {
        // 골라야 하는 인원수
        int chooseCnt = size / 2;
        // 골라야 하는 인원수 만큼 고른 경우
        if (depth == chooseCnt) {
            // 능력치 차이 계산 및 최소인지 확인
            calcAbilityGap(chooseCnt);
            return;
        }
        // visited를 이용해 정해진 인원수 만큼 true로 변환
        for (int i = start; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                minAbilityGap(depth + 1, i + 1, size);
                visited[i] = false;
            }
        }
    }
    // 나눠진 팀을 기준으로 능력치 최소 차이 구하기
    private static void calcAbilityGap(int teamSize) {
        // 총 사이즈는 teamSize * 2 값이므로
        int totalSize = teamSize * 2;
        // 팀 나누기
        int[] start = new int[teamSize];
        int[] link = new int[teamSize];
        // visited를 기준으로 검사하기 때문에 
        // start팀과 link팀의 index는 따로 계산
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < totalSize; i++) {
            if (visited[i]) {
                start[idx1++] = i;
            } else {
                link[idx2++] = i;
            }
        }
        // 각 팀 총 능력치 구하기
        int startAbility = 0;
        int linkAbility = 0;
        for (int i = 0; i < teamSize; i++) {
            for (int j = i + 1; j < teamSize; j++) {
                int startPos1 = start[i], startPos2 = start[j];
                int linkPos1 = link[i], linkPos2 = link[j];
                // 예를 들어 1, 2와 2, 1의 능력치와 같이
                // x, y를 바꾼 두 값을 구하고 총합에 더함
                startAbility += abilitys[startPos1][startPos2] + abilitys[startPos2][startPos1];
                linkAbility += abilitys[linkPos1][linkPos2] + abilitys[linkPos2][linkPos1];
            }
        }
        int nowGap = Math.abs(startAbility - linkAbility);
        minGap = Math.min(minGap, nowGap);
    }
}
