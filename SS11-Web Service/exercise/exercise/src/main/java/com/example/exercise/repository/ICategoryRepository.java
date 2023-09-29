package com.example.exercise.repository;


import com.example.exercise.model.Blog;
import com.example.exercise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
//    @Query(value = "select * from blog where category_id =:id",
//            nativeQuery = true)
//    List<Blog> searchByCategory(@Param("id") int id);
}
