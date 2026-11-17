package stack;

/* 
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int value) pushes the element value onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/

import java.util.*;

public class min_stack {

    static Stack<Integer> stack;
    static Stack<Integer> minStack;

    public static void MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public static void push(int value) {
        stack.push(value);

        if(minStack.isEmpty() || value <= minStack.peek())
            minStack.push(value);
    }
    
    public static void pop() {
        int value = stack.pop();

        if(value == minStack.peek())
            minStack.pop();
    }
    
    public static int top() {
        return stack.peek();
    }
    
    public static int getMin() {
        return minStack.peek();
    }
    public static void main(String[] args){
       List<String> result = new ArrayList<>();

       MinStack();
       result.add("null");

       push(-3);
       result.add("null");

       push(0);
       result.add("null");

       push(-3);
       result.add("null");

       int min = getMin();
       result.add(String.valueOf(min));

       pop();
       result.add("null");

       int val = top();
       result.add(String.valueOf(val));

       min = getMin();
       result.add(String.valueOf(min));

       System.out.println(result);

    }
}
