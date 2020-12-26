package org.example.repositories;

import org.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByCategoryId(Long id, Pageable pageable);

    List<Blog> findAllByTitleContains(String title);

    Page<Blog> findAllByTitleContains(String title, Pageable pageable);
}
