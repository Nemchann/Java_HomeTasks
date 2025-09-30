public class Stack {
    double[] stack;
    int size = 0;
    int capacity;
    final int DEFAULT_CAPACITY = 100;

    public Stack(){
        this.size = DEFAULT_CAPACITY;
        stack = new double[DEFAULT_CAPACITY];

    }

    public Stack(int capacity){
        this.capacity = capacity;
        stack = new double[capacity];
    }

    public void push(double n){
        stack[size] = n;
        size++;
    }

    public double pop(){
        return stack[--size];
    }

    public double[] getStack(){
        return stack;
    }


}
