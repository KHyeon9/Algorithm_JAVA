import java.io.*;
import java.util.*;

public class BOJ1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String words = br.readLine();
        int n = Integer.parseInt(br.readLine());
        // 커서 위치를 left와 right 덱의 가운대로 잡음
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        // 처음 커서가 left의 맨 뒤이기 때문에 저장
        for (char word : words.toCharArray()) {
            left.addLast(word);
        }
        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char comm = st.nextToken().charAt(0);

            if (comm == 'P') {
                char w = st.nextToken().charAt(0);
                left.addLast(w);
            } else if (comm == 'L' && !left.isEmpty()) {
                // 커서가 왼쪽으로 이동이므로 비어있지 않으면
                // 왼쪽 덱의 맨 뒷값을 오른쪽 덱의 맨앞으로 넣기
                right.addFirst(left.pollLast());
            } else if (comm == 'D' && !right.isEmpty()) {
                // 커서가 오른쪽으로 이동이므로 비어있지 않으면
                // 왼쪽 오른쪽의 맨 앞값을 왼쪽 덱의 맨뒤로 넣기
                left.addLast(right.pollFirst());
            } else if (comm == 'B' && !left.isEmpty()) {
                // 비어있지 않으면 커서의 왼쪽값을 삭제
                left.pollLast();
            }
        }
        StringBuilder answer = new StringBuilder();
        // 왼쪽 덱 앞부터 값을 뽑아서 출력
        while (!left.isEmpty()) answer.append(left.pollFirst());
        // 오른쪽 덱 앞부터 값을 뽑아서 출력
        while (!right.isEmpty()) answer.append(right.pollFirst());
        System.out.println(answer);
    }
}
