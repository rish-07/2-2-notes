import java.util.LinkedList;
import java.util.Scanner;

class LinkedListClass{
    private LinkedList<Integer> sortedList;
    public LinkedListClass(){
        sortedList = new LinkedList<>();
    }
    public void insert(int item){
        if(sortedList.isEmpty()) sortedList.addFirst(item);
        else{
            int i=0;
            while(i < sortedList.size() && item >= sortedList.get(i) ) i++;
            sortedList.add(i,item);

        }
    }
    public void remove(int item){
        if(sortedList.isEmpty()){
            System.out.println("No Item To remove!! Linear List is Empty");
        }else{
            sortedList.remove(item);
            System.out.println("-------Element is deleted-----");
        }
    }
    public void display(){
        System.out.println("The Sorted Chain Elements Are: ");
        for(int i : sortedList){
            System.out.print(i+" ");
        }
    }
}


public class SortedChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListClass sortedChain = new LinkedListClass();
        while(true){
            System.out.println("Enter The choices:\n1.INSERT\n2.REMOVE\n3.DISPLAY:");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter The Element You wanted To insert: ");
                    int el = sc.nextInt();
                    sortedChain.insert(el);
                    break;
                case 2:
                    System.out.println("Enter the element you wanted to delete: ");
                    int del = sc.nextInt();
                    sortedChain.remove(del);
                    break;
                case 3:
                    sortedChain.display();
                    break;
                default:return;
            }
        }
    }
}