package com.example.exercise.service;



import com.example.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<Blog> getList();

    Blog findById(int id);
    List<Blog> searchBlogByCategory(int categoryId);
}
