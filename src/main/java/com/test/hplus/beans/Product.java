package com.test.hplus.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

//This product bean corresponds to the product table in the database server.
@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private String imagePath;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}
