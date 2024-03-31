import java.util.ArrayList;
import java.util.Scanner;

public class GenericQueue<T> {
    private ArrayList<T> Queue;
    public GenericQueue(){
        Queue = new ArrayList<T>();
    }
    public void enqueue(T item){
        Queue.add(item);
    }
    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue Is Empty !!");
        }else{
            return Queue.remove(0);
        }
    }
    public void display(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty!!");
        else{
            System.out.println("Queue Elements Are: ");
            for (T item:Queue) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
    public boolean isEmpty(){
        return Queue.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericQueue<Integer> qui = new GenericQueue<>();
        for(int i=0;i<5;i++)    qui.enqueue(i);
        qui.display();
        System.out.println("1st popped ele:\n"+ qui.dequeue() +"\n2nd Popped ele: \n"+qui.dequeue());
        qui.display();

        GenericQueue<String> qus = new GenericQueue<>();
        System.out.println("Enter 4 String Values: ");
        for (int i=0;i<4;i++)   qus.enqueue(sc.next());
        qus.display();
        System.out.println("1st popped ele:\n"+ qus.dequeue() +"\n2nd Popped ele: \n"+qus.dequeue());
        qus.display();

    }
}