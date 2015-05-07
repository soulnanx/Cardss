package br.com.metasix.cabal.entity;

/**
 * Created by renan on 5/6/15.
 */
public class Product {

    private long id;
    private String name;
    private int resource;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
