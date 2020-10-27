package com.example.multisource.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STUDENT", schema = "STUDENT")
public class Student implements Serializable {

    @Id
    private Long id;
    private String name;
    private String surname;
}
