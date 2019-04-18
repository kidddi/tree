package com.globallogic.test.tree.service.tree;

import com.globallogic.test.tree.model.Tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
public class TreeManagerTest {

    private Tree<String> tree;
    private TreeManager<String> manager;

    @Before
    public void setUp() {
        tree = new Tree<>("Bob");
        tree.add("John");
        tree.add("Alex");
        tree.add("Paul");
        manager = new TreeManager<>(tree);
    }

    @Test
    public void countChildren() {
        assertEquals(2, manager.countChildren("John"));
    }
}