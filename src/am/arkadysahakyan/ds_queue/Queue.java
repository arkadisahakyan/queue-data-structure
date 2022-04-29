package am.arkadysahakyan.ds_queue;

public class Queue {
    private int[] queue;
    private int head;
    private int tail;

    public Queue(int capacity) {
        this.queue = new int[capacity];
        this.head = -1;
        this.tail = 0;
    }

    public void enqueue(int value) {
        if (isFull()) throw new RuntimeException("the queue is full");
        queue[tail] = value;
        if (head == -1)
            head = 0;
        if (tail == queue.length - 1)
            tail = 0;
        else
            tail++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("the queue is empty");
        int item = queue[head];
        if (head != queue.length - 1)
            head++;
        else
            head = 0;
        if (head == tail) {
            head = -1;
            tail = 0;
        }
        return item;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head == tail;
    }

    public void printContent() {
        if (isEmpty()) return;
        if (head < tail) {
            for (int i = head; i < tail; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = head; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < tail; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
