package com.example.demo.repository;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    Page<Blog> findAllByTitleContaining(Pageable pageable,String title);
    @Query(value = "select * from blog where category_id =:id",
    nativeQuery = true)
    List<Blog> searchByCategory(@Param("id") int id);

    @Query(value = "select * from blog where id <=:start and id >=:count",
    nativeQuery = true)
    List<Blog> loadBlogs(@Param("start") int start, @Param("count") int count);
    @Query(value = "select * from blog where title like :title", nativeQuery = true)
    List<Blog> findByTitle(@Param("title")String title);

}
