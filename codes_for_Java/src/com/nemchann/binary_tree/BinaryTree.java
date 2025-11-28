package com.nemchann.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    Node root;
    private int size;

    public BinaryTree() {
        this.size = 0;
    }

    public BinaryTree(int rootValue) {
        this.root = new Node();
        root.setValue(rootValue);
        this.size = 1;
    }

    public void addValue(int number){
        if (root == null){
            root = new Node();
            root.setValue(number);
            size = 1;
        }
        else{
            recursiveInsert(root, number);
            size++;
        }
    }

    private void recursiveInsert(Node current, int value){
        if (current.getValue() < value){
            if (current.hasLeft()){
                recursiveInsert(current.getLeft(), value);
            }
            else{
                current.setLeft(new Node());
                current.getLeft().setValue(value);
            }
        }
        else{
            if (current.hasRight()){
                recursiveInsert(current.getRight(), value);
            }
            else{
                current.setRight(new Node());
                current.getRight().setValue(value);
            }
        }
    }

    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node node, List<Integer> result) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), result);
            result.add(node.getValue());
            inOrderTraversal(node.getRight(), result);
        }
    }

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        return this.inOrder().toString();
    }
}
