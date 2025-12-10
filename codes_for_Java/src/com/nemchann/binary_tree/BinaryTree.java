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
        if (value < current.getValue()){
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

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.getValue()) {
            return true;
        }

        return value < current.getValue()
                ? containsRecursive(current.getLeft(), value)
                : containsRecursive(current.getRight(), value);
    }

    public void remove(int value) {
        root = removeRecursive(root, value);
        if (root != null) {
            size--;
        }
    }

    private Node removeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.getValue()) {
            if (current.isLeaf()) {
                return null;
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }
            // Находим минимальное значение в правом поддереве
            int smallestValue = findSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(removeRecursive(current.getRight(), smallestValue));
            return current;
        }

        if (value < current.getValue()) {
            current.setLeft(removeRecursive(current.getLeft(), value));
        } else {
            current.setRight(removeRecursive(current.getRight(), value));
        }

        return current;
    }

    private int findSmallestValue(Node root) {
        return root.getLeft() == null
                ? root.getValue()
                : findSmallestValue(root.getLeft());
    }

    public boolean isValidBST() {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.getValue() <= min || node.getValue() >= max) {
            return false;
        }

        return isValidBST(node.getLeft(), min, node.getValue()) &&
                isValidBST(node.getRight(), node.getValue(), max);
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
