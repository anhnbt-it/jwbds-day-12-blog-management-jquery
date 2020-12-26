package org.example.service;

import org.example.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();
}
