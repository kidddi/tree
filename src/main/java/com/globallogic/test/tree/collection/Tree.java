package com.globallogic.test.tree.collection;

import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
public class Tree<T extends Comparable<T>> {

    private Node<T> head;

    public Tree(T value) {
        head = new Node<>(value);
    }

    public Tree() {
        head = null;
    }

    private Tree(Node<T> node) {
        head = node;
    }

    public Node<T> get(T value) {
        return get(head, value);
    }

    public Tree<T> getSubtree(T value) {
        return new Tree<>(get(head, value));
    }

    private Node<T> get(Node<T> node, T value) {
        return find(node, value);
    }

    public void add(T value) {
        add(head, null, value);
    }

    private void add(Node<T> node, Node<T> parent, T value) {
        if (head == null) {
            head = new Node<>(value, parent);
        } else if (value.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(value, node));
            } else {
                add(node.getLeft(), node, value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<>(value, node));
            } else {
                add(node.getRight(), node, value);
            }
        }
    }

    public boolean contains(T value) {
        return find(head, value) != null;
    }

    public void remove(T value) {
        remove(head, value);
    }

    private void remove(Node<T> node, T value) {
        Node<T> foundNode = find(node, value);
        if (foundNode != null) {
            replace(foundNode, null);
        }
    }

    private Node<T> find(Node<T> node, T value) {
        while (node != null) {
            if (value.compareTo(node.getData()) < 0) {
                node = node.getLeft();
            } else if (value.compareTo(node.getData()) > 0) {
                node = node.getRight();
            } else {
                break;
            }
        }
        return node;
    }

    private void replace(Node<T> source, Node<T> target) {
        if (source.getParent() == null) {
            head = target;
        } else if (source == source.getParent().getLeft()) {
            source.getParent().setLeft(target);
        } else {
            source.getParent().setRight(target);
        }
        if (target != null) {
            target.setParent(source.getParent());
        }
    }

    public Stream<T> stream() {
        return values(head, Lists.newArrayList()).stream();
    }

    private List<T> values(Node<T> node, List<T> list) {
        if (node != null) {
            list.add(node.getData());
            values(node.getLeft(), list);
            values(node.getRight(), list);
        }
        return list;
    }
}