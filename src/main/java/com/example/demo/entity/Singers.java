package com.example.demo.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="Singers")
public class Singers {
    @Id
    @Column(name="position", length = 3)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer singerPosition;
    @Column(name="singerName", length = 15)
    private String singersName;
    @Column(name="singerWages")
    private double singersWages;

    public Integer getSingerPosition() {
        return singerPosition;
    }

    public void setSingerPosition(Integer singerPosition) {
        this.singerPosition = singerPosition;
    }

    public String getSingersName() {
        return singersName;
    }

    public void setSingersName(String singersName) {
        this.singersName = singersName;
    }

    public double getSingersWages() {
        return singersWages;
    }

    public void setSingersWages(double singersWages) {
        this.singersWages = singersWages;
    }
}
