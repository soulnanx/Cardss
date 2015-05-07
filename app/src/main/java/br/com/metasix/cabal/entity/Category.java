package br.com.metasix.cabal.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import br.com.metasix.cabal.R;

/**
 * Created by renan on 5/6/15.
 */
public class Category {

    private long id;
    private String title;
    private int resource;

    public Category(long id, String title, int resource) {
        this.id = id;
        this.title = title;
        this.resource = resource;
    }

    public static List<Category> getFakeList(){
        List<Category> list = new ArrayList<>();
        list.add(new Category(1, "Açougue", R.drawable.carrinho));
        list.add(new Category(2, "Mercado", R.drawable.carrinho));
        list.add(new Category(3, "SuperMercado", R.drawable.carrinho));

        return list;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
