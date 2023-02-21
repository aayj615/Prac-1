package com.example.demo.repository;

import com.example.demo.entity.Singers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SingersRepo extends JpaRepository<Singers, Integer> {
    List<Singers> findAllBySingerPosition(Integer id);
}
