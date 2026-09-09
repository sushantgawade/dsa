package common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EduBinaryTree {

    public EduTreeNode getRoot() {
        return root;
    }

    public void setRoot(EduTreeNode root) {
        this.root = root;
    }

    EduTreeNode root;



    EduTreeNode createBinaryTree(List<Integer> nodes) {

        if(nodes == null || nodes.isEmpty() || nodes.get(0) == 0) {
            return null;
        }

        EduTreeNode root =  new EduTreeNode(nodes.get(0));

        Queue<EduTreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int i = 1;

        while (i < nodes.size()) {

            EduTreeNode current  =  queue.poll();

            if(i < nodes.size() && nodes.get(i) != 0) {

                current.left =  new EduTreeNode(nodes.get(i));
                current.left.parent =  current;
                queue.offer(current.left);
            }
            i++;

            if(i < nodes.size() && nodes.get(i) != 0) {

                current.right =  new EduTreeNode(nodes.get(i));
                current.right.parent = current;
                queue.offer(current.right);
            }
            i++;

        }

        return root;
    }

    public EduBinaryTree(List<Integer> nodes) {
        this.root = createBinaryTree(nodes);
    }

    public EduTreeNode find(EduTreeNode root, int val) {

        if(root == null) {

            return null;
        }

        Queue<EduTreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {

            EduTreeNode current =  queue.poll();

            if(current.data  == val ) {

                return  current;
            }

            if( current.left != null) {

                queue.offer(current.left);
            }

            if( current.right != null) {

                queue.offer(current.right);
            }

        }

        return null;
    }

}
