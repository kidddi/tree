package com.globallogic.test.tree;

import com.globallogic.test.tree.collection.Tree;
import com.globallogic.test.tree.service.tree.SearchTreeService;
import com.globallogic.test.tree.service.tree.TreeManager;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
public class Main {

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();
        SearchTreeService<String> service = new SearchTreeService<>(tree);

//        tree.remove("one");

        tree.add("two");
        tree.add("three");
        tree.add("four");
        tree.add("five");
        tree.add("six");

        //remove method
        System.out.println("Before deleting: " + service.findAll());
        tree.remove("six");
        System.out.println("After deleting:  " + service.findAll());

        //find method
        System.out.println("Found: " + service.find("three").orElse("none"));

        //getting subtrees
        Tree<String> subtree = tree.getSubtree("two");
        service = new SearchTreeService<>(subtree);
        System.out.println("Subtree:  " + service.findAll());

        //tree manager
        TreeManager<String> manager = new TreeManager<>(tree);
        System.out.println("Count children for value 'two': " + manager.countChildren("two"));
    }
}