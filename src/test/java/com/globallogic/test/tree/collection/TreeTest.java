package com.globallogic.test.tree.collection;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
public class TreeTest {

    private Tree<String> tree;

    @Before
    public void setUp() {
        tree = new Tree<>();
        tree.add("one");
        tree.add("two");
        tree.add("three");
        tree.add("four");
        tree.add("five");
        tree.add("six");
    }

    @Test
    public void get() {
        assertEquals("four", tree.get("four").getData());
    }

    @Test
    public void getSubtree() {
        List<String> expectedList = Lists.newArrayList("two", "three", "six");
        Tree<String> subtree = tree.getSubtree("two");

        assertEquals(expectedList, subtree.stream().collect(Collectors.toList()));
    }

    @Test
    public void remove() {
        assertTrue(tree.contains("six"));
        tree.remove("six");
        assertFalse(tree.contains("six"));
    }

    @Test
    public void stream() {
        assertEquals(6, tree.stream().count());
    }
}