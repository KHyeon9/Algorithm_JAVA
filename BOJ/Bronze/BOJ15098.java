import java.util.*;
import java.io.*;

public class BOJ15098 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        // 동일한 문자열과 붙이기위해 정렬
        Arrays.sort(line);
        // 출력
        System.out.println(isDuplicates(line) ? "no" : "yes");
    }

    private static boolean isDuplicates(String[] line) {
        // 이전 문자열과 비교해서 같으면 true 없으면 false
        for (int i = 1; i < line.length; i++) {
            if (line[i - 1].equals(line[i])) {
                return true;
            }
        }
        return false;
    }
}
