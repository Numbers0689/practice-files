import java.util.*;
import java.io.*;

public class Com {
    public static void main(String[] args) {
       HashMap<String, Integer> m = new HashMap<>();
       m.put("h", 24);

       System.out.println(m.get("h"));
       System.out.println(m.getOrDefault("h", 0));
    }
}

// interface List {
//     public void add(int index, Integer e);
//     public void addLast(Integer e);
//     public void addFirst(Integer e);
//     public Integer get(int index);
//     public void remove(int index);
// }

class LinkedList {

    // @Override
    public void add(int index, Integer e) {

    }

    // @Override
    public void addLast(Integer e) {

    }

    // @Override
    public void addFirst(Integer e) {

    }

    // @Override
    public Integer get(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    // @Override
    public void remove(int index) {

    }
}

class Stack {
    int cap;
    List<Integer> stack;

    Stack() {
        cap = 10;
        stack = new ArrayList<>();
    }

    public void push(Integer e) {
        stack.add(e);
    }

    public Integer pop() {
        return stack.removeLast();
    }

    public Integer peek() {
        return stack.getLast();
    }
}

class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int item) {

    }

    public int dequeue() {

    }

    public int peek() {

    }

    public boolean isFull() {

    }

    public boolean isEmpty() {

    }

    public int getSize() {

    }
}

class FastScanner {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer("");
    String next() {
        while (!st.hasMoreTokens())
            try { 
                st=new StringTokenizer(br.readLine());				               
            } catch (IOException e) {}
        return st.nextToken();
    }
    
    int nextInt() {
        return Integer.parseInt(next());
    }
    long nextLong() {
        return Long.parseLong(next());
    }
}