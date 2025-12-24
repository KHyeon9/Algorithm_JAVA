import java.io.*;
import java.util.*;

public class BOJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> inLog = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String comm = st.nextToken();

            if (comm.equals("enter")) {
                inLog.add(name);
            } else {
                inLog.remove(name);
            }
        }
        ArrayList<String> reverseLog = new ArrayList<>(inLog);
        Collections.sort(reverseLog, Collections.reverseOrder());
        for (String name : reverseLog) {
            System.out.println(name);
        }

        br.close();
    }
}
