import java.io.*;

public class BOJ20125 {
    static int size;
    static char[][] cookiePlate;
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        cookiePlate = new char[size][size];
        // 심장 위치 구하기 및 쿠키판 셋팅
        int heartX = -1, heartY = -1;
        for (int r = 0; r < size; r++) {
            String row = br.readLine();
            for (int c = 0; c < size; c++) {
                cookiePlate[r][c] = row.charAt(c);

                if (cookiePlate[r][c] == '*' &&
                heartX == -1 && heartY == -1) {
                    heartX = r + 1;
                    heartY = c;
                }
            }
        }
        // 각 부위 크기 구하기
        int leftArm = getArm(heartX, heartY, -1);
        int rightArm = getArm(heartX, heartY, 1);
        int body = getPart(heartX + 1, heartY);
        int leftLeg = getPart(heartX + body + 1, heartY - 1);
        int rightLeg = getPart(heartX + body + 1, heartY + 1);
        // 실제 심장 위치 수정 
        System.out.println((heartX + 1) + " " + (heartY + 1));
        // 출력
        System.out.println(
                String.format(
                        "%d %d %d %d %d",
                        leftArm, rightArm, body, leftLeg, rightLeg
                )
        );
        br.close();
    }

    private static int getPart(int startX, int startY) {
        int answer = 0;
        // 팔을 제외하곤 전부 아래로 진행하므로 x값 변경
        for (int i = startX; i < size; i++) {
            if (cookiePlate[i][startY] == '*') {
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
    
    private static int getArm(int heartX, int heartY, int dir) {
        int answer = 0;
        int nowY = heartY + dir;
        // 방향에 따른 값 구하기
        while (0 <= nowY && nowY < size) {
            if (cookiePlate[heartX][nowY] == '*') {
                answer++;
            } else {
                break;
            }
            nowY += dir;
        }
        return answer;
    }
}
