import java.io.FilterOutputStream;

public class Main {
    public static void main(String[] args) {
        //System.out.println("chmury".compareTo("deszcz"));
        System.out.println(" ");
        BSTTree rbtree = new BSTTree();
        /*
        rbtree.testInsert("chmury");
        rbtree.testInsert("deszcz");
        rbtree.testInsert("pole");
        rbtree.testInsert("aleksander");
        rbtree.testInsert("yeti");
        */
        Parser parser = new Parser("src/text.txt", rbtree);
        parser.load();
        rbtree.preorder();
        System.out.println();
        rbtree.traverseAcross();
        rbtree.findNode("parasol");


        rbtree.delete("parasol");
        rbtree.preorder();
        System.out.println();
        rbtree.traverseAcross();
        System.out.println();

        rbtree.findNode("tylko");
        rbtree.findNode("w");
        rbtree.delete("tylko");
        rbtree.findNode("w");
        rbtree.preorder();
        System.out.println();
        rbtree.traverseAcross();

        System.out.println();
        rbtree.findNode("w");
    }
}
