import java.util.LinkedList;
import java.util.Scanner;

public class GenLinkQueue <T>{
    private LinkedList<T> newQueue;
    public GenLinkQueue(){
        newQueue = new LinkedList<>();
    }
    public void enqueue(T item){
        newQueue.add(item);
    }
    public T dequeue(){
        if(newQueue.isEmpty())  throw new RuntimeException("Queue iS empty!!");
        return newQueue.removeFirst();
    }
    public void display(){
        if(newQueue.isEmpty()) throw new RuntimeException("Queue is empty !!");
        else{
            System.out.println("The Elements in the queue are: ");
            for(T item:newQueue){
                System.out.print(item+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        GenLinkQueue<Integer> queue1 = new GenLinkQueue<>();
        for (int i = 0; i < 5; i++) {
            queue1.enqueue(i);
        }
        queue1.display();
        System.out.println("1st popped ele:\n"+ queue1.dequeue() +"\n2nd Popped ele: \n"+ queue1.dequeue());
        queue1.display();

        GenLinkQueue<String> qus = new GenLinkQueue<>();
        System.out.println("Enter 4 String Values: ");
        for (int i=0;i<4;i++)   qus.enqueue(sc.next());
        qus.display();
        System.out.println("1st popped ele:\n"+ qus.dequeue() +"\n2nd Popped ele: \n"+qus.dequeue());
        qus.display();
    }
}