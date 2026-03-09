import java.io.*;
import java.util.*;

public class BOJ11972 {
    static class DrinkInfo {
        int milkNum, drinkTime;

        public DrinkInfo(int milkNum, int drinkTime) {
            this.milkNum = milkNum;
            this.drinkTime = drinkTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int friendCnt = Integer.parseInt(st.nextToken());
        int milkCnt = Integer.parseInt(st.nextToken());
        int drinkCnt = Integer.parseInt(st.nextToken());
        int sickCnt = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<DrinkInfo>> friends = new HashMap<>();
        for (int i = 0; i < drinkCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int personNum = Integer.parseInt(st.nextToken());
            int milkNum = Integer.parseInt(st.nextToken());
            int drinkTime = Integer.parseInt(st.nextToken());
            
            ArrayList<DrinkInfo> info = friends.getOrDefault(personNum, new ArrayList<>());
            info.add(new DrinkInfo(milkNum, drinkTime));
            friends.put(personNum, info);
        }


        boolean[] isSickPossible = new boolean[milkCnt + 1];
        Arrays.fill(isSickPossible, true);
        for (int i = 0; i < sickCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int personNum = Integer.parseInt(st.nextToken());
            int drinkTime = Integer.parseInt(st.nextToken());

            // 그 사람의 먹은 기록이 있는 경우 검사
            List<DrinkInfo> history = friends.get(personNum);
            Set<Integer> drinkSet = new HashSet<>();
            if (history != null) {
                // 아픈 시간 이전의 모든 우유 번호 저장
                for (DrinkInfo info : history) {
                    if (info.drinkTime < drinkTime) {
                        drinkSet.add(info.milkNum);
                    }
                }
            }
            // 아픈 사람의 우유에 포함 되지 않으면 false
            for (int m = 1; m <= milkCnt; m++) {
                if (!drinkSet.contains(m)) {
                    isSickPossible[m] = false;
                }
            }
        }
        // 필요한 약 갯수 구하기
        int needMedicineCnt = 0;
        for (int m = 1; m <= milkCnt; m++) {
            if (isSickPossible[m]) {
                int cnt = 0;
                for (int p = 1; p <= friendCnt; p++) {
                    // 먹은 우유가 없으면 넘어감
                    if (friends.get(p) == null) continue;
                    // 먹은 우유 중 해당 우유가 있으면 갯수 추가
                    for (DrinkInfo info : friends.get(p)) {
                        if (info.milkNum == m) {
                            cnt++;
                            break;
                        }
                    }
                }
                needMedicineCnt = Math.max(needMedicineCnt, cnt);
            }
        }
        System.out.println(needMedicineCnt);
        br.close();
    }
}
