import java.io.*;
import java.util.*;

public class BOJ4368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> translation = new HashMap<>();
        String line;
        while (true) {
            line = br.readLine();
            if (line == null || line.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(line);
            String val = st.nextToken();
            String key = st.nextToken();
            translation.put(key, val);
        }
        while ((line = br.readLine()) != null) {
            String result = translation.get(line);
            if (result == null) {
                System.out.println("eh");
            } else {
                System.out.println(result);
            }
        }
    }
}
