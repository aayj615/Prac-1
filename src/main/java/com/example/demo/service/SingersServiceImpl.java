package com.example.demo.service;


import com.example.demo.entity.Singers;
import com.example.demo.repository.SingersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SingersServiceImpl implements SingersService {
    @Autowired
    private SingersRepo singersRepo;

    @Override
    public List<Singers> getAllSingers() {
        return singersRepo.findAll();
    }

    @Override
    @Transactional
    public Integer saveSingers(Singers singers) {
        return singersRepo.save(singers).getSingerPosition();
    }

    @Override
    @Transactional
    public void update(Singers singers) {
        singersRepo.save(singers);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        singersRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Singers getOneSinger(Integer id) {
        return singersRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean isAvailable(Integer id) {
        return singersRepo.existsById(id);
    }
}
