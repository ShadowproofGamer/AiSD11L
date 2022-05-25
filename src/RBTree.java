import java.util.ArrayList;

public class RBTree {
    Node root;

    public RBTree() {

    }

    /**
     * RB-Insert(root, x)
     * Tree-Insert(root,x)
     * color[x] := RED
     * while x <> root and color[p[x]] = RED do
     * if p[x] = left[p[p[x]]] then
     * y := right[p[p[x]]]
     * if color[y] = RED then // przypadek 1
     * color[p[x]] := BLACK // przypadek 1
     * color[y] := BLACK // przypadek 1
     * color[p[p[x]]] := RED // przypadek 1
     * x := p[p[x]]
     * else if x = right[p[x]] then
     * x := p[x] // przypadek 2
     * Left-Rotate(root,x) // przypadek 2
     * color[p[x]] := BLACK // przypadek 3
     * color[p[p[x]]] := RED // przypadek 3
     * Right-Rotate(root, p[p[x]]) { case 3}
     * else ....{ to samo co po then z zamianą „right” oraz
     * „left”}
     * color[root] := BLACK
     */
    public void insert(Node root, Node x) {
        treeInsert(root, x);
        //kod z wykładu:
        while (x != root && !x.parent.color) {
            if (x.parent == x.parent.parent.left) {
                Node y = x.parent.parent.right;
                if (!y.color) {
                    x.parent.color = true;
                    y.color = true;
                    x.parent.parent.color = false;
                    x = x.parent.parent;
                } else if (y.color) {
                    x.parent.color = true;
                    y.color = true;
                    x.parent.parent.color = false;
                    x = x.parent.parent;
                }
            }
        }
        //TODO

    }

    public void insert(Node x) {
        insert(root, x);
        //DONE
    }

    public void insertWord(String word, int row) {
        Node x = new Node(word);
        x.row.add(row);
        insert(x);
        //DONE?
    }

    public void insertBST(String word, int row) {
        Node x = new Node(word);
        x.row.add(row);
        if (root != null)
            treeInsert(root, x);
        else root = x;
        //preorderBST();
        //System.out.println();
        //DONE
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
        //DONE
    }

    public void preorderBST() {
        preorderRecursiveBST(root);
        //DONE
    }

    private void preorderRecursiveBST(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRecursiveBST(root.left);
            preorderRecursiveBST(root.right);
        }
        //DONE
    }

    public void preorder() {
        preorderRecursive(root);
        //DONE
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
        //DONE
    }

    private void rotateLeft(Node root, Node x) {
        //TODO
    }

    private void rotateRight(Node root, Node x) {
        //TODO
    }

    /**
     * RB-Delete(T, z)
     * if (left[z] = nil[T]) or (right[z] = nil[T])
     * then y := z
     * else y := Tree-Successor(z)
     * if left[y] <> nil[T]
     * then x := left[y]
     * else x := right[y]
     * p[x] = p[y]
     * if p[y] = nil[T]
     * then root[T] := x
     * else if y = left[p[y]]
     * then left[p[y]] := x
     * else right[p[y]] := x
     * if y <> z
     * then swap(key[z], key[y])
     * { if node y has another fields, copy them here}
     * if color[y] = BLACK
     * then RB-Delete-Fixup(T,x)
     * return y
     */

    public void delete(Node T, Node z) {
        //TODO
    }

    /**
     * RB-Delete-Fixup(T, x)
     * while x!= root[T] and color[x]=BLACK
     * do if x=left[p[x]] then
     * w:= right[p[x]]
     * if color[w]=RED then // przypadek 1
     * color[w]:=BLACK // przypadek 1
     * color[p[x]]:=RED // przypadek 1
     * Left-Rotate(T,p[x]) // przypadek 1
     * w:=right[p[x]] // przypadek 1
     * if color[left[w]]=BLACK and color[right[w]]=BLACK then
     * color[w]:=RED // przypadek 2
     * x:=p[x] // przypadek 2
     * else if color[right[w]]=BLACK then
     * color[left[w]]:=BLACK // przypadek 3
     * color[w]:=RED // przypadek 3
     * Right-Rotate(T,w) // przypadek 3
     * w:=right[p[x]] // przypadek 3
     * color[w]:=color[p[x]] // przypadek 4
     * color[p[x]]:=BLACK // przypadek 4
     * color[right[w]]:=BLACK // przypadek 4
     * Left-Rotate(T,p[x]) // przypadek 4
     * x:=root[T] // przypadek 4
     * else
     * color[x]=BLACK
     */

    public void fixup(Node T, Node x) {
        //TODO
    }

    public void traverseAcross() {
        ArrayList<Node> queue = new ArrayList<>();
        int i = 0;
        int h = 0;
        int j = 0;
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

    /** test function*/
    public void traverseAcrossTest() {
        ArrayList<Node> queue = new ArrayList<>();
        int i = 0;
        int h = 0;
        int j = 0;
        if (root != null) {
            queue.add(root);
            while (i < queue.size()) {
                Node temp = queue.get(i);
                System.out.print(temp.value + " ");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                i++;
                j++;
                if (Math.pow(2, h)==j){
                    System.out.println();
                    h++;
                    j=0;
                }
            }
        }
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
    //DONE ?
}
