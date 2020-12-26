package org.example.controller;

import org.example.model.Blog;
import org.example.model.Category;
import org.example.service.BlogService;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> getCategories() {
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Iterable<Blog>> getBlogsByCategoryId(@PathVariable("id") Long id, Pageable pageable) {
        Page<Blog> blogs = blogService.findAllByCategoryId(id, pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
