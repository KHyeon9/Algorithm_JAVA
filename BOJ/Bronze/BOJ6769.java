import java.io.*;
import java.util.*;

public class BOJ6769 {
    static Map<Character, Integer> symbolValue = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    static class AromaticInfo {
        int roma, val;

        public AromaticInfo(int roma, int val) {
            this.roma = roma;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String aromaticNumber = br.readLine();
        ArrayList<AromaticInfo> aromaticList = new ArrayList<>();

        for (int i = 0; i < aromaticNumber.length(); i += 2) {
            int val = calc(aromaticNumber.substring(i, i + 2));
            AromaticInfo info = new AromaticInfo(
                    symbolValue.get(aromaticNumber.charAt(i + 1 )),
                    val
            );
            aromaticList.add(info);
        }
        
        int answer = 0;

        for (int i = 0; i < aromaticList.size() - 1; i++) {
            if (aromaticList.get(i).roma < aromaticList.get(i + 1).roma) {
                answer -= aromaticList.get(i).val;
            } else {
                answer += aromaticList.get(i).val;
            }
        }
        // 마지막은 다음 수가 없으니 무조건 더하기
        System.out.println(answer + aromaticList.get(aromaticList.size() - 1).val);
    }

    private static int calc(String now) {
        int arabia = now.charAt(0) - '0';
        int roma = symbolValue.get(now.charAt(1));
        return arabia * roma;
    }
}
