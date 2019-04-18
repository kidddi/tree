package com.globallogic.test.tree.model;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    public Node(T data) {
        this(data, null);
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T value) {
        this.data = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}

