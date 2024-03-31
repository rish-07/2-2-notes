import java.util.Scanner;

public class LinearProbing {

    private int[] table;
    private int size;

    public LinearProbing(int size){
        this.size = size;
        table = new int[size];
        for(int i=0;i<size;i++) table[i] = -1;
    }
    public void insert(int key){
        int hash = key % size;
        int index = hash;

        while(table[index] != -1){
            index = (index+1) % size;
            if(index == hash){
                System.out.println("Hash Table is Full !!");
            }
        }
        table[index] = key;
        System.out.println("Inserted Key: "+key + "at index: "+index);
    }

    public int search(int key){
        int hash = key % size;
        int index = hash;
        while(table[index] != -1){
            if(table[index] == key){
                return index;
            }
            index = (index+1) % size;
            if(index == hash)   break;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        LinearProbing lp = new LinearProbing(size);

        while(true){
            System.out.println("Choose Any One Option:\n1.INSERT\n2.SEARCH\n3.EXIT:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 : {
                    System.out.println("Enter the Element You Wanted To insert: ");
                    int ele = sc.nextInt();
                    lp.insert(ele);
                    break;
                }
                case 2 : {
                    System.out.println("Enter The Element You Wanted To Search : ");
                    int searchElement = sc.nextInt();
                    int find = lp.search(searchElement);
                    if(find != -1){
                        System.out.println("Element is Found !!");
                    }else {
                        System.out.println("Element Is not Found !!");
                    }

                    break;
                }
                case 3 : System.exit(0);
                default : System.out.println("Invalid Choice !!");
            }
        }
    }
}