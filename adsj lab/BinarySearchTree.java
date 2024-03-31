class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class BST{
    Node root;

    public BST(){
        root = null;
    }
    public void insert(int data){
        root = insertNode(root,data);
    }
    private Node insertNode(Node node,int data){
        if(node == null){
            node = new Node(data);
            return node;
        }
        if(data < node.data){
            node.left = insertNode(node.left,data);
        } else if (data > node.data) {
            node.right = insertNode(node.right,data);
        }
        return node;
    }
    public void search(int data){
        Node check = toFind(root,data);
        if(check == null){
            System.out.println("Element Not Found");
        } else {
            System.out.println(data + "Element Is Found!!");
        }
    }

    private Node toFind(Node node,int data){
        if(node == null || node.data == data){
            return node;
        }
        if(data < node.data){
            return toFind(node.left,data);
        } else {
            return toFind(node.right,data);
        }

    }
    public void remove(int data){
        root = toDelete(root,data);
    }

    private Node toDelete(Node node,int data){
        if(node == null){
            return null;
        } else if (data < node.data) {
            node.left = toDelete(node.left,data);
        } else if (data > node.data) {
            node.right = toDelete(node.right,data);
        } else {
            if(node.left == null){
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node replaceNode = minFromRight(node.right);
            node.data = replaceNode.data;
            node.right = toDelete(node.right , replaceNode.data);
        }
        return node;
    }


    private Node minFromRight(Node node){
        Node temp = node;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    public void inOrder(){
        System.out.println("\nInOrder\n");
        toFindInorder(root);
    }
    private void toFindInorder(Node node){
        if(node != null){
            toFindInorder(node.left);
            System.out.print(node.data + "-->");
            toFindInorder(node.right);
        }
    }
    public void preOrder(){
        System.out.println("\nPreOrder\n");
        toFindPreOrder(root);
    }
    private void toFindPreOrder(Node node){
        if(node != null){
            System.out.print(node.data + "-->");
            toFindPreOrder(node.left);
            toFindPreOrder(node.right);
        }
    }
    public void postOrder(){
        System.out.println("\nPostOrder\n");
        toFindPostOrder(root);
    }

    private void toFindPostOrder(Node node){
        if(node != null) {
            toFindPostOrder(node.left);
            toFindPostOrder(node.right);
            System.out.print(node.data + "-->");
        }
    }
}


public class BinarySearchTree {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(9);
        tree.insert(1);
        tree.insert(3);
        tree.insert(13);
        tree.insert(15);
        tree.insert(11);
        tree.insert(12);
        tree.inOrder();
        tree.postOrder();
        tree.preOrder();
        tree.remove(13);
        tree.inOrder();
        System.out.println();
        tree.search(11);

    }
}