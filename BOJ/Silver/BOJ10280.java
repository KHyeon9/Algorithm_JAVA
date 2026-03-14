import java.io.*;
import java.util.*;

public class BOJ10280 {
    static class Pizza {
        String name;
        int cal;

        public Pizza(String name, int cal) {
            this.name = name;
            this.cal = cal;
        }

        public boolean equalPizza(Pizza pizza) {
            if (pizza == null) return false;
            return cal == pizza.cal && name.equals(pizza.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pizzaCnt = Integer.parseInt(st.nextToken());
        int wantIdx = Integer.parseInt(st.nextToken()) - 1;
        // 정렬되어 있으므로 바로 받고 내가 원하는 피자 저장
        Deque<Pizza> pizzaDeq = new ArrayDeque<>();
        Pizza wantPizza = null;
        for (int i = 0; i < pizzaCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Pizza nowPizza = new Pizza(name, cal);
            if (wantIdx == i) {
                wantPizza = nowPizza;
            }
            pizzaDeq.addLast(nowPizza);
        }
        // 번갈아 가면서 계산
        int curSize = pizzaCnt;
        for (int i = 0; i < pizzaCnt - 1; i++) {
            // 0이면 엘리스, 1이면 밥, 2이면 나
            int turn = i % 3;
            if (turn == 0) {
                // 엘리스의 턴
                // 큰 칼로리 피자 제거
                pizzaDeq.pollLast();
            } else if (turn == 1) {
                // 밥의 턴
                // 작은 칼로리 피자를 앞에서 제거하면 내가 원하는 피자 위치가 변동됨
                wantIdx--;
                pizzaDeq.pollFirst();
            } else {
                // 나의 턴
                // 왼쪽과 오른쪽의 남은 피자의 양에 따라 많은쪽을 제거
                int left = wantIdx;
                int right = curSize - wantIdx - 1;
                if (left >= right) {
                    // 다음이 엘리스 이므로 같은 경우도 밥에서 제거
                    wantIdx--;
                    pizzaDeq.pollFirst();
                } else {
                    pizzaDeq.pollLast();
                }
            }
            // 제거하기 때문에 총 피자 갯수 변동
            curSize--;
        }
        // 결과 출력
        System.out.println(pizzaDeq.pollLast().equalPizza(wantPizza) ? "YES" : "NO");
    }
}
