package com.example.exercise.repository;


import com.example.exercise.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByCategory_Id(int categoryId);
}
