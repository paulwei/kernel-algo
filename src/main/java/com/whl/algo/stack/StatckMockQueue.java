package com.whl.algo.stack;

import java.util.Stack;

public class StatckMockQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        if (s1.empty())
        s1.push(x);
    }

    public void pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        s2.pop();
    }

}
