package com.nemchann.binary_tree;

public class Node {
    private int value;
    private Node parent; //Родитель
    private Node left; //Левый ребенок
    private Node right; //Правый ребенок

    public Node(){
        this.value = 0;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        if (left != null){
            left.setParent(this);
        }
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        if (right != null){
            right.setParent(this);
        }
    }
//Является ли листом
    public boolean isLeaf(){
        return (left == null && right == null);
    }

    public boolean hasLeft(){
        return left != null;
    }

    public boolean hasRight(){
        return right != null;
    }

    public String toString(){
        return "Node {" + value + "}";
    }
}
