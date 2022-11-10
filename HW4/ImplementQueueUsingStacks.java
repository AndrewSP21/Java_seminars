import java.util.Stack;

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
