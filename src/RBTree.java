import java.util.ArrayList;

public class RBTree {
    Node root;

    public RBTree() {

    }
    /**
        RB-Insert(root, x)
        Tree-Insert(root,x)
        color[x] := RED
    while x <> root and color[p[x]] = RED do
                if p[x] = left[p[p[x]]] then
        y := right[p[p[x]]]
                if color[y] = RED then // przypadek 1
        color[p[x]] := BLACK // przypadek 1
        color[y] := BLACK // przypadek 1
        color[p[p[x]]] := RED // przypadek 1
        x := p[p[x]]
                else if x = right[p[x]] then
        x := p[x] // przypadek 2
        Left-Rotate(root,x) // przypadek 2
        color[p[x]] := BLACK // przypadek 3
        color[p[p[x]]] := RED // przypadek 3
        Right-Rotate(root, p[p[x]]) { case 3}
    else ....{ to samo co po then z zamianą „right” oraz
    „left”}
        color[root] := BLACK
    */
    public void insert(Node root, Node x) {
        treeInsert(root, x);
        //kod z wykładu:
        while (x!=root && !x.parent.color){
            if (x.parent == x.parent.parent.left){
                Node y = x.parent.parent.right;
                if (!y.color){
                    x.parent.color=true;
                    y.color=true;
                    x.parent.parent.color=false;
                    x=x.parent.parent;
                }
                else if (y.color){
                    x.parent.color=true;
                    y.color=true;
                    x.parent.parent.color=false;
                    x=x.parent.parent;
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

    private void treeInsert(Node root, Node x) {
        if (root==null)root=x;
        else if (root.value.equals(x.value)) {
            root.row.add(x.row.get(0));
        } else if (root.value.compareTo(x.value) > 0) {
            if (root.right == null) {
                root.right = x;
                x.parent = root;
            } else {
                treeInsert(root.right, x);
            }
        } else if (root.value.compareTo(x.value) < 0) {
            if (root.left == null) {
                root.left = x;
                x.parent = root;
            } else {
                treeInsert(root.left, x);
            }
        }
        //DONE?
    }

    private void rotateLeft(Node root, Node x) {

    }

    private void rotateRight(Node root, Node x) {

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

    }

    private class Node {
        private Node parent = null;
        private Node left = null;
        private Node right = null;
        private String value = null;
        private boolean color = false;
        private ArrayList<Integer> row = new ArrayList<>();

        public Node(String value) {

            this.value = value;
        }

        public Node(Node p, Node left, Node right, String value) {

            this.parent = p;
            this.left = left;
            this.right = right;
            this.value = value;
        }

    }

}
