package com.example.demo.service;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findByTitle(String title) {
        return blogRepository.findByTitle("%"+title+"%");
    }


    @Override
    public List<Blog> loadBlogs(int start, int count) {
        return blogRepository.loadBlogs(start,count);
    }
    @Override
    public List<Blog> searchBlogByCategory(int categoryId) {
        return blogRepository.searchByCategory(categoryId);
    }

    @Override
    public List<Blog> findALL() {
        return blogRepository.findAll();
    }

//    @Override
//    public Page<Blog> findAll(Pageable pageable, String searchTitle) {
//        return blogRepository.findAllByTitleContaining(pageable, searchTitle);
//    }

    @Override
    public boolean add(Blog blog) {
        Blog blog1 = blogRepository.save(blog);
        return blog1!=null;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public boolean update(Blog blog) {
        if(findById(blog.getId()) == null){
            return false;
        } else {
            blogRepository.save(blog);
            return true;
        }
    }

    @Override
    public boolean delete(int id) {
        if(findById(id) == null){
            return false;
        } else {
            blogRepository.deleteById(id);
            return true;
        }
    }
}
