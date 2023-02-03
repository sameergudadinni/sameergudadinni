Find path in BST
Send Feedback
Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST) in a list. Return empty list otherwise.
Note: Assume that BST contains all unique elements.
Input Format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of k.
Output Format :
The first line and only line of output prints the data of the nodes in the path from node k to root. The data of the nodes is separated by single space.
Constraints:
Time Limit: 1 second   
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1:
2 5 8
  
  
  import java.util.ArrayList;
import java.util.Scanner;

public class binarySearchTree {
    public static BinaryTreeNode<Integer> takeTreeinputBatter(boolean isRoot, int parentdata, boolean isleft) {
        if (isRoot) {
            System.out.println("Enter Root data:");
        } else {
            if (isleft) {
                System.out.println("Enter left child of:" + parentdata);
            } else {
                System.out.println("Enter right child of:" + parentdata);
            }
        }
        Scanner sc = new Scanner(System.in);
        int rootdata = sc.nextInt();
        if (rootdata == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        BinaryTreeNode<Integer> leftchild = takeTreeinputBatter(false, rootdata, true);
        BinaryTreeNode<Integer> rightchild = takeTreeinputBatter(false, rootdata, false);

        root.left = leftchild;
        root.right = rightchild;
        return root;

    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ":");
        if (root.left != null) {
            System.out.print("L:" + root.left + ",");
        }
        if (root.right != null) {
            System.out.print("R:" + root.right);
        }

    }

    public static ArrayList<Integer> getpath(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }
        if (data < root.data) {
            ArrayList<Integer> output2 = getpath(root.left, data);
            if (output2 != null) {
                output2.add(root.data);
                return output2;
            }

        }
        if (data > root.data) {
            ArrayList<Integer> output3 = getpath(root.right, data);
            if (output3 != null) {
                output3.add(root.data);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeinputBatter(true, 0, true);
        printTreeDetailed(root);
        ArrayList<Integer> path = getpath(root, 3);
        for (int i : path) {
            System.out.println(i);
        }
    }

}
