package basic_data_structures.trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value){
        // if value is equal to the data
        if(value == data){
            return; //return nothing
        }

        // if greater than the data
        if(value < data){
            //if the leftchild is empty
            if(leftChild == null){
                //then insert the value in that child
                leftChild = new TreeNode(value);
            }else{
                //else call insert again and keep checking for the above condition
                leftChild.insert(value);
            }
        }else {
            //SAME EXPLANATION AS LEFT CHILD
            if(rightChild == null){
                rightChild = new TreeNode(value);
            }else{
                rightChild.insert(value);
            }
        }

    }

    public TreeNode get(int value){
        //if the value and data are equal
        if(value == data){
            return this; //return the object
        }

        if(value < data){ //if value is less than the data
            //search left child until it is null
            if(leftChild != null){
                return leftChild.get(value);
            }
        }else{ //else search right child until it is null
            if(rightChild != null){
                return rightChild.get(value);
            }
        }

        //if you cant find anything, return null
        return null;
    }



    public void traverseInorder(){

        if(leftChild != null){ // visit left first
            leftChild.traverseInorder();
        }
        System.out.print(data + ", ");
        if(rightChild != null){ // then visit right
            rightChild.traverseInorder();
        }
    }

    public void traversePreorder(){
        System.out.print(data + ", ");
        if(leftChild != null){
            leftChild.traversePreorder();
        }
        if(rightChild != null){
            rightChild.traversePreorder();
        }
    }

    public void traversePostorder(){
        if(leftChild != null){
            leftChild.traversePostorder();
        }
        if(rightChild != null){
            rightChild.traversePostorder();
        }
        System.out.print(data + ", ");
    }

    public void traverseLevelOrder(){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while(!queue.isEmpty()){
            TreeNode actual = queue.remove();
            System.out.print(actual.data+" ");
            if(actual.leftChild != null){
                queue.add(actual.leftChild);
            }
            if(actual.rightChild != null){
                queue.add(actual.rightChild);
            }
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int min(){
        //if the left child is null i.e -- the left most node has no left child,
        //it means we've hit the minimum value
        if(leftChild == null){
            return data;
        }else{
            //else keep traversing left children (nodes)
            return leftChild.min();
        }

    }

    public int max(){
        //if the right child is null, i.e --- the right most node has no right child
        //it means we've hit the maximum value
        if(rightChild == null){
            return data;
        }else {
            //else keep traversing the right children (nodes)
            return rightChild.max();
        }

    }

};

class Tree{
    private TreeNode rootNode;

    //call insert in the tree class
    public void insert(int value){
        //if the root node is null i.e. if tree is empty
        if(rootNode == null){
            rootNode = new TreeNode(value); // then the value passed is the root node
        }else{
            //else, call insert from TreeNode class
            rootNode.insert(value);
        }

    }

    public void traverseInorder(){
        if(rootNode != null){
            rootNode.traverseInorder();
        }
    }

    public void traversePreorder(){
        if(rootNode != null){
            rootNode.traversePreorder();
        }
    }

    public void traversePostorder(){
        if(rootNode != null){
            rootNode.traversePostorder();
        }
    }

    public void traverseLevelOrder(){
        if(rootNode != null){
            rootNode.traverseLevelOrder();
        }
    }

    public TreeNode get(int value){
        //search for the value
        if(rootNode != null){
            return rootNode.get(value);
        }

        //if not found, null
        return null;
    }

    public int max(){
        if(rootNode == null){
            return Integer.MAX_VALUE;
        }else{
            return rootNode.max();
        }
    }

    public int min(){
        if(rootNode == null){
            return Integer.MIN_VALUE;
        }else{
            return rootNode.min();
        }
    }

    public void delete(int value){
        //root of the subtree -- we're going to return the root of the tree
        rootNode = delete(rootNode, value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value){

        if(subTreeRoot == null){
            return subTreeRoot;
        }

        if(value < subTreeRoot.getData()){
            //if the value is less than the subtree's value, we search the subtree's left child
            //then we call it again by calling delete but we pass the left child of the subTreeRoot
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(),value));
        }else if (value > subTreeRoot.getData()){
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(),value));
        }else{
            //if this is a leaf, the left child will be null, so it'll be replaced by it's right child
            //CASES 1 & 2: node to delete has 0 or 1 children
            if(subTreeRoot.getLeftChild() == null){
                return subTreeRoot.getRightChild();
            }else if( subTreeRoot.getRightChild() == null){
                //if the nose has no right child but left child
                return subTreeRoot.getLeftChild();
            }

            //CASE 3 : NODE TO DELETE HAS TWO CHILDREN
            //find the minimum value of the right subtree and replace the subtree value with it
            subTreeRoot.setData(subTreeRoot.getRightChild().min());

            //Delete the node that has the smallest value in the right subtree
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(),subTreeRoot.getData()));
        }

        return subTreeRoot;
    }

};

public class BinarySearchTree {

    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);


        System.out.println("Inorder: ");
        intTree.traverseInorder();
        System.out.println("\nPreorder: ");
        intTree.traversePreorder();
        System.out.println("\nPostorder: ");
        intTree.traversePostorder();
        System.out.println("\nLevelorder: ");
        intTree.traverseLevelOrder();
        System.out.println("\n");

        System.out.println(intTree.get(27));
        System.out.println(intTree.get(32));
        System.out.println(intTree.get(10));


        System.out.println("Maximum value : " + intTree.max());
        System.out.println("Minimum value : " + intTree.min());
        System.out.println("Deleted 15");

        intTree.delete(15);
        intTree.traverseInorder();

        System.out.println("\nDeleted 27");
        intTree.delete(27);
        intTree.traverseInorder();

        System.out.println("\nDeleted 25");
        intTree.delete(25);
        intTree.traverseInorder();


    }
}
