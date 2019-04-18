package com.globallogic.test.tree.service;

import java.util.List;
import java.util.Optional;

/**
 * Created by oleksandr.kydiuk on Apr, 2019
 */
public interface SearchService<T extends Comparable<T>> {

    List<T> findAll();

    Optional<T> find(Object o);
}
