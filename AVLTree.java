import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AVLTree {
     Node root;

     public AVLTree(){}

    public AVLTree(Node root) {
        this.root = root;
    }
    public int updateHeight(Node node){
        if(node == null) return -1;
        int left = updateHeight(node.left);
        int right = updateHeight(node.right);

        return Math.max(left , right) + 1;

    }

    int height(Node node){
        if (node == null){
            return 0;
        }else {
            return node.height;
        }
    }
    int getBalance(Node node){
        if (node == null){
            return 0;
        }else {
            return updateHeight(node.right)- updateHeight(node.left);
        }
    }



    public void readFile (String path){
         try(Scanner scanner= new Scanner(new File(path))) {
             int n= scanner.nextInt();
            Node []nodes= new Node[n] ;
             for (int i = 0; i <n ; i++) {
                 nodes[i]= new Node();
             }
             for (int i = 0; i < n; i++) {
                 nodes[i].setValue(scanner.nextInt());
                 int l = scanner.nextInt();
                 int r= scanner.nextInt();
                 if (l != 0){
                     nodes[i].setLeft(nodes[l - 1]);
                     nodes[l -1].setBalance(nodes[i].getHeight());
                 }
                 if (r != 0){
                     nodes[i].setRight(nodes[r - 1]);
                     nodes[r-1].setBalance(nodes [i].getHeight());
                 }
             }
             root = nodes[0];
             for (int i = 0; i < n ; i++) {
                 System.out.println();
                  System.out.println(getBalance(nodes[i]));

             }
         }catch (FileNotFoundException e){
             throw new RuntimeException(e);
         }
    }
    public int getHeight(Node node){
        if(node == null) return -1;
        int left = getHeight(node.left);
        int right = getHeight(node.right);

        return Math.max(left , right) + 1;

    }
       Node rotateLeft(Node node){
        Node newNode = node.right;
        node.right= newNode.left;
        newNode.left= node;

        updateHeight(node);
        updateHeight(newNode);
        return newNode;
    }
    Node rotateRight(Node node) {
        Node newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;

        updateHeight(node);
        updateHeight(newNode);

        return newNode;
    }
    public Node inorderTraversal(Node node, FileWriter fileWriter) throws IOException {
        if (node != null) {
            inorderTraversal(node.left, fileWriter);
            if (fileWriter != null) {
                fileWriter.write(node.key + " " + ((node.left != null) ? node.left.key : 0) + " " + ((node.right != null) ? node.right.key : 0) + "\n");
            }
            inorderTraversal(node.right, fileWriter);
        }
        return node;
    }
 /*   Node balanceNode(Node node){
        updateHeight(node);
        int balance= getBalance(node);
        if (balance >1){
            if (getBalance(node.right)< 0){
                node.right= rotateRight(node.right);
            }
            node= rotateLeft(node);
        } else if (balance <-1) {
            if(getBalance(node.left) >0){
                node.left= rotateLeft(node.left);
            }
            node= rotateRight(node);

        }
        return node;
    }*/
    Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }
 /*   Node insertNode(Node node, int value){
        if (node == null){
            return new Node(value);
        } else if (value < node.value) {
            node.left= insertNode(node.left, value);

        }else {
            node.right= insertNode(node.right, value);
        }
        return balanceNode(node);
    }
    public void printBalanceNode(Node node){
        if (node != null){
            printBalanceNode(node.left);
            node.balance= getBalance(node);
            System.out.println("Value :"+node.value+"Balance : "+node.balance);
            printBalanceNode(node.right);
        }
    }
    Node deleteNode(Node node, int key){
         if (node == null){
             return node;
         } else if (node.key >key) {
             node.left= deleteNode(node.left,key);
         } else if (node.key < key) {
             node.right= deleteNode(node.right,key);
         }else {
             if (node.left == null || node.right == null){
                 node = (node.left == null)? node.right : node.left;
             }else {
                 Node mostLeftChild = mostLeftChild( node.right);
                 node.key = mostLeftChild.key;
                 node.right= deleteNode(node.right, node.key);
             }
         }
         if (node != null){
             node = balanceNode(node);
         }
         return node;
    }

     Node mostLeftChild(Node right) {
         return right;

    }

    Node findNode(int key){
         Node current = root;
         while (current != null){
             if (current.key == key){
                 break;
             }
             current= current.key< key ? current.right :current.left;
         }
         return current;

    }*/


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
