package com.switchfully.parkshark.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "cat_id")
    private int id;

    @Column(name = "cat_name")
    private String categoryName;

    public Category() {
    }
}
