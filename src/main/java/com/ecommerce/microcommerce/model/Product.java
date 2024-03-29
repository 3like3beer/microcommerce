package com.ecommerce.microcommerce.model;

public class Product {
    private int id;
    private String name;
    private int prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prix=" + prix +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Product(int id, String name, int prix) {
        this.id = id;
        this.name = name;
        this.prix = prix;
    }
}
