import java.io.*;
import java.util.*;

public class BOJ7682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            // 탈출 조건
            if (line.equals("end")) {
                break;
            }
            // 틱택토 셋팅 및 o와 x의 각각 갯수 저장
            char[][] tictecto = new char[3][3];
            int idx = 0;
            int oCnt = 0, xCont = 0;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    tictecto[r][c] = line.charAt(idx++);
                    if (tictecto[r][c] == 'O') {
                        oCnt++;
                    } else if (tictecto[r][c] == 'X') {
                        xCont++;
                    }
                }
            }
            // 검사
            boolean isValid = false;
            Set<Character> winResult = checkTictecto(tictecto);
            if (winResult.contains('X') && !winResult.contains('O')) {
                // x만 이기면 x의 돌 갯수가 1개 많아야 함
                isValid = oCnt + 1 == xCont;
            } else if (!winResult.contains('X') && winResult.contains('O')){
                // o가 이기면 2 플레이어의 돌 갯수가 같아야 함
                isValid = oCnt == xCont;
            } else if (!winResult.contains('X') && !winResult.contains('O')){
                // 이긴 사람이 없는 경우 x가 5개 o가 4개여야 함
                isValid = xCont == 5 && oCnt == 4;
            }
            System.out.println(isValid ? "valid" : "invalid");
        }

        br.close();
    }

    private static Set<Character> checkTictecto(char[][] tictecto) {
        Set<Character> answer = new HashSet<>();
        
        for (int i = 0; i < 3; i++) {
            // 빈칸이 아니고 가로가 다 같으면 결과 추가
            if (
                    tictecto[i][0] != '.' &&
                    tictecto[i][0] == tictecto[i][1] &&
                    tictecto[i][1] == tictecto[i][2]
            ) {
                answer.add(tictecto[i][0]);
            }
            // 빈칸이 아니고 세로가 다 같으면 결과 추가
            if (
                    tictecto[0][i] != '.' &&
                    tictecto[0][i] == tictecto[1][i] &&
                    tictecto[1][i] == tictecto[2][i]
            ) {
                answer.add(tictecto[0][i]);
            }
        }
        // 왼쪽 대각선 확인
        if (
                tictecto[0][0] != '.' &&
                tictecto[0][0] == tictecto[1][1] &&
                tictecto[1][1] == tictecto[2][2]
        ) {
            answer.add(tictecto[0][0]);
        }
        // 오른쪽 대각선 확인
        if (
                tictecto[0][2] != '.' &&
                tictecto[0][2] == tictecto[1][1] &&
                tictecto[1][1] == tictecto[2][0]
        ) {
            answer.add(tictecto[0][2]);
        }
        // 총 이긴 플레이어 반환
        return answer;
    }
}
