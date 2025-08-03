// Write a program to implement a Stack using Array. 
class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        arr[++top] = x;
    }

    public int pop() {
        // Your Code
        if(top==-1) return -1;
        return arr[top--];
    }
}


// Stack with Dynamic Resizing (like ArrayList)
class DynamicStack {
    private int[] stack;
    private int top;

    public DynamicStack() {
        stack = new int[2]; // initial capacity
        top = -1;
    }

    public void push(int x) {
        if (top == stack.length - 1) {
            resize(2 * stack.length); // double size
        }
        stack[++top] = x;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow");
        int val = stack[top--];
        if (top > 0 && top == stack.length / 4) {
            resize(stack.length / 2); // shrink
        }
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void resize(int newSize) {
        int[] newStack = new int[newSize];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
}

// Stack Using Linked List (Dynamic Memory Allocation)
class LinkedStack {
    private Node top;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow");
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

// Stack Using Generics (Works with any type)
class GenericStack<T> {
    private Object[] stack;
    private int top;

    public GenericStack(int size) {
        stack = new Object[size];
        top = -1;
    }

    public void push(T x) {
        if (top == stack.length - 1) throw new RuntimeException("Stack Overflow");
        stack[++top] = x;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow");
        return (T) stack[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return (T) stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
