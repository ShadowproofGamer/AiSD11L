import java.util.ArrayList;
import java.util.Objects;

public class BSTTree {
    Node root;

    public BSTTree() {

    }

    public void insertBST(String word, int row) {
        Node x = new Node(word);
        x.row.add(row);
        if (root != null)
            treeInsert(root, x);
        else root = x;
    }

    private void treeInsert(Node root, Node x) {
        if (root.value.equals(x.value)) {
            root.row.add(x.row.get(0));
        } else if (root.value.compareTo(x.value) < 0) {
            if (root.right == null) {
                root.right = x;
                x.parent = root;
            } else {
                treeInsert(root.right, x);
            }
        } else if (root.value.compareTo(x.value) > 0) {
            if (root.left == null) {
                root.left = x;
                x.parent = root;
            } else {
                treeInsert(root.left, x);
            }
        }
    }

    public void preorder() {
        preorderRecursive(root);
    }

    private void preorderRecursive(Node root) {
        if (root != null) {
            System.out.print("\n" + root.value + " - ");
            for (int i = 0; i < root.row.size(); i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(root.row.get(i));
            }
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void delete(Node root, Node del) {
        if (Objects.equals(del.value, this.root.value)) {
            if (root.left == null && root.right == null) {
                this.root = null;
            } else if (root.left == null) {
                this.root = this.root.right;
            } else if (root.right == null) {
                this.root = this.root.left;
            } else {
                Node temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                if (temp.right != null) {
                    temp.parent.left = temp.right;
                } else {
                    temp.parent.left = null;
                }
                temp.right = this.root.right;
                temp.left = this.root.left;
                temp.parent = null;
                this.root = temp;
            }
        } else if (Objects.equals(del.value, root.value)) {
            if (root.left == null && root.right == null) {
                if (root.parent.left == root) {
                    root.parent.left = null;
                    root.parent = null;
                } else if (root.parent.right == root) {
                    root.parent.right = null;
                    root.parent = null;
                }
            } else if (root.left == null) {
                if (root.parent.left == root) {
                    root.right.parent = root.parent;
                    root.parent.left = root.right;
                } else if (root.parent.right == root) {
                    root.right.parent = root.parent;
                    root.parent.right = root.right;
                }
            } else if (root.right == null) {
                if (root.parent.left == root) {
                    root.left.parent = root.parent;
                    root.parent.left = root.left;
                } else if (root.parent.right == root) {
                    root.left.parent = root.parent;
                    root.parent.right = root.left;
                }
            } else {
                Node temp = root.right;
                boolean done = false;
                while (temp.left != null) {
                    temp = temp.left;
                    done=true;
                }
                if (done) {
                    if (temp.right != null) {
                        temp.parent.left = temp.right;
                    } else {
                        temp.parent.left = null;
                    }
                    temp.right = root.right;
                }else {
                    temp.left = root.left;
                }
                    if (root.parent.right == root) {
                        root.parent.right = temp;
                    } else if (root.parent.left == root) {
                        root.parent.left = temp;
                    }
                    temp.parent = root.parent;
            }
        } else if (del.value.compareTo(root.value) < 0) {
            delete(root.left, del);
        } else if (del.value.compareTo(root.value) > 0) {
            delete(root.right, del);
        }
    }

    public void delete(String s) {
        try {
            delete(root, new Node(s));

        } catch (NullPointerException e) {
            System.out.println("Word not found. Delete operation failed");
        }
    }


    public void traverseAcross() {
        ArrayList<Node> queue = new ArrayList<>();
        int i = 0;
        if (root != null) {
            queue.add(root);
            while (i < queue.size()) {
                Node temp = queue.get(i);
                System.out.print(temp.value + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                i++;
            }
        }
    }

    public void findNode(String s){
        Node x = findNode(root, new Node(s));
        if (!Objects.equals(x.value, "!! Error !!")){
            System.out.println("\nvalue: "+x.value);
            if (x.left!=null) System.out.println("left: "+x.left.value);
            if (x.right!=null) System.out.println("right: "+x.right.value);
            if (x.parent!=null) System.out.println("parent: "+x.parent.value);
        }else {
            System.out.println("Error occurred while trying to find: '"+s+"'");
        }

    }
    private Node findNode(Node root, Node search){
        Node result = new Node("!! Error !!");
        if (root==null){
            return result;
        }
        else if (Objects.equals(root.value, search.value)){
            return root;
        }
        else if (root.value.compareTo(search.value)>0){
            result=findNode(root.left, search);
        }
        else if (root.value.compareTo(search.value)<0){
            result=findNode(root.right, search);
        }
        return result;
    }

    private class Node {
        public boolean color = false;
        private Node parent = null;
        private Node left = null;
        private Node right = null;
        private String value;
        private ArrayList<Integer> row = new ArrayList<>();

        public Node(String value) {

            this.value = value;
        }

        public Node(String value, int r) {

            this.value = value;
            this.row.add(r);
        }

        public Node(Node p, Node left, Node right, String value) {

            this.parent = p;
            this.left = left;
            this.right = right;
            this.value = value;
        }

    }
}
