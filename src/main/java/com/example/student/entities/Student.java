package com.example.student.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private String stream;

    public Student() {

    }

    public Student(int id, String name, String stream) {
        this.id = id;
        this.name = name;
        this.stream = stream;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", stream=" + stream + "]";
    }
    
}
