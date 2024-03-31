import java.util.*;
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("hello");
        al.add("hi");
        al.add("bye");
        Iterator<String> arrit = al.iterator();
        System.out.println("elements in array list is:");
        while(arrit.hasNext()){
            System.out.println(arrit.next());
        }
        LinkedList<String> li = new LinkedList<String>();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter st : ");String s=sc.nextLine();li.add(s);
        li.add("cvr");
        li.add("college");
        li.add("engineering");
        Iterator<String> llit = li.iterator();
        System.out.println("elements in linked list is");
        while(llit.hasNext()){
            System.out.println(llit.next());
        }
    }
}