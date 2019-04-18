package com.globallogic.test.tree.service.tree;

import com.globallogic.test.tree.model.Tree;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
public class TreeManager<T extends Comparable<T>> {

    private Tree<T> tree;

    public TreeManager(Tree<T> tree) {
        this.tree = tree;
    }

    public int countChildren(T value) {
        return (int) tree.getSubtree(value).stream().count();
    }
}
