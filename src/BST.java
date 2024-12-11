import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {

        return this.root;
    }

    public void setRoot(BSTNode root) {

        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // Calls helper method to check
        if (searchHelp(val, root))
        {
            // If the value is in the tree return true
            return true;
        }
        // Else return false
        return false;
    }
    public boolean searchHelp(int val, BSTNode node) {
        // Base case #1 if null
        if(node == null)
        {
            return false;
        }
        // Base case #2 if it equals val
        if(node.getVal() == val)
        {
            return true;
        }
        // Checks down the tree both left and right
        return searchHelp(val, node.getLeft()) || searchHelp(val, node.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // Creates return variable
        ArrayList<BSTNode> ret = new ArrayList<BSTNode>();
        // Calls helper method
        inHelp(root, ret);
        // Returns variable
        return ret;
    }
    public void inHelp (BSTNode node, ArrayList<BSTNode> ret) {

        // Base case
        if(node == null)
        {
            return;
        }
        // Checks left node
        inHelp(node.getLeft(), ret);
        // Adds the node
        ret.add(node);
        // Checks right node
        inHelp(node.getRight(), ret);

    }
    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // Create return statement
        ArrayList<BSTNode> ret = new ArrayList<BSTNode>();
        // Calls helper method
        preHelp(root, ret);
        // Returns order
        return ret;
    }
    public void preHelp (BSTNode node, ArrayList<BSTNode> ret) {

        // Base case
        if(node == null)
        {
            return;
        }
        // Adds the node
        ret.add(node);
        // Checks left node
        preHelp(node.getLeft(), ret);
        // Checks right node
        preHelp(node.getRight(), ret);

    }
    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // Creates return variable
        ArrayList<BSTNode> ret = new ArrayList<BSTNode>();
        // Calls helper method
        postHelp(root, ret);
        // Returns order of nodes
        return ret;
    }
    public void postHelp (BSTNode node, ArrayList<BSTNode> ret) {

        // Base case
        if(node == null)
        {
            return;
        }
        // Checks left node
        postHelp(node.getLeft(), ret);
        // Checks right node
        postHelp(node.getRight(), ret);
        // Prints the root
        ret.add(node);
    }
    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // Modifies root to be new root of modified tree
        root = insertHelp(root, val);
    }
    public BSTNode insertHelp(BSTNode node, int value)
    {
        // Base case, if there is no more things to navigate, the new node is placed at that place
        if(node==null)
        {
            return new BSTNode(value);
        }
        // The if else statement navigates the entire tree to find the spot where the node is supposed to be
        // Will go until the new node finds its exact place
        if (value > node.getVal())
        {
            // The right node will become the root of the new subtree
            node.setRight(insertHelp(node.getRight(),value));
        }
        else if (value < node.getVal())
        {
            // The left node will become the root of the new subtree
            node.setLeft(insertHelp(node.getLeft(),value));
        }
        // If it is equal to an already existing node just don't change the root
        else
        {
            return root;
        }
        return node;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
       printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
