import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        AVLTree tree = new AVLTree();
        tree.readFile("src\\input\\input.txt");
        System.out.println("--------------------------------------");
        //   tree.readFile("src\\input\\input1.txt");
      //  tree.setRoot(tree.rebalance(tree.getRoot()));
        FileWriter fileWriter = new FileWriter("src\\input\\input1.txt");
        fileWriter.write(" " + "\n");
        tree.setRoot(tree.inorderTraversal(tree.getRoot(), fileWriter));
        fileWriter.close();

        //System.out.println("Balance = "+tree.getBalance(tree.root));




    //    BufferedReader balance = new BufferedReader(new FileReader("src\\input\\input.txt"));
     //   System.out.println("Balance = "+tree.getBalance(balance.));

     //     tree.printBalanceNode(tree.root);
    }
}
