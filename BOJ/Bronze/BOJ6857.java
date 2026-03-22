import java.io.*;
import java.util.*;

import static java.util.Map.entry;

public class BOJ6857 {
    // 걸리는 시간 map
    static Map<Character, Integer> clickCnt = Map.ofEntries(
            entry('a', 1), entry('b', 2), entry('c', 3),
            entry('d', 1), entry('e', 2), entry('f', 3),
            entry('g', 1), entry('h', 2), entry('i', 3),
            entry('j', 1), entry('k', 2), entry('l', 3),
            entry('m', 1), entry('n', 2), entry('o', 3),
            entry('p', 1), entry('q', 2), entry('r', 3),
            entry('s', 4), entry('t', 1), entry('u', 2),
            entry('v', 3), entry('w', 1), entry('x', 2),
            entry('y', 3), entry('z', 4), entry(' ', 1)
    );
    // 버튼 그룹
    static String[] buttenGroup =
            {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            // 탈출 조건
            if (line.equals("halt")) break;
            // 시간 계산
            int time = 0;
            int prevBtn = -1;
            for(char ch : line.toCharArray()) {
                int nowBtn = getBtn(ch);
                // 이전 버튼과 같으면 쉬는 시간 추가
                if (prevBtn == nowBtn) {
                    time += 2;
                } else {
                    // 아닌 경우 이전 버튼 변경
                    prevBtn = nowBtn;
                }
                time += clickCnt.get(ch);
            }
            System.out.println(time);
        }
    }
    // 버튼 구하기
    private static int getBtn(char ch) {
        String chStr = String.valueOf(ch);
        for (int i = 0; i < buttenGroup.length; i++) {
            if (buttenGroup[i].contains(chStr)) {
                return i;
            }
        }
        return -1;
    }
}
