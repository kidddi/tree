package com.globallogic.test.tree;

import com.globallogic.test.tree.model.Tree;
import com.globallogic.test.tree.service.tree.SearchTreeService;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
public class Main {

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>("one");
        SearchTreeService<String> service = new SearchTreeService<>(tree);

        tree.add("two");
        tree.add("three");
        tree.add("four");
        tree.add("five");
        tree.add("six");

        System.out.println("Before deleting: " + service.findAll());
        tree.remove("six");
        System.out.println("After deleting:  " + service.findAll());

        System.out.println("Found:" + service.find("three").orElse("none"));


    }
}