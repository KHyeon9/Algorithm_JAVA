import java.io.*;
import java.util.*;

public class BOJ33904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        List<String> lines = new ArrayList<>();
        // 라인이 ioe 전까지 담기
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        // 변수 순서대로 담기
        Set<Character> varSet = new HashSet<>();
        String lastLine = lines.get(lines.size() - 1).trim();
        for (char c : lastLine.toCharArray()) {
            if (Character.isLetter(c)) {
                varSet.add(c);
            }
        }
        // 변수 줄을 제외하고 변수와 가까운 for문 부터 검사
        List<String> answer = new ArrayList<>();
        Set<Character> useVarSet = new HashSet<>();
        for (int i = lines.size() - 2; i >= 0 ; i--) {
            char var = lines.get(i).trim().charAt(9);
            // 사용할수 있는 변수와 사용된 변수 체크
            if (varSet.contains(var) && !useVarSet.contains(var)) {
                useVarSet.add(var);
                answer.add(lines.get(i).trim());
            }
        }
        // 거꾸로 저장했으니 뒤집기
        Collections.reverse(answer);
        // 마지막줄 더하기
        answer.add(lastLine);
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < answer.size(); idx++) {
            // 빈칸 추가
            sb.append(" ".repeat(idx))
                .append(answer.get(idx))
                .append("\n");
        }
        System.out.println(sb);
    }
}
