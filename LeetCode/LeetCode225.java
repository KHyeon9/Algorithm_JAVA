import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode225 {
    // Implement Stack using Queues
    class MyStack {
        Deque<Integer> deq;

        public MyStack() {
            deq = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            deq.addLast(x);
        }

        public int pop() {
            return deq.pollLast();
        }

        public int top() {
            return deq.peekLast();
        }

        public boolean empty() {
            return deq.isEmpty();
        }
    }
}
