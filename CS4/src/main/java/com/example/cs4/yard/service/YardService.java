package com.example.cs4.yard.service;

import com.example.cs4.yard.model.Yard;
import com.example.cs4.yard.repository.IYardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class YardService implements IYardService {
    @Autowired
    private IYardRepository yardRepository;

    @Override
    public Page<Yard> getYardPage(Pageable pageable, String name) {
        return yardRepository.getAllYard(pageable, "%" + name + "%");
    }

    @Transactional
    @Override
    public void deleteYard(int id) {
        Yard yard = yardRepository.findById(id).get();
        if (yard != null) {
            yardRepository.deleteYard(id);
        }
    }

    @Override
    public boolean createYard(Yard yard) {
        Yard yardEntity = yardRepository.save(yard);
        return yardEntity != null;
    }

    @Override
    public Yard findById(Integer id) {
        return yardRepository.findById(id).orElse(null);
    }

    @Override
    public List<Yard> findAll() {
        return yardRepository.findAll();
    }
}
