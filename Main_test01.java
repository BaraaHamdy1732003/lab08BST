package For;

public class Main_test01 {

        public static void main(String[] args) {
            Node f = new Node(1, null, null);
            Node g = new Node(4, null, null);
            Node h = new Node(7, null, null);
            Node i = new Node(13, null, null);
            Node d = new Node(14, i, null);
            Node e = new Node(6, g, h);
            Node c = new Node(10, null, d);
            Node b = new Node(3, f, e);
            Node a = new Node(8, b, c);

            BinarySearchTree tree = new BinarySearchTree(a);

            System.out.println("Количество вершин в поддереве " + tree.getNumberOfNodes(b));
            System.out.println("Во всем дереве количество вершин = " + tree.numberOfNodes());

            System.out.println("Высота = " + tree.getHeight(a));
            System.out.println("Поиск значения: " + tree.searchByKey(a, 7));

            System.out.println("Это дерево поиска: " + tree.isBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE));

            System.out.println("Min = " + tree.getMin(a));
            System.out.println("Max = " + tree.getMax(a));


            BinarySearchTree treeFromFile = new BinarySearchTree();
            treeFromFile.readFromFile("input.txt");
            System.out.println("Во всем дереве количество вершин = " + treeFromFile.numberOfNodes());

            System.out.println("Высота = " + treeFromFile.getHeight(treeFromFile.getRoot()));

//        b.setParent(a);
//        c.setParent(a);
//        d.setParent(c);
//        e.setParent(b);
//        f.setParent(b);
//        g.setParent(e);
//        h.setParent(e);
//        i.setParent(d);





        }
    }
