package br.com.metasix.cabal.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan on 5/6/15.
 */
public class Card {

    private long id;
    private String number;
    private String token;
    private long idProduct;

    public Card(long id, String number, String token, long idProduct) {
        this.id = id;
        this.number = number;
        this.token = token;
        this.idProduct = idProduct;
    }

    public static List<Card> getFakeList(){
        List<Card> l = new ArrayList<>();

        l.add(new Card(1, "3214", "aksdhfioasd2354", 1));
        l.add(new Card(2, "3255", "aksdhfioasd2354", 1));
        l.add(new Card(3, "3214", "aksdhfioasd2354", 1));
        l.add(new Card(4, "3214", "aksdhfioasd2354", 1));

        return l;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }
}
