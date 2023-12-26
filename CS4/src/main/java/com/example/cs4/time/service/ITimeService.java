package com.example.cs4.time.service;


import com.example.cs4.time.model.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITimeService {
    Page<Time> findAll(Pageable pageable);
    boolean add(Time time);
    boolean delete(int id);
}
