package com.sda.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Column(name="categoryName",length=255)
    private String categoryName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto
    private int id;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
