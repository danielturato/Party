/**
 * BSTNode.java - Represents a Node in a Binary Search Tree data structure
 * @author danielturato
 */

public class BSTNode {

    /**
     * The data of the Node - Containing a user Profile
     */
    private Profile data;

    /**
     * The node connected to the left of {this} node.
     */
    private BSTNode l;

    /**
     * The node connected to the right of {this} node.
     */
    private BSTNode r;

    /**
     * The constructor of a BSTNode
     * @param data The user Profile that the node holds
     */
    public BSTNode(Profile data) {
        this.data = data;
    }

    /**
     * Get the user Profile of the node
     * @return The Profile of this node
     */
    public Profile getProfile() {
        return data;
    }

    /**
     * Set the node connected to the left of {this}
     * @param l The new left node
     */
    public void setL(BSTNode l) {
        this.l = l;
    }

    /**
     * Set the node connected to the right of {this}
     * @param r The new right node
     */
    public void setR(BSTNode r) {
        this.r = r;
    }

    /**
     * Get the node connected to the left of {this}
     * @return The left node
     */
    public BSTNode getL() {
        return l;
    }

    /**
     * Get the node connected to the right of {this}
     * @return The right node
     */
    public BSTNode getR() {
        return r;
    }
}
