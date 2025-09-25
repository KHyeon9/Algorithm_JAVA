import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp;
        Deque<Integer> deque = new ArrayDeque<>();
        // 숫자를 거꾸로 queue에 저장
        for (int i = n; i > 0; i--) {
            deque.push(i);
        }
        // deque에 하나만 남을때 까지 반복
        while (deque.size() > 1) {
            // 맨 윗장 버리기
            deque.pop();
            // 두번째 장 저장
            temp = deque.pop();
            // 맨 아래로 넣기
            deque.addLast(temp);
        }
        System.out.println(deque.pop());
    }
}
