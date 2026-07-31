import java.util.Stack;

public class LeetCode232 {
    // Implement Queue using Stacks
    class MyQueue {

        Stack<Integer> inputStack;
        Stack<Integer> outputStack;

        public MyQueue() {
            this.inputStack = new Stack<>();
            this.outputStack = new Stack<>();
        }

        public void push(int x) {
            inputStack.push(x);
        }

        public int pop() {
            // 순서 뒤집어주기
            this.peek();
            return outputStack.pop();
        }

        public int peek() {
            // outputStack이 비어있을 때만 inputStack 밀어 넣기
            if (outputStack.isEmpty()) {
                while(!inputStack.isEmpty()){
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.peek();
        }

        public boolean empty() {
            return  inputStack.isEmpty() && outputStack.isEmpty();
        }
    }
}
