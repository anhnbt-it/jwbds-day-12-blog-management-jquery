package org.example.controller;

import org.example.model.Blog;
import org.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public ModelAndView index(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Blog> blogs;
        ModelAndView modelAndView = new ModelAndView("blog/index");
        if (s.isPresent()) {
            System.out.println(s.get());
            blogs = blogService.findAllByTitleContains(s.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("search", s);
        return modelAndView;
    }

    @GetMapping(value = "search/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog> findAllByTitleContains(@PathVariable("query") Optional<String> query) {
        System.out.println(query.get());
        List<Blog> blogs = blogService.findAllByTitleContains(query.get());
        return blogs;
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable("id") Long id) {
        Blog blog = blogService.findOne(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
