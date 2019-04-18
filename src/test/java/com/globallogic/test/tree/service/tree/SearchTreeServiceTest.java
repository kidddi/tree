package com.globallogic.test.tree.service.tree;

import java.util.Optional;

import com.globallogic.test.tree.model.Tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
public class SearchTreeServiceTest {

    private Tree<Integer> tree;
    private SearchTreeService<Integer> service;

    @Before
    public void setUp() {
        tree = new Tree<>(2);
        service = new SearchTreeService<>(tree);
        tree.add(4);
        tree.add(6);
        tree.add(7);
        tree.add(9);
    }

    @Test
    public void findAll() {
        assertEquals(5, service.findAll().size());
        tree.remove(9);
        assertEquals(4, service.findAll().size());

    }

    @Test
    public void find() {
        assertEquals(Optional.of(7), service.find(7));
        tree.remove(7);
        assertEquals(Optional.empty(), service.find(7));
    }
}