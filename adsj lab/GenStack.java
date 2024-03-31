package ADSJ.src;

import java.util.LinkedList;

public class GenStack<T> {
    private LinkedList<T> newStack;

    public GenStack(){
        newStack = new LinkedList<>();
    }

    public void push(T item){
        newStack.addFirst(item);
    }
    public T pop(){
        if(newStack.isEmpty())  throw new RuntimeException("Stack Is Empty!!");
        return newStack.removeFirst();
    }

    public void display(){
        if(newStack.isEmpty())  throw new RuntimeException("Stack Is Empty!!");
        for (T item: newStack){
            System.out.print(item+" ");
        }
        System.out.println();
    }

    public T peek(){
        if(newStack.isEmpty()) throw new RuntimeException("Stack Is Empty!!");
        return newStack.peek();
    }



    public static void main(String[] args) {
        GenStack<Integer> stack1 = new GenStack<>();

        for (int i = 0; i < 4; i++) {
            stack1.push(i);
        }

        stack1.display();

        System.out.println("1st popped ele:\n"+ stack1.pop() +"\n2nd Popped ele: \n"+stack1.pop());
        System.out.println("peek Element: "+stack1.peek());
        stack1.display();

    }
}