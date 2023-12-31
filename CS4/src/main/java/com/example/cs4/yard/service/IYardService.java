package com.example.cs4.yard.service;

import com.example.cs4.yard.model.Yard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IYardService {
    Page<Yard> getYardPage(Pageable pageable ,String name);
    void deleteYard(int id);
    boolean createYard(Yard yard);

    Yard findById (Integer id);

    List<Yard> findAll ();
}
