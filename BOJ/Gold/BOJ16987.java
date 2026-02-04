import java.io.*;
import java.util.*;

public class BOJ16987 {
    static class Egg {
        int hp, weight;

        public Egg(int hp, int weight) {
            this.hp = hp;
            this.weight = weight;
        }
    }
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int eggCnt = Integer.parseInt(br.readLine());
        // 계란 정보 셋팅
        Egg[] eggs = new Egg[eggCnt];
        for (int i = 0; i < eggCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int eggHp = Integer.parseInt(st.nextToken());
            int eggWeight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(eggHp, eggWeight);
        }
        // 최대 부서진 계란 수 구하기
        breakEgg(0, eggs, eggCnt);
        // 최대값 출력
        System.out.println(answer);
    }

    private static void breakEgg(int now, Egg[] eggs, int eggCnt) {
        // 맨 오른쪽인 경우 최대값 계산
        if (now == eggCnt) {
            int cnt = 0;
            for (Egg egg : eggs) {
                cnt += egg.hp <= 0 ? 1 : 0;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        // 현재 계란이 깨져있는 경우 다음 계란으로 이동
        if (eggs[now].hp <= 0) {
            breakEgg(now + 1, eggs, eggCnt);
            return;
        }
        // 계란끼리 부딛히기
        boolean noHit = true;
        for (int next = 0; next < eggCnt; next++) {
            if (next == now || eggs[next].hp <= 0) {
                continue;
            }
            // 백트랙킹
            eggs[now].hp -= eggs[next].weight;
            eggs[next].hp -= eggs[now].weight;
            breakEgg(now + 1, eggs, eggCnt);
            eggs[now].hp += eggs[next].weight;
            eggs[next].hp += eggs[now].weight;
            noHit = false;
        }
        // 계란이 다 깨져있는 경우 결과 계산
        if (noHit) {
            breakEgg(eggCnt, eggs, eggCnt);
        }
    }
}
