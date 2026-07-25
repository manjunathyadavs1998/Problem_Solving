package Trees;

import java.util.HashMap;
import java.util.Map;

public class TreeConstruction {
    private final Map<Integer, Integer> inorderMap = new HashMap<>();
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        System.out.println("Starting Construction...");
        System.out.println("--------------------------------");

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd) {

        System.out.println();
        System.out.println("build(" + inStart + ", " + inEnd + ")");
        System.out.println("Current postIndex = " + postIndex);

        if (inStart > inEnd) {
            System.out.println("Base Case -> return null");
            return null;
        }

        int rootValue = postorder[postIndex--];

        System.out.println("Picked Root = " + rootValue);

        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = inorderMap.get(rootValue);

        System.out.println("Root found at inorder index = " + inorderIndex);

        System.out.println("Construct RIGHT subtree of " + rootValue);
        root.right = build(inorder, postorder, inorderIndex + 1, inEnd);

        System.out.println("Construct LEFT subtree of " + rootValue);
        root.left = build(inorder, postorder, inStart, inorderIndex - 1);

        System.out.println("Returning Node = " + rootValue);

        return root;
    }

    // -----------------------------
    // Utility method to verify tree
    // -----------------------------
    public void printLevelOrder(TreeNode root) {

        if (root == null) {
            System.out.println("Tree Empty");
            return;
        }

        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);

        System.out.println("\nConstructed Tree (Level Order):");

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                TreeNode node = q.poll();

                System.out.print(node.val + " ");

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }

            System.out.println();
        }
    }

    // -----------------------------
    // Driver
    // -----------------------------
    public static void main(String[] args) {

        TreeConstruction sol = new TreeConstruction();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = sol.buildTree(inorder, postorder);

        sol.printLevelOrder(root);
    }
}
