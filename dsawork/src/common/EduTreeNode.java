package common;

public class EduTreeNode {

    public int data;
    public EduTreeNode left;
    public EduTreeNode right;
    public EduTreeNode parent;

    public EduTreeNode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
