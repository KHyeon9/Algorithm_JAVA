import java.util.*;
import java.io.*;

public class BOJ34980 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String line1 = br.readLine();
        String line2 = br.readLine();
        int cnt1 = 0, cnt2 = 0;
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (line1.charAt(i) == 'w') {
                cnt1++;
            }
            if (line2.charAt(i) == 'w') {
                cnt2++;
            }
            if (flag && line1.charAt(i) != line2.charAt(i)) {
                flag = false;
            }
        }

        if (cnt1 > cnt2) {
            System.out.println("Oryang");
        } else if (cnt1 < cnt2) {
            System.out.println("Manners maketh man");
        } else {
            if (flag) {
                System.out.println("Good");
            } else {
                System.out.println("Its fine");
            }
        }
    }
}
