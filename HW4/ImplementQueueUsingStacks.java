import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue a = new MyQueue();
        a.push(1);
        a.push(21);
        System.out.println(a.empty());
    }
}
class MyQueue {
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    public MyQueue() {
        this.stackA = new Stack<Integer>();
        this.stackB = new Stack<Integer>();
    }
    public void push(int x) {
        stackA.push(x);
    }


    public int pop() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }


    public int peek() {
        int ret = 0;
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        ret = stackB.peek();
        return ret;
    }

    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}