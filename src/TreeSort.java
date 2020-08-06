public class TreeSort {

    class Node {
        int key;
        Node left, right;

        Node(int item){
            key = item;
            left = right = null;
        }
    }

    Node root;

    TreeSort(){
        root = null;
    }

    void insert(int key){
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key){
        if(root == null){
            root = new Node(key);
        }
        if(key > root.key){
            root.right = insertRec(root.right, key);
        }
        if(key < root.key){
            root.left = insertRec(root.left, key);
        }
        return root;
    }

    void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.print(root.key+" ");
            inorderRec(root.right);
        }
    }

    void treeins(int[] m){
        for(int i = 0; i < m.length; i++){
            insert(m[i]);
        }
    }
}
