import java.util.NoSuchElementException;

/**
 * BST.java - Represents a Binary Search Tree data structure
 * @author danielturato
 */

public class BST {

    /**
     * The root node of the BST
     */
    private BSTNode root;

    /**
     * Insert a new profile into the BST
     * @param p The new Profile to be added
     */
    public void insert(Profile p) {
        BSTNode newNode = new BSTNode(p);

        if (root == null) {
            root = newNode;
        } else {
            insertAt(root, newNode);
        }
    }

    /**
     * Insert a new node at a particular starting node
     * @param n The starting node
     * @param newNode The new node to be added to the BST
     */
    private void insertAt(BSTNode n, BSTNode newNode) {
        if (newNode.getProfile().getName().compareTo(n.getProfile().getName()) <= 0) {
            if (n.getL() == null) {
                n.setL(newNode);
            } else {
                insertAt(n.getL(), newNode);
            }
        } else {
            if (n.getR() == null) {
                n.setR(newNode);
            } else {
                insertAt(n.getR(), newNode);
            }
        }
    }

    /**
     * Search the BST for a node with a particular name
     * @param name The name used for the search
     * @return A profile instance containing the required name
     * @throws NoSuchElementException Thrown if a profile with that name isn't found
     */
    public Profile searchFor(String name) throws NoSuchElementException {
        return searchAt(name, root);
    }

    /**
     * Search the BST for a node with a particular name from a particular node
     * @param name The name used for the search
     * @param n The starting node of the search
     * @return A profile instance containing the required name
     * @throws NoSuchElementException Thrown if a profile with that name isn't found
     */
    private Profile searchAt(String name, BSTNode n) throws NoSuchElementException {
        if (n == null) {
            throw new NoSuchElementException("Profile not found in the tree. Exiting program.");
        }

        if (name.compareTo(n.getProfile().getName()) <= 0) {
            if (n.getProfile().getName().equals(name)) {
                return n.getProfile();
            } else {
                return searchAt(name, n.getL());
            }
        }

        return searchAt(name, n.getR());
    }

    /**
     * Print the BST in Alphabetical Order
     */
    public void printAlphabetical() {
        inOrder(root);
    }

    /**
     * Print the BST in Alphabetical Order (AKA In-Order traversal)
     * @param n The starting node of the traversal
     */
    private void inOrder(BSTNode n) {
        if (n.getL() != null) {
            inOrder(n.getL());
        }
        System.out.println(n.getProfile().getName());
        if (n.getR() != null) {
            inOrder(n.getR());
        }
    }
}
