import java.util.Scanner;

class NodeClass{
    NodeClass next;
    int data;
    NodeClass(int data){
        this.data = data;
        this.next = null;
    }
}
class SortedChainLinkedList{
    NodeClass head;
    public SortedChainLinkedList(){
        this.head = null;
    }
    public void insert(int data){
        NodeClass newNode = new NodeClass(data);
        if(head == null || data < head.data){
            newNode.next = head;
            head = newNode;
        } else {
            NodeClass current = head;
            while(current.next !=null && current.next.data < data){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    public void remove(int del){
        if(head == null){
            return;
        }
        NodeClass prev = null;
        NodeClass curr = head;
        while(curr.next != null && curr.data != del){
            prev = curr;
            curr = curr.next;
        }

        if(curr == null){
            return;
        }
        if(prev == null){
            head = head.next;
        }
        else{
            prev.next = curr.next;
        }
    }
    public void search(int el){
        NodeClass temp = head;
        while(temp != null){
            if(temp.data == el){
                System.out.println("Element is Found !!");
                return;
            } temp = temp.next;
        }
        System.out.println("Element is Not Found !!");
    }
    public void display(){
        NodeClass temp = head;
        System.out.println("The Elements are: ");
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp  = temp.next;
        }
        System.out.println("END");
    }
}




public class SortedChainDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortedChainLinkedList list = new SortedChainLinkedList();
        while(true){
            System.out.println("Enter The choices:\n1.INSERT\n2.REMOVE\n3.SEARCH\n4.DISPLAY\n5.EXIT:");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter The Element You wanted To insert: ");
                    int el = sc.nextInt();
                    list.insert(el);
                    break;
                case 2:
                    System.out.println("Enter the element you wanted to delete: ");
                    int del = sc.nextInt();
                    list.remove(del);
                    break;
                case 3:
                    System.out.println("Enter the Element you wanted to find: ");
                    int se = sc.nextInt();
                    list.search(se);
                    break;
                case 4:
                    list.display();
                    break;

                default:return;
            }
        }
    }
}