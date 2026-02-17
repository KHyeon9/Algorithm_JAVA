import java.io.*;

public class BOJ14383 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());

        for (int test = 0; test < testCase; test++) {
            String cake = br.readLine();
            int cakeLength = cake.length();
            // 마지막빵의 웃는 면이 아래면 1로 셋팅
            // 전체가 같은 모양으로 맞추고 결과로 +로 바꿔야함
            // 따라서 마지막이 -면 한번더 뒤집어야 함
            int boderCnt = cake.charAt(cakeLength - 1) == '-' ? 1 : 0;
            // -와 +를 압축하기 위해 경계 찾기
            char now = cake.charAt(0);
            for (int i = 1; i < cakeLength; i++) {
                // 현재 시작과 다르면 경계 추가 및 현재 모양 저장
                if (now != cake.charAt(i)) {
                    boderCnt++;
                    now = cake.charAt(i);
                }
            }
            System.out.printf("Case #%d: %d\n", test + 1, boderCnt);
        }
        br.close();
    }
}
