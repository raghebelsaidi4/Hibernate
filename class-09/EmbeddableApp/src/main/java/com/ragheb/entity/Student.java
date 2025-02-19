package com.ragheb.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @EmbeddedId
    private StudentCompositeKey compositeKey;

    private String name;
    private Integer marks;

    public StudentCompositeKey getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(StudentCompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}
