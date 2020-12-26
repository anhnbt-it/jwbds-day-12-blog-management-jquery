package org.example.service;

import org.example.model.Blog;
import org.example.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllByTitleContains(String title) {
        return blogRepository.findAllByTitleContains(title);
    }

    @Override
    public Page<Blog> findAllByTitleContains(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContains(title, pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryId(Long id, Pageable pageable) {
        return blogRepository.findAllByCategoryId(id, pageable);
    }

    @Override
    public Blog findOne(Long id) {
        return blogRepository.findOne(id);
    }
}
