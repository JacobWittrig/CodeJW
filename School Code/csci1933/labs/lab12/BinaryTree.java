import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
public class BinaryTree<V extends Comparable<V>> {
    private Node<V> root;

    public BinaryTree(Node<V> root) {
        this.root = root;
    }

    public Node<V> getRoot() {
        return this.root;
    }

    private int count(Node<V> node){
        int count=0;
        if(node!=null){
            int l = count(node.getLeft());
            int r=count(node.getRight());
            return 1 + l + r;}
            return 0;
        }
    

    public LinkedList<V> getVals(Node <V> node,LinkedList<V> vals){
        if(node.getLeft()!=null)
            getVals(node.getLeft(),vals);
        if(node.getRight()!=null)
            getVals(node.getRight(),vals);
        vals.add(node.getValue());
        return vals;
    }

    public void printInorder() {
        printInOrderHelper(root);
    }
    private void printInOrderHelper(Node<V> node) {
        if(node.getLeft()!=null)
            printInOrderHelper(node.getLeft());
        System.out.print(node.getValue()+" ");
        if(node.getRight()!=null)
            printInOrderHelper(node.getRight());
        
    }

    public void printPreorder(){
        printPreorderHelper(root);
    }
    private void printPreorderHelper(Node<V> node) {
        System.out.print(node.getValue()+" ");
        if(node.getLeft()!=null)
            printPreorderHelper(node.getLeft());
        if(node.getRight()!=null)
            printPreorderHelper(node.getRight());
        
    }

    public void printPostorder() {
        printPostorderHelper(root);
    }
    private void printPostorderHelper(Node<V> node) {
        if(node.getLeft()!=null)
            printPostorderHelper(node.getLeft());
        if(node.getRight()!=null)
            printPostorderHelper(node.getRight());
        System.out.print(node.getValue()+" ");
        
    }

    public int flattenHelper(Node<V> node,V[] arr, int i){
        if (node==null){return i;}
        i = flattenHelper(node.getLeft(),arr,i);
        arr[i]=node.getValue();
        i=flattenHelper(node.getRight(), arr, i+1);
        return i;
    }

    public V[] flatten() {
        int length=count(getRoot());
        V[] arr = (V[]) new Comparable[length];
        flattenHelper(getRoot(),arr,0);
        sort(arr);
        return arr;
    }

    // bubble sort
    // useful for flatten
    public void sort(Comparable[] a) {
        int i, j;
        Comparable temp;
        boolean swapped = true;
        for (i = 0; i < a.length && swapped == true; i++) {
            swapped = false;
            for (j = 1; j < a.length - i; j++) {
                if (a[j].compareTo(a[j-1]) < 0) {
                    swapped = true;
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    public void invert() {
        invertHelper(root);
    }

    public Node<V> invertHelper(Node<V> node) {
        Node<V> temp=node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);
        if(node.getLeft()!=null)
        invertHelper(node.getLeft());
        if(node.getRight()!=null)
        invertHelper(node.getRight());
        return null;
    }
    public boolean checkifsubtree(Node<V> node,BinaryTree<V> other){
        BinaryTree<V> newtree=new BinaryTree<V>(node);
        // System.out.println(newtree.flatten());
        // System.out.println(other.flatten());
        return newtree.flatten().equals(other.flatten());
    }

    public boolean containsSubtreeHelp(Node<V> node,BinaryTree<V> other,boolean found){
        
        
        if(node.getLeft()!=null)
        found|=containsSubtreeHelp(node.getLeft(), other,found);
        if(node.getRight()!=null)
        found|=containsSubtreeHelp(node.getLeft(), other,found);
        found|=checkifsubtree(node,other);
        return found;
    }

    public boolean containsSubtree(BinaryTree<V> other) {
        Node <V>start=this.root;
        return containsSubtreeHelp(start,this,false);
        
        
    }
    

    // Main contains tests for each milestone.
    // Do not modify existing tests.
    // Un-comment tests by removing '/*' and '*/' as you move through the milestones.
    public static void main (String args[]) {
        // Tree given for testing on
        BinaryTree<Integer> p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4, null, null),
                        new Node<Integer>(5, null, null)),
                new Node<Integer>(3, null, null)));

        // Milestone 1 (Traversing)
        System.out.println("--- Milestone 1 ---");
        System.out.print("Expected: 4 2 5 1 3" + System.lineSeparator() + "Actual: ");
        p1Tree.printInorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 1 2 4 5 3" + System.lineSeparator() + "Actual: ");
        p1Tree.printPreorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 4 5 2 3 1" + System.lineSeparator() + "Actual: ");
        p1Tree.printPostorder();
        System.out.println();

        // Milestone 2 (flatten) -- expected output: 1 2 3 4 5
        
        System.out.println(System.lineSeparator() + "--- Milestone 2 ---");
        System.out.print("Expected: 1 2 3 4 5" + System.lineSeparator() + "Actual: ");

        Comparable[] array_representation = p1Tree.flatten();
        for (int i = 0; i < array_representation.length; i++) {
            System.out.print(array_representation[i] + " ");
        }
        System.out.println();
        

        // Milestone 3 (invert)
        
        System.out.println(System.lineSeparator() + "--- Milestone 3 ---");

        p1Tree.invert();

        System.out.print("Expected: 3 1 5 2 4" + System.lineSeparator() + "Actual: ");
        p1Tree.printInorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 1 3 2 5 4" + System.lineSeparator() + "Actual: ");
        p1Tree.printPreorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 3 5 4 2 1" + System.lineSeparator() + "Actual: ");
        p1Tree.printPostorder();
        System.out.println();
        

        // Milestone 4 (containsSubtree)
        
        System.out.println(System.lineSeparator() + "--- Milestone 4 ---");

        p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4, null, null),
                        new Node<Integer>(5, null, null)),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p2Tree = new BinaryTree<Integer>(new Node<Integer>(2,
                new Node<Integer>(4, null, null),
                new Node<Integer>(5, null, null)));
        BinaryTree<Integer> p3Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2, null, null),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p4Tree = null;

        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p2Tree));
        System.out.println();

        System.out.print("Expected: false" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p3Tree));
        System.out.println();

        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p4Tree));
        

    }
}
