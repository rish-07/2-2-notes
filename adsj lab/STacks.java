import java.util.Scanner;

class ArrayStack<T>{
    private T[] items;
    private int top;

    public ArrayStack(int size){
        items = (T[]) new Object[size];
        top = -1;

    }

    public void push(T data){
        if (top==items.length-1) System.out.println("Stack is Full !!");
        else items[++top] = data;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Stack IS Empty");
            return null;
        }
        else return items[top--];

    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack IS Empty");
        }
        else{
            for(int i=top;i>=0;i--) System.out.println(items[i]);
        }
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Stack IS Empty");
            return null;
        }
        else    return items[top];

    }
    public boolean isEmpty(){
        if(top==-1) return true;
        else return false;
    }
}

class LinkedStack<T>{
    private Node<T> top;
    private int size;
    private static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public LinkedStack(){
        top = null;
        size = 0;
    }
    public void push(T item){
        Node <T> node = new Node<>(item);
        node.next = top;
        top = node;
        size++;
    }
    public T pop(){
        if(isEmpty()){
            System.out.println("Stack Is Empty!!");
            return null;
        }else{
            T item = top.data;
            top = top.next;
            size--;
            return item;
        }
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack Is Empty!!");
        }else {
            Node<T> current = top;
            while(current!=null){
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
    public T peek(){
        if(isEmpty()){
            System.out.println("Stack Is Empty!!");
            return null;
        }else{
            return top.data;
        }
    }
    public boolean isEmpty(){
        if(size==0) return true;
        else return false;
    }
}



public class STacks {
    public static void main(String[] args) {
        int chooseType;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose The DataType You wanted To insert:\n1.Integer\n2.Double\n3.String");
        chooseType = sc.nextInt();
        switch (chooseType){
            case 1:{
                ArrayStack<Integer> asi= new ArrayStack<>(25);
                int data ;
                System.out.println("Enter the elements you wanted to insert: ");
                int n = sc.nextInt();
                for(int i=0;i<n;i++){
                    data = sc.nextInt();
                    asi.push(data);
                }
                operations(asi);
                break;

            }
            case 2:{
                ArrayStack<Double> asd= new ArrayStack<>(25);
                Double data ;
                System.out.println("Enter the elements you wanted to insert: ");
                int n = sc.nextInt();
                for(int i=0;i<n;i++){
                    data = sc.nextDouble();
                    asd.push(data);
                }
                operations(asd);
                break;
            }
            case 3:{
                ArrayStack<String> ass= new ArrayStack<>(25);
                String data ;
                System.out.println("Enter the elements you wanted to insert: ");
                int n = sc.nextInt();
                for(int i=0;i<n;i++){
                    data = sc.next();
                    ass.push(data);
                }
                operations(ass);
                break;
            }
        }
    }
    public static <T> void operations(ArrayStack<T> o){
        int chooseOp;

        while(true) {
            System.out.println("Choose The Operations You wanted to be performed:\n1.pop\n2.peek\n3.display:");
            Scanner sc = new Scanner(System.in);
            chooseOp = sc.nextInt();
            switch (chooseOp) {
                case 1: {
                    T item = o.pop();
                    System.out.println(item);
                    break;
                }
                case 2: {
                    T top = o.peek();
                    System.out.println(top);
                    break;
                }
                case 3: {
                    o.display();
                    break;
                }
                default: return;
            }
        }
    }
}