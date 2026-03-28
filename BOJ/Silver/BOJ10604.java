import java.io.*;

public class BOJ10604 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int totalMin = 0;
        while (true) {
            String line = br.readLine();

            if (line.equals("$$$") || line.equals("###")) {
                System.out.println(String.format("%d:%02d", totalMin / 60, totalMin % 60));
                // ###이면 탈출
                if (line.equals("###")) {
                    break;
                }
                // $$$이면 다음 테스트 케이스를 위해 초기화
                totalMin = 0;
                continue;
            }
            // 부호와 분리
            char calc = line.charAt(0);
            line = line.substring(1);
            // 정규 표현식으로 . 또는 :를 기준으로 나누기
            String[] parts = line.split("[.:]");
            // 시간 처리
            int nowHour = parts[0].isEmpty() ? 0 : Integer.parseInt(parts[0]);
            // 분 처리 (길이가 1이하인 경우 시간만 존재)
            int nowMin = 0;
            if (parts.length > 1) {
                nowMin = parts[1].isEmpty() ? 0 : Integer.parseInt(parts[1]);
            }
            // 현재 시간을 분으로 환산해 부호에 따라 저장
            int nowTotal = nowHour * 60 + nowMin;
            totalMin += calc == '+' ? nowTotal : -nowTotal;
        }
    }
}
