package twospointers;

import common.EduBinaryTree;
import common.EduTreeNode;

import java.util.Arrays;
import java.util.List;

public class P008_Medium_LowestCommonAncestorOfABinaryTree3 {


    /*

    Understand how to find the lowest common ancestor of two nodes in a binary tree when parent pointers are available.
     This lesson helps you apply two-pointer strategies to navigate upward through the tree and determine the common
      ancestor, even without a root reference, enhancing your problem-solving skills for coding interviews.

    Statement
    You are given two nodes, p and q. The task is to return their lowest common ancestor (LCA). Both nodes have
    a reference to their parent node. The tree’s root is not provided; you must use the parent pointers to find
    the nodes’ common ancestor.

    Note: The lowest common ancestor of two nodes, p and q, is the lowest node in the binary tree, with both p
    and q as descendants.

    In a tree, a descendant of a node is any node reachable by following edges downward from that node,
    including the node itself.

     */

    public static EduTreeNode LowestCommonAncestor(EduTreeNode p, EduTreeNode q) {
        // Initialize two pointers, ptr1 and ptr2, to the starting nodes p and q.

        // Enter a loop that continues as long as the two pointers are not at the same node.
        // For the first pointer:
        // Check if the current node has a parent.
        // If it does, move the pointer one step up to its parent.
        // If the pointer has reached the root (parent is null):
        // Redirect the pointer to start from node q.

        // For the second pointer:
        // Check if the current node has a parent.
        // If it does, move the pointer one step up to its parent.
        // If the pointer has reached the root (parent is null):
        // Redirect the pointer to start from node p.

        // Once the loop terminates, the pointers have met at the lowest common ancestor.
        // Return the node where both pointers converged.

        EduTreeNode ptr1 = p;
        EduTreeNode ptr2 = q;

        while (ptr1  != ptr2) {

            if(ptr1.parent != null) {
                ptr1 = ptr1.parent;
            }
            else {
                ptr1 = q;
            }

            if(ptr2.parent != null) {
                ptr2 = ptr2.parent;
            }
            else {
                ptr2 = p;
            }
        }

        return ptr1;
    }

    public static void main(String[] args) {
        List<List<Integer>> input_trees = Arrays.asList(
                Arrays.asList(100, 50, 200, 25, 75, 350),
                Arrays.asList(100, 200, 75, 50, 25, 350),
                Arrays.asList(350, 100, 75, 50, 200, 25),
                Arrays.asList(100, 50, 200, 25, 75, 350),
                Arrays.asList(25, 50, 75, 100, 200, 350)
        );
        List<List<Integer>> input_nodes = Arrays.asList(
                Arrays.asList(25, 75),
                Arrays.asList(50, 350),
                Arrays.asList(100, 200),
                Arrays.asList(50, 25),
                Arrays.asList(350, 200)
        );

        for (int i = 0; i < input_trees.size(); i++) {
            EduBinaryTree tree = new EduBinaryTree(input_trees.get(i));
            System.out.println((i + 1) + ".\tBinary tree:");
            //Print.displayTree(tree.getRoot());
            System.out.println("\n\tp = " + input_nodes.get(i).get(0));
            System.out.println("\tq = " + input_nodes.get(i).get(1));
            EduTreeNode p = tree.find(tree.getRoot(), input_nodes.get(i).get(0));
            EduTreeNode q = tree.find(tree.getRoot(), input_nodes.get(i).get(1));
            EduTreeNode lca = LowestCommonAncestor(p, q);
            System.out.println("\n\tLowest common ancestor: " + lca.data);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }

}
