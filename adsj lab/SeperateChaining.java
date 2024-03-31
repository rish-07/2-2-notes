import java.util.LinkedList;
import java.util.Scanner;

class KeyValue<k,v>{
    private k key;
    private v value;

    public KeyValue(k key,v value){
        this.key = key;
        this.value = value;
    }
    public k getKey(){
        return key;
    }

    public v getValue() {
        return value;
    }
    public void setKey(k key) {
        this.key = key;
    }
    public void setValue(v value) {
        this.value = value;
    }
    public String toString(){
        return "("+key+","+value + ")";
    }
}

class CreateChainingTable<k,v>{
    private LinkedList<KeyValue<k,v>> [] table;
    private int size;
    public CreateChainingTable(int size){
        table = new LinkedList[size];
        size = 0;

    }

    public int hashFunction(k key){
        return Math.abs(key.hashCode() % table.length);
    }
    public void insert(k key,v val){
        int hashVal = hashFunction(key);
        if(table[hashVal] == null){
            table[hashVal] = new LinkedList<>();
        }
        for(KeyValue<k,v> pair:table[hashVal]){
            if(pair.getKey().equals(key)){
                pair.setValue(val);
                return;
            }
        }
        table[hashVal].add(new KeyValue<>(key,val));
        size++;
    }
    public v search(k key){
        int hash = hashFunction(key);
        if(table[hash] != null){
            for(KeyValue<k,v> pair:table[hash]){
                if(pair.getKey().equals(key)){
                    return pair.getValue();
                }
            }
        }
        return null;
    }
    public void delete(k key){
        int hash = hashFunction(key);
        if(table[hash]!=null){
            for(KeyValue<k,v> pair:table[hash]){
                if(pair.getKey().equals(key)){
                    table[hash].remove(pair);
                    size--;
                    return;
                }
            }
        }
    }
    public void display(){
        for(int i=0;i< table.length;i++ ){
            if(table[i]!=null){
                System.out.println("Index"+i+" ");
                for(KeyValue<k,v> pair:table[i]){
                    System.out.print(pair+"-->");
                }
                System.out.println();
            }
        }
    }

}



public class SeperateChaining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size: ");
        int size = sc.nextInt();
        CreateChainingTable<Integer,String> hashTable = new CreateChainingTable<>(size);
        while(true) {
            System.out.println("\n Seperate chaining ioperations \n");
            System.out.println("1.INSERT \n2.SEARCH\n3.DELETE\n4.DISPLAY\n5.EXIT: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Key: ");
                    int key = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Value:");
                    String val = sc.nextLine();
                    hashTable.insert(key, val);
                    break;
                case 2:
                    System.out.println("Enter Key TO search: ");
                    int searchKey = sc.nextInt();
                    String searchVal = hashTable.search(searchKey);
                    if (searchVal != null) System.out.println("Value For Key: " + searchKey + " is --> " + searchVal);
                    else System.out.println("Element Not Found !!");
                    break;
                case 3:
                    System.out.println("Enter Key To delete: ");
                    int deleteKey = sc.nextInt();
                    hashTable.delete(deleteKey);
                    break;
                case 4:
                    System.out.println("The Following Elements are: ");
                    hashTable.display();
                    break;
                case 5:
                    System.exit(0);

            }
        }
    }
}