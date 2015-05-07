package br.com.metasix.cabal.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.metasix.cabal.R;

/**
 * Created by renan on 5/6/15.
 */
public class Product {

    private long id;
    private String name;
    private int resource;

    public Product(long id, String name, int resource) {
        this.id = id;
        this.name = name;
        this.resource = resource;
    }

    public static List<Product> getFakeList(){
        List<Product> l = new ArrayList<>();

        l.add(new Product(1, "Cabal Vale Refeição", R.drawable.abc_btn_check_material));
        l.add(new Product(2, "Cabal Vale Alimentação", R.drawable.abc_btn_check_to_on_mtrl_015));
        l.add(new Product(3, "Cabal Combustivel", R.drawable.ic_plusone_standard_off_client));

        return l;
    }

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
