import java.io.*;
import java.util.*;

public class BOJ34991 {
    static String id = "toycartoon";

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        
        // 겹치는 부분 시작점과 시작점 부터 겹치는 부분 저장
        int startIdx = -1;
        String O = "";
        for (int len = S.length(); len >= 0; len--) {
            String substr = S.substring(0, len);
            if (id.contains(substr)) {
                startIdx = id.indexOf(substr);
                O = substr;
                break;
            }
        }
        StringBuilder answer = new StringBuilder();
        if (O.equals("")) {
            // 겹치는 부분 없으면 _와 결합
            answer.append(id).append("_").append(S);
        } else {
            String T = id.substring(0, startIdx);
            String Y = id.substring(startIdx + O.length());
            // Y의 앞부분과 S의 뒷 부분이 겹치는 곳 계산
            int cutIdx = 0;
            String remainS = S.substring(O.length());
            for (int i = 1; i <= Math.min(remainS.length(), Y.length()); i++) {
                // S의 남은 뒷부분과 Y의 시작점의 최대로 비슷한 idx 구하기
                if (remainS.endsWith(Y.substring(0, i))) {
                    cutIdx = i;
                }
            }
            // T와 S, Y를 결합하는데 S와 Y의 앞뒤 겹치는 부분 제거
            answer.append(T)
                    .append(S)
                    .append(Y.substring(cutIdx));
        }
        // 20자가 넘으면 toycartoon만 출력 
        System.out.println(answer.length() > 20 ? id : answer);
    }
}
