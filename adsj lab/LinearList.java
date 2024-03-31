import java.util.Scanner;

class LinearListClass<T>{
    T[] list;
    int size = 0;
    public LinearListClass(int intialSize){
        list = (T[]) new Object[intialSize];
    }
    public LinearListClass(){
        list = (T[]) new Object[10];
    }

    public void insert(T item){
        if(size == list.length) extend();
        list[size++] = item;
    }
    private void extend(){
        int extendSize = list.length * 3/2;
        T[] temp = (T[]) new Object[extendSize];
        for(int i=0;i< list.length;i++){
            temp[i] = list[i];
        }
        this.list = temp;
    }
    public void remove(T item){
        for(int i=0;i< list.length;i++){
            if(list[i]==item){
                for(;i< list.length-1;i++){
                    list[i] = list[i+1];
                }
                size--;
                System.out.println("Element Is deleted!!");
            }
        }
    }
    public void display(){
        System.out.println("The elements are: ");
        for (T item:list) {
            System.out.print(item + "-->");
        }
    }
}


public class LinearList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearListClass<Integer> linearList = new LinearListClass<>(5);
        while(true){
            System.out.println("Enter The choices:\n1.INSERT\n2.REMOVE\n3.DISPLAY:");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter The Element You wanted To insert: ");
                    int el = sc.nextInt();
                    linearList.insert(el);
                    break;
                case 2:
                    System.out.println("Enter the element you wanted to delete: ");
                    int del = sc.nextInt();
                    linearList.remove(del);
                    break;

                case 3:
                    linearList.display();
                    break;
                default:return;
            }

        }
    }
}