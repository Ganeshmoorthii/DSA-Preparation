// Queue Using Array (Fixed Size - Circular Queue)
class MyQueue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        if(rear==100005) return;
        arr[rear++] = x;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(front>=rear) return -1;
        return arr[front++];
        // Your code here
    }
}

// Dynamic Queue Using Array (Resizable Like ArrayList)
class DynamicQueue {
    private int[] queue;
    private int front, rear, size;

    public DynamicQueue() {
        queue = new int[2];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int val) {
        if (size == queue.length) resize(queue.length * 2);
        queue[rear++] = val;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue Underflow");
        int val = queue[front++];
        size--;

        if (size > 0 && size == queue.length / 4) resize(queue.length / 2);
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {
        int[] newQueue = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[front + i];
        }
        queue = newQueue;
        front = 0;
        rear = size;
    }
}


// Generic Queue (Works With Any Data Type)
class GenericQueue<T> {
    private Object[] queue;
    private int front, rear, size;

    public GenericQueue(int capacity) {
        queue = new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(T val) {
        if (rear == queue.length) throw new RuntimeException("Queue Full");
        queue[rear++] = val;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        T val = (T) queue[front++];
        size--;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

// Queue Using Linked List (Unlimited Size)
class LinkedListQueue {
    private static class Node {
        int data;
        Node next;

        Node(int data) { this.data = data; }
    }

    private Node front, rear;

    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (rear != null) rear.next = newNode;
        rear = newNode;
        if (front == null) front = newNode;
    }

    public int dequeue() {
        if (front == null) throw new RuntimeException("Queue is empty");
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

// Double-Ended Queue (Deque)
class MyDeque {
    private int[] deque;
    private int front, rear, size, capacity;

    public MyDeque(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }

    public void pushFront(int x) {
        if (isFull()) throw new RuntimeException("Deque Full");
        front = (front - 1 + capacity) % capacity;
        deque[front] = x;
        size++;
    }

    public void pushRear(int x) {
        if (isFull()) throw new RuntimeException("Deque Full");
        deque[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
    }

    public int popFront() {
        if (isEmpty()) throw new RuntimeException("Deque Empty");
        int val = deque[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public int popRear() {
        if (isEmpty()) throw new RuntimeException("Deque Empty");
        rear = (rear - 1 + capacity) % capacity;
        int val = deque[rear];
        size--;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
