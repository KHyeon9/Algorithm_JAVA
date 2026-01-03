import java.util.*;
import java.io.*;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            String comm = br.readLine();
            int length = Integer.parseInt(br.readLine());
            // 문자열 변환해 덱에 저장
            String str = br.readLine();
            str = str.substring(1, str.length() - 1);
            Deque<String> dq = new ArrayDeque<>();
            // split이 빈배열의 경우 "" 반환하므로 isEmpty가 아닌 경우 split
            if (!str.isEmpty()) {
                String[] nums = str.split(",");
                for (String num : nums) {
                    dq.addLast(num);
                }
            }
            // 명령어 일어서 실행
            boolean isReverse = false, isError = false;
            for (char ch : comm.toCharArray()) {
                if (ch == 'R') {
                    // R이면 isReverse 반전
                    isReverse = !isReverse;
                } else {
                    // 덱에 값이 없는데 D 명령어이면 error flag를 ture
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    }
                    // isReverse면 앞에서 삭제
                    // 아니면 뒤에서 삭제
                    if (isReverse) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }
            // 출력
            if (isError) {
                System.out.println("error");
            } else {
                StringBuilder answer = new StringBuilder();
                answer.append("[");
                while (!dq.isEmpty()) {
                    // reverse 상태면 마지막부터 아니면 앞부터
                    answer.append(isReverse ? dq.pollLast() : dq.pollFirst());
                    // 비어있지 않으면 쉼표 추가
                    if (!dq.isEmpty()) {
                        answer.append(",");
                    }
                }
                answer.append("]");
                System.out.println(answer);
            }
        }
    }
}
