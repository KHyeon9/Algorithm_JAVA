import java.io.*;
import java.util.*;

public class BOJ9019 {
    static class Registger {
        int num;
        String comm;

        public Registger(int num, String comm) {
            this.num = num;
            this.comm = comm;
        }
    }
    static char[] command = {'D', 'S', 'L', 'R'};
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowNum = Integer.parseInt(st.nextToken());
            int targetNum = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            System.out.println(getRegisterData(nowNum, targetNum));
        }

    }

    private static String getRegisterData(int startNum, int targetNum) {
        visited[startNum] = true;
        Deque<Registger> regDeq = new ArrayDeque<>();
        regDeq.addLast(new Registger(startNum, ""));

        while (!regDeq.isEmpty()) {
            Registger now = regDeq.pollFirst();
            // 타겟이면 결과 반환
            if (now.num == targetNum) {
                return now.comm.toString();
            }
            // 명령어에 따른 계산 후 덱에 저장
            for (int i = 0; i < 4; i++) {
                int nextNum = getNextNum(i, now.num);
                if (!visited[nextNum]) {
                    visited[nextNum] = true;
                    regDeq.addLast(
                            new Registger(nextNum, now.comm + command[i])
                    );
                }

            }
        }
        return "";
    }
    // 다음 숫자 계산
    private static int getNextNum(int comm, int num) {
        switch (comm) {
            case 0: return num * 2 % 10000;
            case 1: return num == 0 ? 9999 : num - 1;
            case 2: return num % 1000 * 10 + num / 1000;
            default: return (num % 10 * 1000) + num / 10;
        }
    }
}
