import java.io.*;

public class BOJ1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String docs = br.readLine();
        String searchWord = br.readLine();
        int wordLen = searchWord.length();
        int idx = 0, answer = 0;
        while (idx <= docs.length() - wordLen) {
            String now = docs.substring(idx, idx + wordLen);
            if (now.equals(searchWord)) {
                answer++;
                idx += wordLen;
            } else {
                idx++;
            }
        }
        System.out.println(answer);
    }
}
