import java.io.*;
import java.util.*;

public class BOJ26577 {
    // 우선 순위 확인을 위한 맵
    static Map<String, Integer> calcVal = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2,
            "%", 2
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int dataCnt = Integer.parseInt(br.readLine());

        for (int data = 0; data < dataCnt; data++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 입력에 따른 후위 표현식으로 변환
            Deque<String> calc = new ArrayDeque<>();
            Deque<String> convert = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                // 숫자인 경우는 그냥 추가
                if (!"+-*/%".contains(token)) {
                    convert.addLast(token);
                } else {
                    // 우선 순위에 따른 저장 및 계산식 덱에 저장
                    while (!calc.isEmpty()) {
                        String nowTop = calc.peekLast();
                        if (calcVal.get(nowTop) < calcVal.get(token)) {
                            break;
                        }
                        convert.addLast(calc.pollLast());
                    }
                    calc.addLast(token);
                }
            }
            // 나머지 연산 추가
            while (!calc.isEmpty()) {
                convert.addLast(calc.pollLast());
            }
            // 후위 표현식 계산
            Deque<Integer> result = new ArrayDeque<>();
            while (!convert.isEmpty()) {
                // 앞의 값을 확인
                String val = convert.pollFirst();
                if (!"+-*/%".contains(val)) {
                    // 숫자라면 저장
                    result.addLast(Integer.parseInt(val));
                } else {
                    // 연산자면 계산
                    int n2 = result.pollLast();
                    int n1 = result.pollLast();
                    // 연산자에 따른 2개의 숫자 계산
                    int calcRes = 0;
                    switch (val) {
                        case "+": calcRes = n1 + n2; break;
                        case "-": calcRes = n1 - n2; break;
                        case "%": calcRes = n1 % n2; break;
                        case "/": calcRes = n1 / n2; break;
                        case "*": calcRes = n1 * n2; break;
                    }
                    result.addLast(calcRes);
                }
            }
            System.out.println(result.pollLast());
        }
        br.close();
    }
}
