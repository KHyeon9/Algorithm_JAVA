import java.io.*;
import java.util.*;

public class BOJ13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Set<String> studentSet = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String student = br.readLine();
            if (studentSet.contains(student)) {
                studentSet.remove(student);
            }
            studentSet.add(student);
        }
        int cnt = 0;
        for (String student : studentSet) {
            if (cnt < k) {
                System.out.println(student);
            }
            cnt++;
        }
    }
}
