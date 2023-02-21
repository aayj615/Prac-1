package com.example.demo.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="Singers")
@Data
public class Singers {
    @Id
    @Column(name="position", length = 3)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer singerPosition;
    @Column(name="singer_name", length = 15)
    private String singersName;
    @Column(name="singer_wages")
    private double singersWages;

}
