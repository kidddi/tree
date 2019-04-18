package com.globallogic.test.tree.service.tree;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.globallogic.test.tree.model.Tree;
import com.globallogic.test.tree.service.SearchService;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
public class SearchTreeService<T extends Comparable<T>> implements SearchService {

    private Tree<T> tree;

    public SearchTreeService(Tree<T> tree) {
        this.tree = tree;
    }

    @Override
    public List<T> findAll() {
        return tree.stream().collect(Collectors.toList());
    }

    @Override
    public Optional<T> find(Object o) {
        return tree.stream().filter(o::equals).findFirst();
    }
}
