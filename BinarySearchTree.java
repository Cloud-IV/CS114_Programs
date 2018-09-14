//----------------------------------------------------------------------------------------------------------------------
// BinarySearchTree.java
// Author: Abrar Rouf (modified from given BinarySearchTree2.java [Author: Wallace Rutkowski])
// Defines binary search tree using a Node class. Includes insert, delete, display and getSuccessor methods.
//----------------------------------------------------------------------------------------------------------------------

public class BinarySearchTree
{
    private  Node root;


    public BinarySearchTree()
    {
        root = null;
    }

    public BinarySearchTree(BinarySearchTree t)
    {
        root = copyNode(t.root);
    }


    //====================================================
    private boolean find(int id)
    {
        Node current = root;
        while (current != null)
        {
            if (current.data == id)
            {
                return true;
            }
            else if (current.data > id)
            {
                current = current.left;
            }
            else
                {
                    current = current.right;
                }
        }
        return false;
    }

    //====================================================
    private boolean delete(int id)
    {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.data != id)
        {
            parent = current;
            if (current.data > id)
            {
                isLeftChild = true;
                current = current.left;
            }
            else
                {
                    isLeftChild = false;
                    current = current.right;
                }
            if (current == null)
            {
                return false;
            }
        }
        //If I am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null)
        {
            if (current == root)
            {
                root = null;
            }
            if (isLeftChild)
            {
                parent.left = null;
            }
            else
                {
                    parent.right = null;
                }
        }
        //Case 2 : if node to be deleted has only one child
        else if (current.right == null)
        {
            if (current == root)
            {
                root = current.left;
            }
            else if (isLeftChild)
            {
                parent.left = current.left;
            }
            else
                {
                    parent.right = current.left;
                }
        }
        else if (current.left == null)
        {
            if (current == root)
            {
                root = current.right;
            }
            else if (isLeftChild)
            {
                parent.left = current.right;
            }
            else
                {
                    parent.right = current.right;
                }
        }
        else if (current.left!=null && current.right!=null)
        {
            //now we have found the minimum element in the right sub tree
            Node successor  = getSuccessor(current);
            if (current == root)
            {
                root = successor;
            }
            else if (isLeftChild)
            {
                parent.left = successor;
            }
            else
                {
                    parent.right = successor;
                }
            successor.left = current.left;
        }
        return true;
    }

    //====================================================
    private Node getSuccessor(Node deleleNode)
    {
        Node successor = null;
        Node successorParent = null;
        Node current = deleleNode.right;
        while (current != null)
        {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
        // successorParent
        if (successor != deleleNode.right)
        {
            successorParent.left = successor.right;
            successor.right = deleleNode.right;
        }
        return successor;
    }

    //====================================================
    private void insert(int id)
    {
        Node newNode = new Node(id);
        if (root == null)
        {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true)
        {
            parent = current;
            if (id < current.data)
            {
                current = current.left;
                if (current == null)
                {
                    parent.left = newNode;
                    return;
                }
            }
            else
                {
                    current = current.right;
                    if (current == null)
                    {
                        parent.right = newNode;
                        return;
                    }
                }
        }
    }
    //====================================================
    private void display(Node root)
    {
        if (root != null)
        {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    private void display()
    {
        display(root);
    }
    //====================================================

    // Recursive method that is utilized in making a deep copy of an existing tree by copying the nodes of the original
    // tree.
    //-----------------------------------------------------------------------------------------------------------------
    private Node copyNode(Node root)
    {
        if (root != null)
        {
            int dataCopy = root.data;
            Node leftCopy = copyNode(root.left);
            Node rightCopy = copyNode(root.right);
            Node nodeCopy = new Node(dataCopy, leftCopy, rightCopy);
            return nodeCopy;
        }
        else return null;
    }

    // Recursive method that returns an integer that is the depth of the deepest node in the tree. Is called by
    // non-recursive method getDepth().
    //---------------------------------------------------------------------------------------------------------
    private int getDepth(Node root)
    {
        if (root != null) {
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            if (leftDepth > rightDepth) return (leftDepth + 1);
            else return (rightDepth + 1);
        }
        else
        {
            return 0;
        }
    }

    // Non-recursive method that calls recursive getDepth(Node root) to determine the depth of the deepest node in a tree.
    //--------------------------------------------------------------------------------------------------------------------
    public int getDepth()
    {
        return getDepth(root);
    }

    // Recursive method that returns the number of nodes in the tree. Is called by non-recursive method getSize().
    //------------------------------------------------------------------------------------------------------------
    private int getSize(Node root)
    {
        if (root != null)
        {
            int leftSize = getSize(root.left);
            int rightSize = getSize(root.right);
            return (leftSize + rightSize + 1);
        }
        else return 0;
    }

    // Non-recursive method that invokes recursive getSize(Node root) to determine the number of nodes in a tree.
    //-----------------------------------------------------------------------------------------------------------
    public int getSize()
    {
        return getSize(root);
    }


    public static void main(String arg[])
    {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);b.insert(8);
        b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
        b.insert(20);b.insert(25);b.insert(15);b.insert(16);

        System.out.println("Original Tree: ");
        b.display();
        System.out.println();
        /*System.out.println("Check whether Node with value 4 exists : " + b.find(4));
        System.out.println("Delete Node with no children (2) : " + b.delete(2));
        b.display();
        System.out.println("\n Delete Node with one child (4) : " + b.delete(4));
        b.display();
        System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));
        b.display();*/

        // Method calls for finding deepest node depth and number of nodes in original tree.
        System.out.println("Deepest node depth: " + b.getDepth());
        System.out.println("Number of nodes in tree: " + b.getSize());

        // Code for deep copying original tree and modifying deep copy of tree.
        BinarySearchTree bCopy = new BinarySearchTree(b);
        System.out.println("Copied tree: ");
        bCopy.display();
        System.out.println();
        bCopy.delete(8);
        bCopy.insert(32);
        System.out.println("Modified copy of tree: ");
        bCopy.display();
        System.out.println();
        System.out.println("Unmodified original tree: ");
        b.display();
    }
}


//====================================================
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }

    // Constructor that includes parameters for left and right pointers.
    //------------------------------------------------------------------
    Node (int data, Node left, Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
