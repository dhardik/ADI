package ds.tree;
public class BinarySearchTree 
{   
    private static class Node { 
        int data; 
        Node left, right; 
  
        public Node(int item) { 
            data = item; 
            left = right = null; 
        } 
    } 
  
    Node root; 

    public BinarySearchTree() {  
        root = null;  
    } 
  
    public void insert(int data) { 
       root = insertRec(root, data); 
    } 
      
    Node insertRec(Node root, int data) { 
  
   
        if (root == null) 
        { 
            root = new Node(data); 
            return root; 
        } 
        if (data < root.data) 
            root.left = insertRec(root.left, data); 
        else if (data > root.data) 
            root.right = insertRec(root.right, data); 

        return root; 
    }
    public void inOrder()  
    { 
       inOrderRec(root); 
    } 
    public void postOrder()
    { 
       postOrderRec(root); 
    } 
    public void preOrder()  
    { 
       preOrderRec(root); 
    } 
  
    void inOrderRec(Node root) 
    { 
        if (root != null) { 
            inOrderRec(root.left); 
            System.out.println(root.data); 
            inOrderRec(root.right); 
        } 
    } 
    void postOrderRec(Node root) 
    { 
        if (root != null) { 
            postOrderRec(root.left); 
            postOrderRec(root.right);
            System.out.println(root.data);  
        } 
    } 
    void preOrderRec(Node root) 
    { 
        if (root != null) { 
            System.out.println(root.data); 
            preOrderRec(root.left); 
            preOrderRec(root.right); 
        } 
    }
    public int height()
    {
        return(heightRec(root));
    }
    int heightRec(Node root)
    {
        if(root==null)
            return 0;
        int l=heightRec(root.left);
        int r=heightRec(root.right);
        if(l>r)
            return l+1;
        return r+1;
    }

    public void printPaths()  
    { 
        int path[] = new int[1000]; 
        printPathsRecur(root, path, 0); 
    } 
   
    void printPathsRecur(Node node, int path[], int pathLen)  
    { 
        if (node == null) 
            return; 
   
        path[pathLen] = node.data; 
        pathLen++; 
   
        if (node.left == null && node.right == null) 
            printArray(path, pathLen); 
        else 
        { 

            printPathsRecur(node.left, path, pathLen); 
            printPathsRecur(node.right, path, pathLen); 
        } 
    } 

    void printArray(int ints[], int len)  
    { 
        int i; 
        for (i = 0; i < len; i++)  
        { 
            System.out.print(ints[i] + " "); 
        } 
        System.out.println(""); 
    } 

    //--------------Level Order------------------------------//

    public void printLevelOrder() 
    { 
        int h = height(); 
        int i; 
        for (i=1; i<=h; i++) 
        {
            printGivenLevel(root, i); 
            System.out.println();
        }
    } 
    public void printRevLevelOrder() 
    { 
        int h = height(); 
        int i; 
        for (i=h; i>=1; i--) 
        {
            printGivenLevel(root, i); 
            System.out.println();
        }
    } 

    void printGivenLevel (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    }

    //-------------------Mirror------------------//
    public void mirror()
    {
        root=mirrorRec(root);
    }
    Node mirrorRec(Node root)
    {
        if(root==null)
            return root;
        Node l=mirrorRec(root.left);
        Node r=mirrorRec(root.right);

        root.left=r;
        root.right=l;

        return root;
    }

    //---------------------isBST------------------------//
    public boolean isBST()
    {
        return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean checkBST(Node root,int min,int max)
    {
        if(root==null)
            return true;

        if(root.data<min||root.data>max)
            return false;
        return(
                checkBST(root.left,min,root.data-1)&&
                checkBST(root.right,root.data+1,max)
            );
    }

    //----------------Diameter----------------------//

    int max(int a,int b)
    {
        if(a>b)
            return a;
        return b;
    }

    public int diameter()
    {
        return (dia(root));
    }

    int dia(Node root)
    {
        if(root==null)
            return 0;
        int lh=heightRec(root.left);
        int rh=heightRec(root.right);

        int ld=dia(root.left);
        int rd=dia(root.right);

        return max(lh+rh+1,max(ld,rd));
    }

    //------------Vertical Order--------------//
    class Values  
    { 
        int max, min; 
    }
    Values  val=new Values();
    void findMinMax(Node root, Values min, Values max, int hd)  
    { 
        if (root == null)  
            return; 

        if (hd < min.min)  
            min.min = hd; 
        else if (hd > max.max)  
            max.max = hd; 

        findMinMax(root.left, min, max, hd - 1); 
        findMinMax(root.right, min, max, hd + 1); 
    } 

     void printVerticalLine(Node root, int l, int hd)  
    { 
        if (root == null)  
            return; 
   
        if (hd == l)  
            System.out.print(root.data + " ");         
   
        printVerticalLine(root.left, l, hd - 1); 
        printVerticalLine(root.right, l, hd + 1); 
    }
    void verticalOrderfun(Node node)  
    { 
        findMinMax(node, val, val, 0); 
        for (int l = val.min; l <= val.max; l++)  
        { 
            printVerticalLine(node, l, 0); 
            System.out.println(""); 
        } 
    }    
    public void verticalOrder()
    {
        verticalOrderfun(root);
    }
    //------------Delete A Node-----------------//
    public void deleteKey(int key) 
    { 
        root = deleteRec(root, key); 
    } 
    int minValue(Node root) 
    { 
        int minv = root.data; 
        while (root.left != null) 
        { 
            minv = root.left.data; 
            root = root.left; 
        } 
        return minv; 
    } 
    Node deleteRec(Node root, int key) 
    { 
        if (root == null)  return root; 
  
        if (key < root.data) 
            root.left = deleteRec(root.left, key); 
        else if (key > root.data) 
            root.right = deleteRec(root.right, key); 

        else
        {
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
            root.data = minValue(root.right); 
            root.right = deleteRec(root.right, root.data); 
        } 
  
        return root; 
    } 

    //-----------------Lowest Common Ancestor------------//
    Node lcaRec(Node root, int n1, int n2)  
    { 
        if (root == null) 
            return null; 
        if (root.data > n1 && root.data > n2) 
            return lcaRec(root.left, n1, n2); 
        if (root.data < n1 && root.data < n2)  
            return lcaRec(root.right, n1, n2); 
   
        return root; 
    } 
    public int lca(int n1,int n2)
    {
        Node t= lcaRec(root,n1,n2);
        return t.data;
    }

    public void delete()
    {
        root=null;
        System.out.println("Tree Deleted");
    }
}