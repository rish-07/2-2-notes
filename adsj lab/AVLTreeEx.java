import java.util.Scanner;
import java.util.TreeSet;
public class AVLTreeEx {
TreeSet<Integer> avlTree = new TreeSet<>();
 public void insertElement(int element) {
 avlTree.add(element);
 }
 public void deleteElement(int element) {
 avlTree.remove(element);
 }
 public void printTree() {
 System.out.println("AVL Tree: " + avlTree);
 }
 public static void main(String[] args) {
AVLTreeEx a=new AVLTreeEx();
 Scanner scanner = new Scanner(System.in);
 while (true) {
 System.out.print("1. Insert element \n2. Delete element\n3. Display\n4. Exit\nEnter your choice:");
 int choice = scanner.nextInt();
 switch (choice) {
 case 1:
 System.out.print("Enter element to insert: ");
 int insEle = scanner.nextInt();
a.insertElement(insEle);
 break;
 case 2:
 System.out.print("Enter element to delete: ");
 int delEle = scanner.nextInt();
 a.deleteElement(delEle);
break;
case 3:
a.printTree();
break;
 case 4:
 System.exit(0);
 break;
 default:
 System.out.println("Invalid choice! Try again.");
 }
 System.out.println();
 }
 }
}