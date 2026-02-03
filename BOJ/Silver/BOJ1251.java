import java.io.*;
import java.util.*;

public class BOJ1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        ArrayList<String> strArr = new ArrayList<>();
        int len = str.length();
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                // 단어를 3 덩이로 나누기
                String[] words = {str.substring(0, i), str.substring(i, j), str.substring(j, len)};
                StringBuilder sb = new StringBuilder();
                for (String word : words) {
                    // 각 덩이를 역순으로 더하기
                    sb.append(new StringBuilder(word).reverse());
                }
                strArr.add(sb.toString());
            }
        }
        // 사전순으로 정렬
        Collections.sort(strArr);
        System.out.println(strArr.get(0));
    }
}
